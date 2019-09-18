package com.sherry.leetcode._0004_MedianOfTwoSortedArrays.mine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
public class MedianOfTwoSortedArrays {

    /**
     *  通过Stream 合并两个数组为List，并排序，取中间两位数，求平均值
     *  时间复杂度不满足要求
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result;
        List<Integer> collect = Stream.of(Arrays.stream(nums1), Arrays.stream(nums2))
                .flatMap(IntStream::boxed)
                .sorted()
                .collect(Collectors.toList());
        int size = collect.size();
        if (size % 2 == 0) {
            int index = size / 2;
            //  size为偶数 取中间两位数的平均值
            result = (collect.get(index) + collect.get(index - 1)) / 2.0;
        } else {
            //  size为奇数 取中间
            int index = size / 2;
            result = collect.get(index);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] n1 = {1};
        int[] n2 = {};
        MedianOfTwoSortedArrays demo = new MedianOfTwoSortedArrays();
        double value = demo.findMedianSortedArrays(n1, n2);
        System.out.println(value);
    }
}
