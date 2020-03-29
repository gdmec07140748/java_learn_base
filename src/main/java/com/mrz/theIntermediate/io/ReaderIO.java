package com.mrz.theIntermediate.io;

import java.io.*;

/**
 * Reader字符输入流
 * Writer字符输出流
 * 专门用于字符的形式读取和写入数据
 */
public class ReaderIO {
    public static void main(String[] args) {
        ReaderIO readerIO = new ReaderIO();
        readerIO.writeTest();
        readerIO.readerTest();
    }

    /**
     * 写入内容
     */
    public void writeTest() {
        String path_file = TestFile.path + "lol2.txt";
//            准备的文件
        File f1 = new File(path_file);
        try (FileWriter fw = new FileWriter(f1)) {
            String data = "abcdefg1234567890";
            char[] cs = data.toCharArray();
            fw.write(cs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 读取内容
     */
    public void readerTest() {
        String path_file = TestFile.path + "lol2.txt";
//            准备的文件
        File f1 = new File(path_file);
        try (FileReader fr = new FileReader(f1)) {
            char[] all = new char[(int) f1.length()];
            fr.read(all);
            for (char b : all) {
                System.out.println(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
