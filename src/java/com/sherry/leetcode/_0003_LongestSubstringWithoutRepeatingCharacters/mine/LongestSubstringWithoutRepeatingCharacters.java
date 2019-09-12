package com.sherry.leetcode._0003_LongestSubstringWithoutRepeatingCharacters.mine;

import java.util.HashSet;

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
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 通过HashSet，逐位读取字符串，并进行比较
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < chars.length; j++) {
                if (set.contains(chars[j])) {
                    break;
                }
                set.add(chars[j]);
            }
            max = set.size() > max ? set.size() : max;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters demo = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(demo.lengthOfLongestSubstring("pwwkew"));
    }
}
