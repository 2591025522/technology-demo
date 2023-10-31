package com.huli.springboot_socket.test;

import com.alibaba.fastjson.JSONObject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class ClientPrintThread implements Runnable{
    private String host;
    private int port;
    private ObjectOutputStream oos = null;
    private ObjectInputStream ois = null;
    public ClientPrintThread(String host,int port){
        this.host = host;
        this.port = port;
    }
    @Override
    public void run() {
        try {
            Socket socket = new Socket(host,port);
            System.out.println("业务socket链接成功");
            //输出流写数据
            oos = new ObjectOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            //输入流读数据
             ois = new ObjectInputStream(socket.getInputStream());
            while (true){
                String str = scanner.nextLine();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("type","body");
                jsonObject.put("msg",str);
                oos.writeObject(jsonObject);
                oos.flush();
                //写的部分
                String message = ois.readUTF();
                System.out.println("接收到服务端地址" + socket.getRemoteSocketAddress() + "信息：" + message);
                if ("close".equals(message)){
                    break;
                }
            }
            ois.close();
            oos.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
