package com.mrz.theIntermediate.socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class KnowSocket {

    public static void main(String[] args) throws IOException {
        KnowSocket knowSocket = new KnowSocket();
        knowSocket.pingSocket();
//        knowSocket.getIp();
    }

    /**
     * ping 指令测试
     * @throws IOException
     */
    public void pingSocket() throws IOException {
        Process p = Runtime.getRuntime().exec("ping " + "192.168.1.101");
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine() )!= null) {
            if (line.length() != 0) {
                sb.append(line + "\r\n");
            }
        }
        System.out.println("本次指令的返回的消息是：");
        System.out.println(sb.toString());
    }
    /**
     * 获取本机 ip 地址
     * @throws UnknownHostException
     */
    public void getIp() throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();

        System.out.println("本机 ip 地址：" + ip);
    }
}
