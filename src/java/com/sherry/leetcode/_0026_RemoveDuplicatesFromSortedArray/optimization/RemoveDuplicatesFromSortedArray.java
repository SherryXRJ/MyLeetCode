package com.sherry.leetcode._0026_RemoveDuplicatesFromSortedArray.optimization;

import java.util.Arrays;

/**
 * 26. 删除排序数组中的重复项
 * <p>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * 参考官方题解，利用有序数组，
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int left = 0;
        for (int right = left + 1; right < nums.length; right++) {
            //  两个指针指向的值不相等时，左指针前移，并赋值为右指针的值
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }

        return left + 1;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicatesFromSortedArray demo = new RemoveDuplicatesFromSortedArray();
        int length = demo.removeDuplicates(arr);
        System.out.println(length);
        System.out.println(Arrays.toString(arr));
    }
}
