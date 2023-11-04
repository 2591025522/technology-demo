package com.huli.springboot_socket.test;

import cn.hutool.json.JSONUtil;
import com.huli.springboot_socket.test.WebSocketMessage;

import java.io.*;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) throws InterruptedException {
        BufferedReader br;
        OutputStream os;
        PrintWriter pw;
        InputStream is;
        try {
            // 和服务器创建连接
            Socket socket = new Socket("10.255.26.14",18869);
//            Socket socket = new Socket("127.0.0.1", 1024);
            while (true) {
                // 要发送给服务器的信息
                os = socket.getOutputStream();
                pw = new PrintWriter(os);
                WebSocketMessage webSocketMessage = WebSocketMessage.create("{\"api\":\"c_InspectionItem\",\"data\":{\"InspectionData\":\"xxx\"},\"logId\":1697768948240,\"status\":0}");
                System.out.println(webSocketMessage);
                String message = JSONUtil.toJsonStr(webSocketMessage);
                pw.write(message);
                pw.flush();

                socket.shutdownOutput();

                // 从服务器接收的信息

                is = socket.getInputStream();
                br = new BufferedReader(new InputStreamReader(is));
                String info = null;
                while ((info = br.readLine()) != null) {
                    System.out.println("我是客户端，服务器返回信息：" + info);
                }
                System.out.println("test");
                break;
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

