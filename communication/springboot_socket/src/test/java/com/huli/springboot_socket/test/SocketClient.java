package com.huli.springboot_socket.test;

import cn.hutool.json.JSONUtil;

import java.io.*;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) throws InterruptedException {
        try {
            // 和服务器创建连接
//            Socket socket = new Socket("10.255.26.14",18869);
            Socket socket = new Socket("127.0.0.1",1024);

            // 要发送给服务器的信息
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            String message = JSONUtil.toJsonStr("{\"api\":\"c_InspectionItem\",\"data\":{\"InspectionData\":\"xxx\"},\"logId\":1697768948240,\"status\":0}");
            pw.write(message);
            pw.flush();

            socket.shutdownOutput();


//            Thread.sleep(1000);
            // 从服务器接收的信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while((info = br.readLine())!=null){
                System.out.println("我是客户端，服务器返回信息："+info);
            }




            br.close();
            is.close();
            os.close();
            pw.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

