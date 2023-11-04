package com.huli.springboot_socket.thread;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ServerReceiveThread implements Runnable{
    private Socket socket;
    private static Logger log = LoggerFactory.getLogger(ServerReceiveThread.class);
    private Scanner ois = null;
    private PrintWriter oos = null;
    public ServerReceiveThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //输入流接收数据
            ois = new Scanner(socket.getInputStream());
            //输出流发送数据
            oos = new PrintWriter(socket.getOutputStream());

            while (true){
                String jsonObject = ois.nextLine();
                System.out.println(jsonObject);
                if ("close".equals(jsonObject)){
                    oos.println("close");
                    oos.flush();
                    break;
                }else {
                    oos.println("接受用户:"+socket.getRemoteSocketAddress() + "的数据：" + jsonObject );
                    oos.flush();
                }
            }
            log.info("服务端关闭了客户端[{}]",socket.getRemoteSocketAddress());

        } catch (Exception e) {
            log.info("接受数据异常socket关闭");
            e.printStackTrace();
        }finally {
            log.info("数据异常数据怎么保留");
        }

    }
}
