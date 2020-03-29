package com.mrz.theIntermediate.assemble.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 * 实现
 * 遍历
 * 二叉树的遍历分左序，中序，右序
 *  左序即： 中间的数遍历后放在左边
 *  中序即： 中间的数遍历后放在中间
 *  右序即： 中间的数遍历后放在右边
 */
public class Node {

//    左子节点
    public Node leftNode;
//    右子节点
    public Node rightNode;

//    值
    public Object value;

    /**
     * 插入数据
     * @param v
     */
    public void add(Object v) {
//        如果当前节点没有值，就把数据放在当前节点上
        if (null == value) {
            value = v;
        }else {

//        如果当前节点有值，就进行判断，新增与当前值的大小关系
            if ((Integer) v - ((Integer) value) <= 0) {
                if (null == leftNode)
                    leftNode = new Node();
                leftNode.add(v);
            }else {
//        新增的值，比当前大
                if (null == rightNode)
                    rightNode = new Node();
                rightNode.add(v);
            }
        }
    }

    /**
     * 中序遍历所有的节点
     * @return
     */
    public List<Object> values() {

        List<Object> values = new ArrayList<>();

        // 左节点遍历结果
        if (null != leftNode)
            values.addAll(leftNode.values());

//        当前节点
        values.add(value);

//        右节点遍历结果
        if (null != rightNode)
            values.addAll(rightNode.values());

        return values;


    }

    public static void main(String[] args) {
        int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };
        Node roots = new Node();
        for (int number : randoms) {
            roots.add(number);
        }

        System.out.println(roots.values());
    }
}
