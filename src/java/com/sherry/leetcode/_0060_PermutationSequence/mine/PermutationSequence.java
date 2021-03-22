package com.sherry.leetcode._0060_PermutationSequence.mine;

import java.util.ArrayList;
import java.util.List;

/**
 * 60. 第k个排列
 * <p/>
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {
        String intStr = "";
        for (int i = 1; i <= n; i++) {
            intStr += i;
        }

        List<String> result = new ArrayList<>();

        backtrack(result, 0, "", intStr);

        System.out.println("array:" + result);
        return result.get(k);
    }

    public void backtrack(List<String> array, int begin, String tempStr, String origin){
        if (tempStr.length() == origin.length()) {
            array.add(tempStr);
            return;
        }

        for (int i = begin; i < origin.length(); i++) {
            tempStr += "" + origin.charAt(i);

            backtrack(array, i + 1, tempStr, origin);
            tempStr.substring(0, tempStr.length() - 1);
        }

    }

    public static void main(String[] args) {
        PermutationSequence demo = new PermutationSequence();
        System.out.println(demo.getPermutation(3, 3));
    }
}
