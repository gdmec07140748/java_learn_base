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
public class IntClient {

    public static void main(String[] args) {
        IntClient client = new IntClient();
        client.sendInt();
    }

    /**
     * 发送数字
     */
    public void sendInt() {
        try {
            int port = 8888;
//            打开发送数据对象
            Socket s = new Socket("127.0.0.1", port);
            System.out.println(s);

//            要发送的数据

//            打开输出流
            OutputStream os = s.getOutputStream();
//            填入数字
            os.write(110);

//            关闭
            os.close();
            s.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
