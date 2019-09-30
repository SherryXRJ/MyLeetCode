package com.sherry.leetcode._0015_ThreeSum.mine;

import java.util.*;

/**
 * 15. 三数之和
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSumWrong {

    /**
     * 时间复杂度 O(n^3)
     * <p>
     * 超时
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int ans = -nums[i] - nums[j];
                if (this.contains(nums, ans, i, j)) {
                    int min = Math.min(ans, Math.min(nums[i], nums[j]));    //  min
                    int max = Math.max(ans, Math.max(nums[i], nums[j]));    //  max
                    result.add(Arrays.asList(min, -min - max, max));
                }
            }
        }
        return new ArrayList<>(result);
    }

    public boolean contains(int[] arr, int num, int i, int j) {
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == num && index != i && index != j) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        ThreeSumWrong demo = new ThreeSumWrong();
        List<List<Integer>> list = demo.threeSum(arr);
        System.out.println(list);
    }
}
