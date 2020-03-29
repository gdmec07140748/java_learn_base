package com.mrz.theIntermediate.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestFile {
    public static String path = "/Users/mrz/Desktop/java-base/learnBase/base/src/main/java/com/mrz/theIntermediate/io/resources/";

    public static void main(String[] args) {
        TestFile testFile = new TestFile();
        testFile.methodFile2();
//        testFile.methodFile();
//        testFile.knowFile();

    }

    public void methodFile2() {
        String path_file = path + "readme.txt";
        File f1 = new File(path_file);

//        以字符串数组形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        f1.list();

//        以文件数组形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        File[] fs = f1.listFiles();

//        以字符串形式返回获取所在文件夹
        f1.getParent();

//        以文件形式返回获取所在文件夹
        f1.getParentFile();

//        创建文件夹，如果父文件夹 skin 不存在，创建无效
        f1.mkdir();

//        创建文件夹，如果父文件夹 skin 不存在，就会创建文件夹
        f1.mkdirs();

//        创建一个空文件，如果父文件夹 skin 不存在，就会抛出异常
        try {
            f1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        创建一个空文件之前，通常都会创建父目录
        f1.getParentFile().mkdirs();

//        列出所有盘符 ，mac 没有这个函数
//        f1.listRoots();

//        删除文件
        f1.delete();

//      JVM 结束的时候，删除文件，常用于临时文件的删除
        f1.deleteOnExit();

    }
    public void methodFile() {
        String path_file = path + "readme.txt";
        File f1 = new File(path_file);
        System.out.println("当前文件是：" + f1);
//        文件是否存在
        System.out.println("判断文件是否存在" + f1.exists());

//        是否为文件夹
        System.out.println("判断是否为文件夹：" + f1.isDirectory());

//        是否是文件（非文件夹）
        System.out.println("判断是否是文件：" + f1.isFile());

//        文件长度
        System.out.println("获取文件长度" + f1.length());

//        文件最后修改时间
        long time = f1.lastModified();
        Date d = new Date(time);
        System.out.println("获取文件最后修改时间" + d);
//        设置文件修改时间为 1970.1.1 08:00:00
        f1.setLastModified(0);

        // 文件重名
        File f2 = new File(path_file + "re.txt");
        f1.renameTo(f2);
        System.out.println("把 readme.txt 改为 re.txt");
    }

    /**
     * 文件基本了解
     */
    public void knowFile() {
        // 绝对路径
        File f1 = new File(path);
        System.out.println("f1 的绝对路径：" + f1.getAbsolutePath());

//        相对目录,相对于工作目录，这里是 base
        File f2 = new File("readme2.txt");
        System.out.println("f2 的绝对路径：" + f2.getAbsolutePath());

//        把 f1 作为父目录创建文件对象
        File f3 = new File(f1, "create.txt");

        System.out.println("f3 的绝对路径" + f3.getAbsolutePath());
    }


}
