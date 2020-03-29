package com.mrz.theIntermediate.io;

import java.io.*;

/**
 * 所有的数据存放在计算机中都是以数字的形式存放的。 所以字母就需要转换为数字才能够存放。
 *
 * OutputStream是字节输出流，同时也是抽象类，只提供方法声明，不提供方法的具体实现。
 * FileOutputStream 是OutputStream子类，以FileOutputStream 为例向文件写出数据
 */
public class TestStream {
    public static void main(String[] args) {
        TestStream testStream = new TestStream();
        testStream.writeFile();
//        testStream.readFile();
    }

    /**
     * 写入文件内容
     */
    public void writeFile() {
        try {
            String path_file = TestFile.path + "lol2.txt";
//            准备的文件
            File f1 = new File(path_file);
            // 准备长度是2的字节数组，用88,89初始化，其对应的字符分别是X,Y
            byte data[] = { 88, 89 };
            FileOutputStream fos = new FileOutputStream(f1);
//            写入数据
            fos.write(data);
//            关闭输出流
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    读取内容
    public void readFile() {
        try {
            String path_file = TestFile.path + "readme.txt";
//            准备的文件
            File f1 = new File(path_file);
//            创建基本的文件输入流
            FileInputStream fis = new FileInputStream(f1);
//            创建字节数组，其长度就是文件的长度
            byte[] all = new byte[(int) f1.length()];
//            以字节流的形式读取文件所有内容
            fis.read(all);
            for (byte b : all) {
//                打印内容
                System.out.println(b);
            }

            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件流
     */
    public void test1() {
        try {
            String path_file = TestFile.path + "readme.txt";
            File f1 = new File(path_file);
            FileInputStream fis = new FileInputStream(f1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
