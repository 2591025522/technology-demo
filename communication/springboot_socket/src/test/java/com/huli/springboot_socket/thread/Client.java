package com.huli.springboot_socket.thread;

import javax.xml.ws.Holder;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {

    private PrintWriter printWriter;
    private Scanner scanner;
    private String host;
    private int port;
    private Socket socket;

    private Client(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            this.socket = new Socket(host, port);
            this.scanner = new Scanner(socket.getInputStream());
            this.printWriter = new PrintWriter(socket.getOutputStream());
            System.out.println("第一步：成功创建socket!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Client connect(String host, int port) {
        return new Client(host,port);
    }
    @Override
    public void run() {
        super.run();
    }

    public void onRead(){
        new Thread(new ClientReader(scanner)).start();
    }

    public void sendMessage (String message){
        new Thread(new ClientWrite(this.printWriter,message)).start();
    }
}