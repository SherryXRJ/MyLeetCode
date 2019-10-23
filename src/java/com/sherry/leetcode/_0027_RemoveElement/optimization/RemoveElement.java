package com.sherry.leetcode._0027_RemoveElement.optimization;

import java.util.Arrays;

/**
 * 27. 移除元素
 * <p>
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        RemoveElement demo = new RemoveElement();
        int length = demo.removeElement(arr, 2);
        System.out.println(length);
        System.out.println(Arrays.toString(arr));
    }
}
