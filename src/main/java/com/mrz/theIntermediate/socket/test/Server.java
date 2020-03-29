package com.mrz.theIntermediate.socket.test;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1. 服务端开启8888端口，并监听着，时刻等待着客户端的连接请求
 * 2. 客户端知道服务端的ip地址和监听端口号，发出请求到服务端
 *  客户端的端口地址是系统分配的，通常都会大于1024
 * 一旦建立了连接，服务端会得到一个新的Socket对象，该对象负责与客户端进行通信。
 * 注意： 在开发调试的过程中，如果修改过了服务器Server代码，要关闭启动的Server,否则新的Server不能启动，因为8888端口被占用了
 */
public class Server {

    public static void main(String[] args) {

        Server s = new Server();
        s.getString();
//        s.getInt();
    }


    /**
     * 接收字符串
     */
    public void getString() {
        try {
            int port = 8888;
//            开启监听
            ServerSocket ss = new ServerSocket(port);

            System.out.println("监听端口号："+port);
//            客户端 请求
            Socket s = ss.accept();

            System.out.println("有连接过来："+s);

//            读取数据

//            打开输入流
            InputStream is = s.getInputStream();

//            把输入流封装在DataInputStream
            DataInputStream dis = new DataInputStream(is);
            //使用readUTF读取字符串
            String msg = dis.readUTF();
//            打印
            System.out.println(msg);

//            关闭
            is.close();
            dis.close();
            s.close();
            ss.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 接收数字
     */
    public void getInt() {
        try {
            int port = 8888;
//            开启监听
            ServerSocket ss = new ServerSocket(port);

            System.out.println("监听端口号："+port);
//            客户端 请求
            Socket s = ss.accept();

            System.out.println("有连接过来："+s);

//            读取数据

//            打开输入流
            InputStream is = s.getInputStream();
//            获取数据
            int msg = is.read();
//            打印
            System.out.println(msg);

//            关闭
            is.close();
            s.close();
            ss.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
