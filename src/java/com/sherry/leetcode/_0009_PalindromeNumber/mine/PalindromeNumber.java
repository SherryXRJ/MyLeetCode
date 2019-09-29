package com.sherry.leetcode._0009_PalindromeNumber.mine;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。<p>
 * 示例 1:
 * 输入: 121
 * 输出: true<p>
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。<p>
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。<p>
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        return this.isPalindrome(String.valueOf(x));
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
    public static void main(String[] args) {
        PalindromeNumber demo = new PalindromeNumber();
        System.out.println(demo.isPalindrome(212));
    }
}
