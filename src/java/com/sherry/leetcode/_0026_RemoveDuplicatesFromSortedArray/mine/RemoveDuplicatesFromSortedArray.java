package com.sherry.leetcode._0026_RemoveDuplicatesFromSortedArray.mine;

import java.util.Arrays;

/**
 * 26. 删除排序数组中的重复项
 * <p>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * 效率问题 时间复杂度 O(n^2)
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int left = 0, right = 1, length = 1 , max = nums[nums.length - 1];
        while (left < nums.length && right < nums.length) {
            if (nums[left] == max) break;

            //  正常情况 左边元素 < 右边元素
            if (nums[left] < nums[right]) {
                left++;
                right++;
                length++;
            }
            //  非正常情况
            else  {
                //  找比nums[left] 和nums[right]大的第一个元素
                for (int i = right + 1; i < nums.length; i++) {
                    if (nums[i] > nums[right] && nums[i] > nums[left]) {
                        nums[right] = nums[i];
                        length++;
                        break;
                    }
                }
                left++;
                right++;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicatesFromSortedArray demo = new RemoveDuplicatesFromSortedArray();
        int length = demo.removeDuplicates(arr);
        System.out.println(length);
        System.out.println(Arrays.toString(arr));
    }
}
