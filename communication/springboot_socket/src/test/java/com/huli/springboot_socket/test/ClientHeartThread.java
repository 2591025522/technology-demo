package com.huli.springboot_socket.test;

import com.alibaba.fastjson.JSONObject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHeartThread implements Runnable{
    private String host;
    private int port;

    private ObjectOutputStream oos = null;

    private ObjectInputStream ois = null;

    public ClientHeartThread(String host, int port){
        this.host = host;
        this.port = port;
    }
    @Override
    public void run() {
        try{
            Socket socket = new Socket(host,port);
            //输出流写数据
             oos = new ObjectOutputStream(socket.getOutputStream());
            //输入流读数据
             ois = new ObjectInputStream(socket.getInputStream());
            int i =0;
            while (true){
                Thread.sleep(3000);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("type","heart");
                jsonObject.put("msg","第"+ i + "次心跳");
                System.out.println("发送心跳socket");
                oos.writeObject(jsonObject);
                oos.flush();
                i++;
                String message = ois.readUTF();
                System.out.println("接收到服务端响应" + message);
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
