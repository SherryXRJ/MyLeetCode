package com.sherry.leetcode._0040_CombinationSumII.mine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * <p>
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, candidates, 0, target, new ArrayList<>());
        return result;
    }

    public void backtrack(List<List<Integer>> list, int[] candidates, int index, int target, List<Integer> tempList) {
        if (target < 0) return;
        if (target == 0) {
            list.add(new ArrayList<>(tempList));
        }

        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) break;
            //  去重
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            tempList.add(candidates[i]);

            //  index + 1从下一个元素开始查找
            backtrack(list, candidates, i + 1, target - candidates[i], tempList);

            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumII demo = new CombinationSumII();
        List<List<Integer>> lists = demo.combinationSum2(new int[]{2,5,2,1,2}, 5);
        System.out.println(lists);
    }
}
