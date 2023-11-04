package com.huli.springboot_socket.thread;


import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class ServerReader extends Thread{
    private Scanner get;
    public ServerReader(Scanner get){
        this.get=get;
    }

    public void  run(){
        while(true){

            try{
                while(true){
                    System.out.println("收到对端消息："+get.nextLine());
                    //  System.out.print("输入消息：");

                }
            }catch(Exception e){
                System.out.println("连接已中断");
                return;
            }
        }
    }
}

