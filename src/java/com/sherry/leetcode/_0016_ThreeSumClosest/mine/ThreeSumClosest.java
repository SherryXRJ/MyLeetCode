package com.sherry.leetcode._0016_ThreeSumClosest.mine;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * <p>
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    /**
     * 双指针
     */
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int offset = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int k = 0; k < nums.length; k++) {
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                //  误差的绝对值
                if (Math.abs(sum - target) < offset) {
                    offset = Math.abs(sum - target);
                    result = sum;
                }
                if (offset == 0) return target;
                else if (sum > target) j--;
                else if (sum < target) i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        ThreeSumClosest demo = new ThreeSumClosest();
        int result = demo.threeSumClosest(nums, 1);
        System.out.println(result);
    }
}
