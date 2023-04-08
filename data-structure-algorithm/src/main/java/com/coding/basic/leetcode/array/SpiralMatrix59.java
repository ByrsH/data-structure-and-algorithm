package com.coding.basic.leetcode.array;

/***
 * @description:  https://leetcode.cn/problems/spiral-matrix-ii/
 * @author: yunhui
 * @create: 2023/4/8 3:03 PM
 **/
public class SpiralMatrix59 {

    public int[][] generateMatrix(int n) {
        int t = 0, r = n-1, b = n -1, l = 0;
        int[][] res = new int[n][n];
        int index = 1;
        int n2 = n * n;
        while (index <= n2) {

            // 从左到右
            for (int i = l; i <= r; i++) {
                res[t][i] = index++;
            }
            t++;

            // 从上到下
            for (int i = t; i <= b; i++) {
                res[i][r] = index++;
            }
            r--;

            // 从右到左
            for (int i = r; i >= l; i--) {
                res[b][i] = index++;
            }
            b--;

            // 从下到上
            for (int i = b; i >= t; i--) {
                res[i][l] = index++;
            }
            l++;
        }
        return res;
    }

    public int[][] generateMatrix2(int n) {
        int loop = 0;  // 控制循环次数
        int[][] res = new int[n][n];
        int start = 0;  // 每次循环的开始点(start, start)
        int count = 1;  // 定义填充数字
        int i, j;

        while (loop++ < n / 2) { // 判断边界后，loop从1开始
            // 模拟上侧从左到右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }

            // 模拟右侧从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }

            // 模拟下侧从右到左
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }

            // 模拟左侧从下到上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }

        if (n % 2 == 1) {
            res[start][start] = count;
        }

        return res;
    }

}
