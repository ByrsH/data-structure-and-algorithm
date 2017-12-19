package com.coding.basic.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 数组的交集、差集、并集等运算
 *
 * @author ByrsH
 * @create 2017-12-19 23:17
 **/

public class ArrayOperation {
    public static void main(String [] args){
        int[] a = {1,2,3,4,5};
        int[] b = {2,3,7,8,9,0};
        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> sameItems = new LinkedList<>();
        LinkedList<Integer> onlyBItems = new LinkedList<>();
        for (int item: a){
            if (!map.containsKey(item)){
                map.put(item, item);
            }
        }
        for (int item: b){
            if (map.containsKey(item)){
                sameItems.add(item);
            }else {
                onlyBItems.add(item);
            }
        }
        for (Integer item: sameItems){
            map.remove(item);
        }
        Integer[] onlyAItems = new Integer[map.size()];
        map.values().toArray(onlyAItems);
    }
}
