package com.coding.basic.serach;

import java.util.Arrays;

public class BinarySearch {

    public static int rank(int key, int[] a){
        if (a.length == 0){
            return -1;
        }

        int lo = 0;
        int hi = a.length -1;
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            if (key < a[mid]){
                hi = mid -1;
            }else if (key > a[mid]){
                lo = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String [] args){
        int[] whitelist = {123, 456, 789, 908, 111, 222, 333, 565};
        Arrays.sort(whitelist);

        int[] keys = {222, 342, 567,456};
        for (int key: keys){
            if (rank(key, whitelist) == -1){
                System.out.println(key);
            }
        }
    }

}
