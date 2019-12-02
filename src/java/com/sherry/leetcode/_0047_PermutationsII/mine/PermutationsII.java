package com.sherry.leetcode._0047_PermutationsII.mine;

import java.util.*;

/**
 * 47. 全排列 II
 * <p>
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class PermutationsII {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        //  排序"剪枝"
        Arrays.sort(nums);

        int[] list = new int[nums.length];
        backtrack(nums, list, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, int[] vArr, List<Integer> tempList){
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));

            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vArr[i] == 1
                    ||
                    //  坐标大于0， 当前元素 = 上一个元素 则说明重复
                (i > 0 && vArr[i - 1] == 0 && nums[i] == nums[i - 1]))  //  去重
                continue;
            vArr[i] = 1;
            tempList.add(nums[i]);
            backtrack(nums, vArr, tempList);
            tempList.remove(tempList.size() - 1);
            vArr[i] = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermutationsII().permuteUnique(new int[]{1, 1, 2}));
    }
}
