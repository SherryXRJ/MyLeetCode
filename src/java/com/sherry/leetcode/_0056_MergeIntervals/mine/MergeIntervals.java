package com.sherry.leetcode._0056_MergeIntervals.mine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 * <p>
 * 给出一个区间的集合，请合并所有重叠的区间。
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[][]{};
        if (intervals.length == 1) return intervals;

        int[][] temp = new int[intervals.length][2];
        sort(intervals, 0, intervals.length - 1);

        int index = 1;
        temp[0] = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
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
//        int[][] a = new int[][]{{2,6},{1,3}, {15,18},{8,10}};
        int[][] a = new int[][]{{1,4},{0,0}};
        MergeIntervals demo = new MergeIntervals();
        int[][] ints = demo.merge(a);
        for (int[] t : ints) {
            System.out.println(Arrays.toString(t));
        }
    }
}
