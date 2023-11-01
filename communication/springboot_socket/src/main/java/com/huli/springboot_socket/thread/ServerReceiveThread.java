package com.huli.springboot_socket.thread;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ServerReceiveThread implements Runnable{
    private Socket socket;
    private static Logger log = LoggerFactory.getLogger(ServerReceiveThread.class);
    private ObjectInputStream ois = null;
    private  ObjectOutputStream oos = null;
    public ServerReceiveThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //输入流接收数据
             ois = new ObjectInputStream(socket.getInputStream());
            //输出流发送数据
             oos = new ObjectOutputStream(socket.getOutputStream());

            while (true){
                JSONObject jsonObject = (JSONObject) ois.readObject();
                System.out.println(jsonObject);
                String message = jsonObject.getString("msg");
                if ("close".equals(message)){
                    oos.writeUTF("close");
                    oos.flush();
                    break;
                }else {
                    oos.writeUTF("接受用户:"+socket.getRemoteSocketAddress() + "的数据：" +message);
                    oos.flush();
                }
            }

            log.info("服务端关闭了客户端[{}]",socket.getRemoteSocketAddress());
            oos.close();
            ois.close();
            socket.close();

        } catch (Exception e) {
            log.info("接受数据异常socket关闭");
            e.printStackTrace();
        }finally {
            log.info("数据异常数据怎么保留");
        }

    }
}
