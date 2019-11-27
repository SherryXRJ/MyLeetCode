package com.sherry.leetcode._0035_SearchInsertPosition.mine;

/**
 * 35. 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] > target) high = mid - 1;
            else if (nums[mid] < target) low = mid + 1;
            else return mid;
        }

        //  以low为标准
        //  如果 low == nums.length   则说明需要查找的元素大于最后一个元素，需要在数组的长度上插入
        //  如果 low == 0             则说明需要查找的元素小于第一个元素，在low(0)处插入即可
        //  在中间的话                则说明没找到low恰好大于需要查找的元素，返回low - 1即可
        return low == nums.length ? nums.length : (target > nums[low] ? low - 1: low);
    }

    public static void main(String[] args) {
        SearchInsertPosition demo = new SearchInsertPosition();
        int searchInsert = demo.searchInsert(new int[]{1, 3, 5, 6}, 4);
        System.out.println(searchInsert);
    }
}
