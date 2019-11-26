package com.sherry.leetcode._0034_FindFirstAndLastPositionOfElementInSortedArray.mine;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int left = this.binarySearchLeft(nums, 0, nums.length - 1, target);
        int right = this.binarySearchRight(nums, 0, nums.length - 1, target);
        return new int[]{left, right};
    }

    /**
     * 找左边界
     */
    public int binarySearchLeft(int[] nums, int low, int high, int target) {
        //  结果
        int left = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            //  找到目标后缩小【右】边界，继续找
            if (nums[mid] == target) {
                left = mid;
                high = mid - 1;
            }
            else if (nums[mid] > target) high = mid - 1;
            else if (nums[mid] < target) low = mid + 1;
        }
        return left;
    }

    /**
     * 找右边界
     */
    public int binarySearchRight(int[] nums, int low, int high, int target) {
        int right = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            //  找到目标后缩小【左】边界，继续找
            if (nums[mid] == target) {
                right = mid;
                low = mid + 1;
            }
            else if (nums[mid] > target) high = mid - 1;
            else if (nums[mid] < target) low = mid + 1;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] ints = {5,7,7,8,8,10};
        int[] result = new FindFirstAndLastPositionOfElementInSortedArray().searchRange(ints, 8);
        System.out.println(Arrays.toString(result));
    }
}
