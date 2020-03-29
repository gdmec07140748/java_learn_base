package com.mrz.theIntermediate.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 收发数字
 * 收发字符串
 */
public class ScannerClient {

    public static void main(String[] args) {
        ScannerClient client = new ScannerClient();
        client.sendScanner();
    }

    /**
     * 发送数字
     */
    public void sendScanner() {
        try {
            int port = 8888;
//            打开发送数据对象
            Socket s = new Socket("127.0.0.1", port);
            System.out.println(s);

//            要发送的数据

//            打开输出流
            OutputStream os = s.getOutputStream();

            DataOutputStream dos = new DataOutputStream(os);

//           使用 Scanner 读取控制台的输入，并发送到服务端
            Scanner sc = new Scanner(System.in);
            String str = sc.next();

            dos.writeUTF(str);

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
