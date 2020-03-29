package com.mrz.primary.digit.character;

/**
 * 边界条件判断
 *  插入之前，首先要判断的是一些边界条件。 比如插入位置是否合法，插入的字符串是否为空
 *
 * 扩容
 *  1. 要判断是否需要扩容。 如果插入的字符串加上已经存在的内容的总长度超过了容量，那么就需要扩容。
 *  2. 数组的长度是固定的，不能改变的，数组本身不支持扩容。 我们使用变通的方式来解决这个问题。
 *  3. 根据需要插入的字符串的长度和已经存在的内容的长度，计算出一个新的容量。 然后根据这个容量，创建一个新的数组，接着把原来的数组的内容，复制到这个新的数组中来。并且让value这个引用，指向新的数组，从而达到扩容的效果。
 *
 * 插入字符串
 *  1. 找到要插入字符串的位置，从这个位置开始，把原数据看成两段，把后半段向后挪动一个距离，这个距离刚好是插入字符串的长度
 *  2. 然后把要插入的数据，插入这个挪出来的，刚刚好的位置里。
 *
 * 修改length的值
 * 最后修改length的值，是原来的值加上插入字符串的长度
 *
 * insert(int, char)
 *  参数是字符的insert方法，通过调用insert(int, String) 也就实现了。
 *
 * append
 *  追加，就是在最后位置插入。 所以不需要单独开发方法，直接调用insert方法，就能达到最后位置插入的效果
 */
public interface IStringBuffer {
    public void append(String str); //追加字符串
    public void append(char c);  //追加字符
    public void insert(int pos,char b); //指定位置插入字符
    public void insert(int pos,String b); //指定位置插入字符串
    public void delete(int start); //从开始位置删除剩下的
    public void delete(int start,int end); //从开始位置删除结束位置-1
    public void reverse(); //反转
    public int length(); //返回长度
}
