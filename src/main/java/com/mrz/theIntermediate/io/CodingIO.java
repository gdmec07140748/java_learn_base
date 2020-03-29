package com.mrz.theIntermediate.io;

import java.io.*;
import java.nio.charset.Charset;

/**
 * 编码
 */
public class CodingIO {
    public static void main(String[] args) {
        CodingIO codingIO = new CodingIO();
//        showCode("范");
        codingIO.fileReaderZh();
//        codingIO.fileInputStreamZh();
    }

    /**
     * 读取中文
     */
    public void fileReaderZh() {
        String path_file = TestFile.path + "lol2.txt";
//            准备的文件
        File f1 = new File(path_file);
        System.out.println("默认编码方式:"+ Charset.defaultCharset());

        try (FileReader fr = new FileReader(f1)) {
            char[] cs = new char[(int) f1.length()];
            fr.read(cs);
            System.out.printf("FileReader会使用默认的编码方式%s,识别出来的字符是：%n",Charset.defaultCharset());
            System.out.println(new String(cs));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //FileReader是不能手动设置编码方式的，为了使用其他的编码方式，只能使用InputStreamReader来代替
        //并且使用new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8")); 这样的形式
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(f1), Charset.forName("UTF-8"))) {
            char[] cs = new char[(int) f1.length()];
            isr.read(cs);
            System.out.printf("InputStreamReader 指定编码方式UTF-8,识别出来的字符是：%n");
            System.out.println(new String(cs));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取中文
     * 要设置正确的字符编码，读取才不会乱码
     */
    public void fileInputStreamZh() {
        String path_file = TestFile.path + "lol2.txt";
//            准备的文件
        File f1 = new File(path_file);
        try(FileInputStream fis = new FileInputStream(f1)) {
            byte[] all = new byte[(int) f1.length()];
            fis.read(all);
            //文件中读出来的数据是
            System.out.println("文件中读出来的数据是：");
            for (byte b : all) {
                int i = b&0x000000ff; //只取16进制的后两位
                System.out.println(Integer.toHexString(i));
            }
            System.out.println("把这个数字，放在GBK的棋盘上去：");
            String str = new String(all, "UTF-8");
            System.out.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void zhCoding() {
        String str = "中";
    }

    private static void showCode(String str) {
        String[] encodes = {"BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32"};
        for (String encode : encodes) {
            showCode(str, encode);
        }
    }

    private static void showCode(String str, String encode) {
        try {
            System.out.printf("字符: \"%s\" 的在编码方式%s下的十六进制值是%n", str, encode);
            byte[] bs = str.getBytes(encode);

            for (byte b : bs) {
                int i = b & 0xff;
                System.out.println(Integer.toHexString(i) + "\t");
            }
            System.out.println();
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            System.out.printf("UnsupportedEncodingException: %s编码方式无法解析字符%s\n", encode, str);
            e.printStackTrace();
        }
    }
}
