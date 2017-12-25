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
        if (a.isEmpty() && b.isEmpty()){
            return;
        }
        if (a.isEmpty()){
            HashSet<Integer> hs = new HashSet<>(b);
            onlyBItems.clear();
            onlyBItems.addAll(hs);
        }
        if (b.isEmpty()){
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

        if (a.isEmpty() && b.isEmpty()){
            return;
        }
        if (a.isEmpty()){
            HashSet<CarProvinceMarket> hs = new HashSet<>(b);
            onlyBItems.clear();
            onlyBItems.addAll(hs);
        }
        if (b.isEmpty()){
            HashSet<CarProvinceMarket> hs = new HashSet<>(a);
            onlyAItems.clear();
            onlyAItems.addAll(hs);
        }

        HashMap<Integer, CarProvinceMarket> map = new HashMap<>();
        HashMap<Integer, CarProvinceMarket> sameMap = new HashMap<>();
        HashMap<Integer, CarProvinceMarket> onlyBMap = new HashMap<>();
        for (CarProvinceMarket item: a){
            map.put(item.getProvinceId(), item);
        }

        for (CarProvinceMarket item: b){
            if (map.containsKey(item.getProvinceId())){
                sameMap.put(item.getProvinceId(), item);
            }else {
                onlyBMap.put(item.getProvinceId(),item);
            }
        }

        sameItems.addAll(sameMap.values());
        onlyBItems.addAll(onlyBMap.values());

        for (CarProvinceMarket item: sameItems){
            map.remove(item.getProvinceId());
        }

        onlyAItems.addAll(map.values());

    }

    public static void main(String [] args){
        /*
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

        */
        System.out.println("======================");

        ArrayList<CarProvinceMarket> aCarProMar = new ArrayList<>();
        ArrayList<CarProvinceMarket> bCarProMar = new ArrayList<>();
        for (int i=0; i<1000000; i++){
            CarProvinceMarket aCar = new CarProvinceMarket();
            aCar.setProvinceId((i + 1)/2);
            aCarProMar.add(aCar);
            CarProvinceMarket bCar = new CarProvinceMarket();
            bCar.setProvinceId((i + 2)/2);
            bCarProMar.add(bCar);
        }

        LinkedList<CarProvinceMarket> sameItems = new LinkedList<>();
        LinkedList<CarProvinceMarket> onlyAItems = new LinkedList<>();
        LinkedList<CarProvinceMarket> onlyBItems = new LinkedList<>();

        Long start = System.currentTimeMillis();
        sameAndDifferentOperation2(aCarProMar, bCarProMar, sameItems, onlyAItems, onlyBItems);
        System.out.println("time = " + (System.currentTimeMillis() - start));

    }
}
