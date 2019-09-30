package com.sherry.leetcode._0015_ThreeSum.optimization;

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
public class ThreeSumDualPointer {

    /**
     * 双指针
     * <p>
     * 先对数组排序
     *
     * k维持三数中最小数的索引
     * nums[k] > 0 直接退出
     * 重复情况以下几种:
     * <ol>
     *     <li>nums[k] == nums[k - 1] 重复了</li>
     *     <li>sum == 0 时 nums[i] == nums[i - 1]或者nums[j] == nums[j + 1] </li>
     *     <li>sum < 0 时 nums[i] == nums[i - 1]</li>
     *     <li>sum > 0 时 nums[j] == nums[j + 1]</li>
     * </ol>
     */
    public List<List<Integer>> threeSum(int[] nums) {
        //  使用排序 降低时间复杂度
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        //  k维持最小元素
        for (int k = 0; k < nums.length; k++) {
            //  最小元素大于0
            if (nums[k] > 0) break;

            //  重复
            if (k > 0 && nums[k] == nums[k - 1]) continue;

            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    i++;
                    j--;
                    while (i < j && nums[i] == nums[i - 1]) i++;
                    while (i < j && nums[j] == nums[j + 1]) j--;
                } else if (sum < 0) {
                    i++;
                    //  重复
                    while (i < j && nums[i] == nums[i - 1]) i++;
                } else if (sum > 0) {
                    j--;
                    //  重复
                    while (i < j && nums[j] == nums[j + 1]) j--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0, -4, -1, -4, -2, -3, 2};
        ThreeSumDualPointer demo = new ThreeSumDualPointer();
        List<List<Integer>> list = demo.threeSum(arr);
        System.out.println(list);
    }
}
