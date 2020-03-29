package com.mrz.theIntermediate.socket.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 可以接收消息和发送消息
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 8888);

//            启动发送消息线程
            new SendThread(s).start();
//            启动接收消息线程
            new RecieveThread(s).start();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
