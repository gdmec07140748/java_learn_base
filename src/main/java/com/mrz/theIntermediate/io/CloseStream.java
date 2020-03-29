package com.mrz.theIntermediate.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 关闭流的方式
 */
public class CloseStream {
    public static void main(String[] args) {
        CloseStream closeStream = new CloseStream();
        closeStream.tryMethodClose();
    }

    /**
     * 使用try()的方式
     *
     * 把流定义在try()里,try,catch或者finally结束的时候，会自动关闭
     * 这种编写代码的方式叫做 try-with-resources， 这是从JDK7开始支持的技术
     *
     * 所有的流，都实现了一个接口叫做 AutoCloseable，任何类实现了这个接口，都可以在try()中进行实例化。 并且在try, catch, finally结束的时候自动关闭，回收相关资源。
     */
    public void tryMethodClose() {
        String path_file = TestFile.path + "lol2.txt";
//            准备的文件
        File f1 = new File(path_file);

        try(FileInputStream fis = new FileInputStream(f1)){
            byte[] all = new byte[(int) f1.length()];
            fis.read(all);
            for (byte b : all) {
                System.out.println(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在finally中关闭
     *
     * 这是标准的关闭流的方式
     * 1. 首先把流的引用声明在try的外面，如果声明在try里面，其作用域无法抵达finally.
     * 2. 在finally关闭之前，要先判断该引用是否为空
     * 3. 关闭的时候，需要再一次进行try catch处理
     *
     * 这是标准的严谨的关闭流的方式，但是看上去很繁琐，所以写不重要的或者测试代码的时候，都会采用上面的有隐患try的方式
     */
    public void finallyClose() {
        FileInputStream fis = null;
        try {
            String path_file = TestFile.path + "lol2.txt";
//            准备的文件
            File f1 = new File(path_file);
             fis = new FileInputStream(f1);
            byte[] all = new byte[(int) f1.length()];
            fis.read(all);
            for (byte b : all) {
                System.out.println(b);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != fis) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * 在try中关闭
     */
    public void tryClose() {

        try {
            String path_file = TestFile.path + "lol2.txt";
//            准备的文件
            File f1 = new File(path_file);
            FileInputStream fis = new FileInputStream(f1);
            byte[] all = new byte[(int) f1.length()];
            fis.read(all);
            for (byte b : all) {
                System.out.println(b);
            }
            // 在try 里关闭流
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
