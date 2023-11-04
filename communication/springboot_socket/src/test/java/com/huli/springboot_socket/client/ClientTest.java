package com.huli.springboot_socket.client;

import com.huli.springboot_socket.test.ClientPrintThread;
import com.huli.springboot_socket.thread.Client;

import com.huli.springboot_socket.thread.ClientWrite;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
public class ClientTest {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);
    private static String host = "127.0.0.1";
    private static int port = 1024;
    public static void main(String[] args) {

        Client client = Client.connect(host,port);
//        client.connect(host,port);
        client.onRead();
        client.sendMessage("1");
        client.sendMessage("1");
        client.sendMessage("1");
        client.sendMessage("1");
        client.sendMessage("1");
        client.sendMessage("1");
        client.sendMessage("1");
//        client.sendMessage("123");
//        ClientWrite.sendMessage(client.getPrintWriter(),"123");


//        executorService.execute(new ClientPrintThread(host,port));
//        executorService.execute(new ClientHeartThread(host,port));
//        new Thread(new ClientPrintThread(host,port)).start();
//        new Thread(new ClientHeartThread(host,port)).start();
    }

}
