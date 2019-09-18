package com.sherry.leetcode._0004_MedianOfTwoSortedArrays.optimization;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。<p/>
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0 <p/>
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class BinarySearch {

    /**
     * TODO: 使用二分查找解决该问题
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        return result;
    }

    public static void main(String[] args) {
        int[] n1 = {1};
        int[] n2 = {};
        BinarySearch demo = new BinarySearch();
        double value = demo.findMedianSortedArrays(n1, n2);
        System.out.println(value);
    }
}
