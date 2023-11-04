package com.huli.springboot_socket.server;





import com.huli.springboot_socket.thread.ServerReader;
import com.huli.springboot_socket.thread.ServerWrite;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws Exception{
        PrintWriter out=null;
        Scanner get = null;
        ServerSocket server=new ServerSocket(1024);
        System.out.println("服务器正在运行，等待客户端连接！");
        while (true){

            Socket client=new Socket();
            client=server.accept();
            System.out.println(client.getInetAddress()+" 已成功连接到此台服务器上。");

            out = new PrintWriter(client.getOutputStream());
            get = new Scanner(client.getInputStream());


            new ServerWrite(out).start();
            new ServerReader(get).start();

        }
    }
}
