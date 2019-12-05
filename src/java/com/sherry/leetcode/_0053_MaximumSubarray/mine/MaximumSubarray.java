package com.sherry.leetcode._0053_MaximumSubarray.mine;

import java.util.Arrays;

/**
 * 53. 最大子序和
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int[] temp = new int[nums.length];

        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                temp[i] = nums[i];
                continue;
            }
            //  尽可能算最大值
            temp[i] = Math.max(nums[i], nums[i] + temp[i - 1]);
            max = Math.max(max, temp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray demo = new MaximumSubarray();
        int max = demo.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(max);
    }
}
