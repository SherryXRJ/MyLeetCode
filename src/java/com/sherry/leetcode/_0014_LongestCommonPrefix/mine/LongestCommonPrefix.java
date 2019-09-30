package com.sherry.leetcode._0014_LongestCommonPrefix.mine;

import java.util.regex.Pattern;

/**
 * 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";

        int minLen = Integer.MAX_VALUE;
        String minStr = "";
        for (int i = 0; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
            minStr = strs[i];
        }

        int index = 0;
        out:
        while (index <= minLen) {
            String temp = minStr.substring(0, index);
            for (String str : strs) {
                if (!str.substring(0, index).equals(temp)) {
                    break out;
                }
            }
            ++index;
        }

        return index == 0 ? "" : minStr.substring(0, index - 1);
    }

    public static void main(String[] args) {
        String[] strings = {"fl1", "fl", "fl3"};
        LongestCommonPrefix demo = new LongestCommonPrefix();
        String prefix = demo.longestCommonPrefix(strings);
        System.out.println(prefix);
    }
}
