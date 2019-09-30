package com.sherry.leetcode._0014_LongestCommonPrefix.optimization;

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
public class LongestCommonPrefixBinarySearch {

    /**
     * 通过二分查找
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }

        int low = 0, high = minLen;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (this.isCommonPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return strs[0].substring(0, (low + high) / 2);
    }

    public boolean isCommonPrefix(String[] strings, int length) {
        String temp = strings[0].substring(0, length);
        for (int i = 1; i < strings.length; i++) {
            if (!strings[i].startsWith(temp)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strings = {"flower","flow","flight"};
        LongestCommonPrefixBinarySearch demo = new LongestCommonPrefixBinarySearch();
        String prefix = demo.longestCommonPrefix(strings);
        System.out.println(prefix);
    }
}
