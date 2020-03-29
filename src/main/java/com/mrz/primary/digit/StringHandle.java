package com.mrz.primary.digit;

public class StringHandle {
    public static void main(String[] args) {
        String sentence = "盖伦,在进行了连续8次击杀后,获得了 超神 的称号";

        //截取从第3个开始的字符串 （基0）
        String subString1 = sentence.substring(3);

        System.out.println(subString1);

        //截取从第3个开始的字符串 （基0）
        //到5-1的位置的字符串
        //左闭右开
        String subString2 = sentence.substring(3,5);

        System.out.println(subString2);
    }

    public void charBaseA() {

    }
    public void charBaseAtoLowerCase() {
        String sentence = "Garen";

        //全部变成小写
        System.out.println(sentence.toLowerCase());
        //全部变成大写
        System.out.println(sentence.toUpperCase());

    }
    public void charBaseAtrim() {
        String sentence = "        盖伦,在进行了连续8次击杀后,获得了 超神 的称号      ";

        System.out.println(sentence);
        //去掉首尾空格
        System.out.println(sentence.trim());

    }
    public void charBaseAsplit() {
        String sentence = "盖伦,在进行了连续8次击杀后,获得了 超神 的称号";

        //根据,进行分割，得到3个子字符串
        String subSentences[] = sentence.split(",");
        for (String sub : subSentences) {
            System.out.println(sub);
        }

    }
    public void charBaseAsubstring() {

    }
    public void charBaseAcharAt() {
        String sentence = "盖伦,在进行了连续8次击杀后,获得了 超神 的称号";

        char c = sentence.charAt(0);

        System.out.println(c);
    }
}
