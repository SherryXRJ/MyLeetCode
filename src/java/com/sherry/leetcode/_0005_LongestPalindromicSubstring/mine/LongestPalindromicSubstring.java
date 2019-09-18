package com.sherry.leetcode._0005_LongestPalindromicSubstring.mine;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。<p/>
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。<p/>
 *
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        String temp;
        while (i < j) {
            temp = s.substring(i, j);
            if (isPalindrome(temp)) {
                return temp;
            }
            j = j - 1;
        }

        return null;
    }

    public boolean isPalindrome(String s){
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

}
