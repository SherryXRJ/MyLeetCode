package com.sherry.leetcode._0005_LongestPalindromicSubstring.optimization;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。<p/>
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。<p/>
 * <p>
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindromicSubstring {

    /**
     * 暴力查找优化  时间复杂度 O(n²)<p/>
     * 如果P[i ,j]是回文， 那么s[i-1] == s[j+1] 也是回文
     * abcbd => bcd 是回文， 只需判断  a == d  <p/>
     * 减少回文的检测 减少一次 O(n)
     */
    public String longestPalindrome(String s) {
        String result = "";
        int length = s.length();
        //  二维数组坐标  空间换时间   len从小到大存储左右坐标是回文的
        Boolean P[][] = new Boolean[length][length];
        //  遍历长度 从1开始，即初始取一个长度的字符
        for (int len = 1; len <= length; len++) {
            for (int i = 0; i < length; i++) {
                //  i是左标，j是右标
                int j = i + len - 1;
                if (j >= length) break; //  右标越界，则break

                //  因为i 始终小于j， 因此二维数组中P[i][j] (i > j) 是 null
                P[i][j] = (len == 1 || len == 2 || P[i + 1][j - 1] )         //  二维数组里，左右坐标缩减1 判断是否是回文（这一步len已经存在了二维数组中）
                        && s.charAt(i) == s.charAt(j);                       //  新的两个坐标 对应的字符是否相等（abcbd ->  判断 a d）
                if (P[i][j] && len > result.length()) {
                    result = s.substring(i, j + 1);
                }
                System.out.println(i + ","+ j);
            }
        }
        printP(P);
        return result;
    }

    /**
     * @deprecated 无需判断回文，被P[][]替代了
     */
    @Deprecated
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public void printP(Boolean[][] p){
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                System.out.print("(" + i + "," + j + ")" + p[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring demo = new LongestPalindromicSubstring();
        String result = demo.longestPalindrome("a");
        System.out.println(result);




    }
}
