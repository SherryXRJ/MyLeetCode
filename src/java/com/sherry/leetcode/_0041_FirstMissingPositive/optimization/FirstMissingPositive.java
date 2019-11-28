package com.sherry.leetcode._0041_FirstMissingPositive.optimization;

import java.util.Arrays;

/**
 * 41. 缺失的第一个正数
 *
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        if (nums.length == 1) return nums[0] == 1 ? 2 : 1;

        fix(nums);
        System.out.println(Arrays.toString(nums));

        if (nums[0] >= 1 && nums[0] < nums.length && nums[nums[0]] != nums[0] + 1) swap(nums, 0, nums[0]);
        System.out.println(Arrays.toString(nums));

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public void fix(int[] nums) {
        //  修改原数组
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 1 && nums[i] < nums.length && nums[nums[i]] != nums[i] + 1) {
                swap(nums, i, nums[i]);
            }
        }
    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive demo = new FirstMissingPositive();
        System.out.println(demo.firstMissingPositive(new int[]{1,2}));
    }
}
