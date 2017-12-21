package com.coding.basic.array;

import java.util.*;
import java.util.ArrayList;

/**
 * 列表的交集、差集运算
 *
 * @author ByrsH
 * @create 2017-12-19 23:17
 **/

public class ArrayOperation {

    public static void sameAndDifferentOperation(List<Integer> a, List<Integer> b, List<Integer> sameItems,
                                                 List<Integer> onlyAItems, List<Integer> onlyBItems){
        if (isEmpty(a) && isEmpty(b)){
            return;
        }
        if (isEmpty(a)){
            HashSet<Integer> hs = new HashSet<>(b);
            onlyBItems.clear();
            onlyBItems.addAll(hs);
        }
        if (isEmpty(b)){
            HashSet<Integer> hs = new HashSet<>(a);
            onlyAItems.clear();
            onlyAItems.addAll(hs);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> sameItemSet = new HashSet<>();
        Set<Integer> onlyBItemSet = new HashSet<>();
        for (Integer item: a){
            map.put(item, item);
        }

        for (Integer item: b){
            if (map.containsKey(item)){
                sameItemSet.add(item);
            }else {
                onlyBItemSet.add(item);
            }
        }

        //去除重复元素
        sameItems.addAll(sameItemSet);
        onlyBItems.addAll(onlyBItemSet);

        for (Integer item: sameItems){
            map.remove(item);
        }
        onlyAItems.addAll(map.values());

    }

    public static void sameAndDifferentOperation2(List<CarProvinceMarket> a, List<CarProvinceMarket> b, List<CarProvinceMarket> sameItems,
                                                 List<CarProvinceMarket> onlyAItems, List<CarProvinceMarket> onlyBItems){
        HashMap<Integer, CarProvinceMarket> map = new HashMap<>();
        for (CarProvinceMarket item: a){
            map.put(item.getProvinceId(), item);
        }

        for (CarProvinceMarket item: b){
            if (map.containsKey(item.getProvinceId())){
                sameItems.add(item);
            }else {
                onlyBItems.add(item);
            }
        }


    }

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
        for (int i=0; i<1000000; i++){
            a.add(i + 1);
            b.add(i + 2);
        }

        LinkedList<Integer> sameItems = new LinkedList<>();
        LinkedList<Integer> onlyAItems = new LinkedList<>();
        LinkedList<Integer> onlyBItems = new LinkedList<>();
        Long start = System.currentTimeMillis();
        sameAndDifferentOperation(a, b, sameItems, onlyAItems, onlyBItems);

        System.out.println("time = " + (System.currentTimeMillis() - start));

        System.out.println("======================");

        HashMap<Integer, Integer> set = new HashMap<>();
        set.put(1000000,1);
        set.put(1000000,2);
        System.out.println(set.size());

    }
}
