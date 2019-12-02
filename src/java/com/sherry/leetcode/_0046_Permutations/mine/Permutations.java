package com.sherry.leetcode._0046_Permutations.mine;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * <p>
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class Permutations {

    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        //  访问元素标记数组
        int[] l = new int[nums.length];

        backtrack(nums, l, new ArrayList<>());
        return lists;
    }

    public void backtrack(int[] nums, int[] list, List<Integer> tempList){
        if (tempList.size() == nums.length) {
            lists.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //  不能重复使用
            if (list[i] == 1) continue;

            tempList.add(nums[i]);
            list[i] = 1;    //  被访问了
            backtrack(nums, list, tempList);
            tempList.remove(tempList.size() - 1);
            list[i] = 0;    //  重置
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1, 2,3}));
    }
}
