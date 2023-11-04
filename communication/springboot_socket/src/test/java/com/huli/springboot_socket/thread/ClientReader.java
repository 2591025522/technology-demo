package com.huli.springboot_socket.thread;

import java.util.Scanner;

public class ClientReader extends Thread {
    private Scanner scanner;
    public ClientReader(Scanner scanner){
        this.scanner = scanner;
    }
    @Override
    public void run(){
        while (true){
            try {
                while (true){
                    String message = scanner.nextLine();
                    System.out.println("收到服务端消息" +message);
                }
            }catch (Exception e){
                System.out.println("服务端读取连接中断");
                return;
            }
        }

    }
}
