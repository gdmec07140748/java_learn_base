package com.mrz.theIntermediate.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 收发数字
 * 收发字符串
 */
public class StringClient {

    public static void main(String[] args) {
        StringClient client = new StringClient();
        client.sendString();
    }

    /**
     * 发送字符串
     */
    public void sendString() {
        try {
            int port = 8888;
//            打开发送数据对象
            Socket s = new Socket("127.0.0.1", port);
            System.out.println(s);

//            要发送的数据

//            打开输出流
            OutputStream os = s.getOutputStream();

            DataOutputStream dos = new DataOutputStream(os);
//            使用 writeUTF 发送字符串
            dos.writeUTF("client 发送字符串！");

//            关闭
            dos.close();
            os.close();
            s.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
