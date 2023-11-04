package com.huli.springboot_socket.thread;


import java.io.PrintWriter;
import java.util.Scanner;

public class ServerWrite extends Thread{

    private Scanner scanner;
    private PrintWriter out;
    private Scanner get_key = null;
    public ServerWrite(PrintWriter out){
        this.out=out;
    }
    public void  run(){
        out.println("服务端：已成功连接到远程服务器！");
        out.flush();//将缓冲流中的数据全部输出
        while(true){
            try{
                get_key = new Scanner(System.in);
                String msg=get_key .nextLine();
                if(msg!=null){
                    msg = "{\"api\":\"c_InspectionItem\",\"data\":{\"InspectionData\":\"xxx\"},\"logId\":1697768948240,\"status\":0}";
                }
                out.println(msg);
                out.flush();
                //    System.out.println("请输入消息：");
            }catch(Exception e){
                System.out.println("连接已断开！");
                return;
            }
        }
    }
}

