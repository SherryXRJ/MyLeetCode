package com.sherry.leetcode._0039_CombinationSum.mine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, target, candidates, new ArrayList<>(), 0);
        return result;
    }


    public void backtrack (List<List<Integer>> list, int target, int[] candidates, List<Integer> tempList, int index) {
        if (target < 0) return;
        if (target == 0) {
            //  数组拷贝
            list.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) break;
            tempList.add(candidates[i]);
            backtrack(list, target - candidates[i], candidates, tempList, i);

            // 删除一个元素 以便下一次迭代
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum demo = new CombinationSum();
        List<List<Integer>> lists = demo.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);
    }
}
