package com.coding.basic.array;

import java.util.*;
import java.util.ArrayList;

/**
 * 数组的交集、差集、并集等运算
 *
 * @author ByrsH
 * @create 2017-12-19 23:17
 **/

public class ArrayOperation {

    public static void sameAndDifferentOperation(List<Integer> a, List<Integer> b, LinkedList<Integer> sameItems,
                                                 Integer[] onlyAItems, LinkedList<Integer> onlyBItems){
        if (isEmpty(a) && isEmpty(b)){
            return;
        }
        if (isEmpty(a)){
            onlyBItems = (LinkedList<Integer>) b;
        }
        if (isEmpty(b)){
            onlyAItems = new Integer[a.size()];
            for (int i=0; i<onlyAItems.length; i++){
                onlyAItems[i] = a.get(i);
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer item: a){
            if (!map.containsKey(item)){
                map.put(item, item);
            }
        }

        for (Integer item: b){
            if (map.containsKey(item)){
                //防止重复添加
                //if (!sameItems.contains(item)){
                    sameItems.add(item);
                //}
            }else {
                //防止重复添加
                //if (!onlyBItems.contains(item)){
                    onlyBItems.add(item);
                //}

            }
        }

        HashSet h = new HashSet(sameItems);
        sameItems.clear();
        sameItems.addAll(h);

        HashSet h2 = new HashSet(onlyBItems);
        onlyBItems.clear();
        onlyBItems.addAll(h2);

        for (Integer item: sameItems){
            map.remove(item);
        }

        onlyAItems = new Integer[map.size()];
        map.values().toArray(onlyAItems);
    }

    public static void sameAndDifferentOperation(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> sameItems){
        if (isEmpty(a) && isEmpty(b)){
            return;
        }
        if (isEmpty(a)){
            HashSet h = new HashSet(b);
            b.clear();
            b.addAll(h);
        }
        if (isEmpty(b)){
            HashSet h = new HashSet(a);
            a.clear();
            a.addAll(h);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<a.size(); i++){
            if (!map.containsKey(a.get(i))){
                map.put(a.get(i), a.get(i));
            }else{
                a.remove(i);
                i--;
            }
        }
        System.out.println();
        for (int i=0; i<b.size(); i++){
            if (map.containsKey(b.get(i))){
                //防止重复添加
                //if (!sameItems.contains(item)){
                sameItems.add(b.get(i));
                b.remove(i);
                i--;
                //}
            }else {
                //防止重复添加
                //if (!onlyBItems.contains(item)){

                //}

            }
        }

        HashSet h = new HashSet(sameItems);
        sameItems.clear();
        sameItems.addAll(h);

    }

//    public static void sameAndDifferentOperation(List<Integer> a, List<Integer> b, ){
//
//    }

    public static Boolean isEmpty(List<Integer> a){
        if (a == null || a.size() == 0){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String [] args){
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for (int i=0; i<400000; i++){
            a.add(i + 1);
            b.add(i + 2);
        }

        ArrayList<Integer> sameItems = new ArrayList<>();
        LinkedList<Integer> onlyBItems = new LinkedList<>();
        Integer[] onlyAItems = null;
        Long start = System.currentTimeMillis();
        sameAndDifferentOperation(a, b, sameItems);

        System.out.println("time = " + (System.currentTimeMillis() - start));



    }
}
