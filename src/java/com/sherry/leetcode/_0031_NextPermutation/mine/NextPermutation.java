package com.sherry.leetcode._0031_NextPermutation.mine;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * <p>
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return;

        //  倒序查找不是递增的
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        //  找出一个刚好比nums[i]小的
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            this.swap(i, j, nums);
        }

        this.reverse(i + 1, nums);

    }

    public void reverse(int begin, int[] nums){
        int i = begin, j = nums.length - 1;
        while (i < j) {
            this.swap(i, j, nums);

            i++;
            j--;
        }
    }

    public void swap(int index1, int index2, int nums[]) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        NextPermutation demo = new NextPermutation();
        int[] arr = new int[]{1,1};
        demo.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
