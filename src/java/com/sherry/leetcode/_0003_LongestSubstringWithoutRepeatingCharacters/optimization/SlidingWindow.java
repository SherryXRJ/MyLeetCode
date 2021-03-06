package com.sherry.leetcode._0003_LongestSubstringWithoutRepeatingCharacters.optimization;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。<p/>
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。<p/>
 *
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是"b"，所以其长度为 1。<p/>
 *
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *     请注意，你的答案必须是子串的长度，"pwke" 是一个子序列，不是子串。<p/>
 *
 */
public class SlidingWindow {

    /**
     * 滑动窗口
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        //  i:窗口左区间  j:窗口右区间    max:所求最大值结果
        //  [i, j)  左闭右开
        int i = 0, max = 0, j = 0;

        //  set存储字符串
        Set<Character> set = new LinkedHashSet<>();

        while (i < chars.length && j < chars.length) {
            if (!set.contains(chars[j])) {
                set.add(chars[j]);
                j++;
                //  j - i即: [i, j) 窗口大小     以下两种写法都可以
//                max = Math.max(max, j - i);
                max = Math.max(max, set.size());
            } else {
                //  删除下标i位置的元素，此时j的值没有改变
                set.remove(chars[i]);
                i++;
            }
            System.out.println("[" + i + "," + j + ")");
        }
        //  窗口最大值
        return max;
    }

    public static void main(String[] args) {
        SlidingWindow demo = new SlidingWindow();
        System.out.println(demo.lengthOfLongestSubstring("abccbabb"));
    }
}
