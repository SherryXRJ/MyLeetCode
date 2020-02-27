package com.sherry.leetcode._0057_InsertInterval.mine;

import java.util.*;

/**
 * 57. 插入区间
 * <p>
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) return new int[][]{newInterval};
        if (newInterval == null || newInterval.length == 0) return intervals;

        //  合并两个数组
        int[][] mergeInterval = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            mergeInterval[i] = intervals[i];
        }
        mergeInterval[intervals.length] = newInterval;



        int[][] temp = new int[mergeInterval.length][2];
        sort(mergeInterval, 0, mergeInterval.length - 1);

        int index = 1;
        temp[0] = mergeInterval[0];

        for (int i = 1; i < mergeInterval.length; i++) {
            int[] cur = mergeInterval[i];
            int[] pre = temp[index - 1];

            //  位于区间内
            if (cur[0] >= pre[0] && cur[0] <= pre[1]) {
                int min = Math.min(cur[0], pre[0]);
                int max = Math.max(cur[1], pre[1]);
                temp[index - 1][0] = min;
                temp[index - 1][1] = max;
            } else {
                temp[index] = cur;
                ++index;
            }

        }
        int[][] result = new int[index][2];
        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public void sort(int[][] arrays, int start, int end) {
        if (start > end) {
            return;
        }

        int i = start, j = end;
        int[] pivot = arrays[start];
        while (i < j) {
            while (i < j && arrays[j][0] >= pivot[0]) {
                --j;
            }

            while (i < j && arrays[i][0] <= pivot[0]) {
                ++i;
            }

            if (i < j) {
                int[] temp = arrays[i];
                arrays[i] = arrays[j];
                arrays[j] = temp;
            }
        }

        //  交换pivot
        arrays[start] = arrays[j];
        arrays[j] = pivot;


        //  左边
        sort(arrays, start, j - 1);

        //  右边
        sort(arrays, j + 1, end);
    }

    public static void main(String[] args) {
        InsertInterval demo = new InsertInterval();
//        int[][] result = demo.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
//        int[][] result = demo.insert(new int[][]{{1, 3}, {6,9}}, new int[]{2, 5});
//        int[][] result = demo.insert(new int[][]{}, new int[]{2, 5});
        int[][] result = demo.insert(new int[][]{{1,5}}, new int[]{6,8});
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }

    }
}
