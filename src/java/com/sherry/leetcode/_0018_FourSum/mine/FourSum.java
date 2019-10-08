package com.sherry.leetcode._0018_FourSum.mine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18.四数之和
 * <p>
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        //  使用排序 降低时间复杂度
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        //  k维持最小元素
        for (int k = 0; k < nums.length; k++) {
            //  重复
            if (k > 0 && nums[k] == nums[k - 1]) continue;

            for (int l = k + 1; l < nums.length; l++) {
                //  重复
                if (l > k + 1 && nums[l] == nums[l - 1]) continue;

                int i = l + 1, j = nums.length - 1;
                while (i < j) {
                    int sum = nums[k] + nums[l] + nums[i] + nums[j];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[k],nums[l], nums[i], nums[j]));
                        i++;
                        j--;
                        while (i < j && nums[i] == nums[i - 1]) i++;
                        while (i < j && nums[j] == nums[j + 1]) j--;
                    } else if (sum < target) {
                        i++;
                        //  重复
                        while (i < j && nums[i] == nums[i - 1]) i++;
                    } else if (sum > target) {
                        j--;
                        //  重复
                        while (i < j && nums[j] == nums[j + 1]) j--;
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,4,-5,2,-2,4,2,-1,4};
        FourSum demo = new FourSum();
        List<List<Integer>> lists = demo.fourSum(nums, 12);
        System.out.println(lists);
    }
}
