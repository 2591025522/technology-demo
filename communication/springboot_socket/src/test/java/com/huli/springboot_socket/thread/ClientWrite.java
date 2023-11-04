package com.huli.springboot_socket.thread;

import java.io.PrintWriter;

public class ClientWrite extends Thread{
    private PrintWriter printWriter;
    private String  message ;
    public ClientWrite(PrintWriter printWriter, String message){
        this.printWriter = printWriter;
        this.message = message;
    }
    @Override
    public void run(){
            try {
                printWriter.println(message);
                printWriter.flush();
            }catch (Exception e){
                System.out.println("写入连接断开");
            }
        }
    }

