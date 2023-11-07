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
        int i = 0;
        while(true){
            try{
                get_key = new Scanner(System.in);
                String msg=get_key .nextLine();
                if(msg!=null){
                    msg = "{\"api\":\"c_InspectionItem\",\"data\":{\"InspectionData\":\"xxx\"},\"logId\":1697768948240,\"status\":0}";
                }
                if (i==1){
                    msg = msg + "你好：---";
                }
                out.println(msg);
                out.flush();
                //    System.out.println("请输入消息：");
                i++;
            }catch(Exception e){
                System.out.println("连接已断开！");
                return;
            }
        }
    }
}

