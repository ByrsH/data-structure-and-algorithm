//package com.coding.basic.collection.map;
//
//import net.mindview.util.CountingMapData;
//
//import java.util.Iterator;
//import java.util.TreeMap;
//import net.mindview.util.*;
//
//import static jdk.nashorn.internal.objects.Global.print;
//import static net.mindview.util.Print.*;
//
///**
// * treeMap测试demo
// *
// * @author ByrsH
// * @create 2018-03-04 12:40
// **/
//
//public class SortedSetDemo {
//    public static void main(String [] args){
//        TreeMap<Integer, String> sortedMap = new TreeMap<Integer, String>(new CountingMapData(10));
//        print(sortedMap);
//        Integer low = sortedMap.firstKey();
//        Integer high = sortedMap.lastKey();
//        print(low);
//        print(high);
//        Iterator<Integer> it = sortedMap.keySet().iterator();
//        for (int i=0; i<=6; i++){
//            if (i == 3) low = it.next();
//            if (i == 6) high = it.next();
//            else it.next();
//        }
//        print(low);
//        print(high);
//        print(sortedMap.subMap(low, high));
//        print(sortedMap.headMap(high));
//        print(sortedMap.tailMap(low));
//    }
//}
