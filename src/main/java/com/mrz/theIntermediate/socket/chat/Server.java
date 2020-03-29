package com.mrz.theIntermediate.socket.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 这是因为接受和发送都在主线程中，不能同时进行。 为了实现同时收发消息，基本设计思路是把收发分别放在不同的线程中进行
 *
 *  1. SendThread 发送消息线程
 *  2. RecieveThread 接受消息线程
 *  3. Server一旦接受到连接，就启动收发两个线程
 *  4. Client 一旦建立了连接，就启动收发两个线程
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);

            System.out.println("监听端口号：8888");

            Socket s =ss.accept();

//            启动发送消息线程
            new SendThread(s).start();
//            启动接收消息线程
            new RecieveThread(s).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
