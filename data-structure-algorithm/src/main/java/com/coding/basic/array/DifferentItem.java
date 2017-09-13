package com.coding.basic.array;

import java.util.List;

/**
 * Created by yrs on 2017/9/13.
 *
 * 问题描述：A，B两个数组，找出A中有的元素，而B中没有的元素。 B中有的元素，而A中没有。
 *
 * 解决思路：两个for循环，如果元素相等，则去除该元素。去除相同的元素，剩余就是对方没有的元素。
 * （注意：删除元素后数组长度会变小，对应的索引也应减1（break退出里层for循环））
 *
 */
public class DifferentItem {
    public static void main(String [] args) {
        List<Integer> listA = new java.util.ArrayList<Integer>();
        List<Integer> listB = new java.util.ArrayList<Integer>();
        listA.add(1);
        listA.add(2);
        listA.add(3);
        listA.add(5);
        listB.add(1);
        listB.add(2);
        listB.add(4);
        listB.add(6);
        for (int i=0; i<listA.size(); i++) {
            for (int j=0; j<listB.size(); j++) {
                if (listA.get(i) == listB.get(j)) {
                    listA.remove(i);
                    listB.remove(j);
                    i--;
                    j--;
                    break;
                }
            }
        }
        System.out.println(listA);
        System.out.println(listB);
    }
}
