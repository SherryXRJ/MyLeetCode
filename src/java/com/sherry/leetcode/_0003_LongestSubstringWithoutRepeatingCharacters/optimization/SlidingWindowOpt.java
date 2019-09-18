package com.sherry.leetcode._0003_LongestSubstringWithoutRepeatingCharacters.optimization;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
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
public class SlidingWindowOpt {

    /**
     * 滑动窗口优化<p/>
     * 将字符以，K,V键值对存储，K-字符 V-窗口坐标，如果定位到重复的字符，那么更新窗口左区间，再进行查找<p/>
     * 原始字符串: a,b,c,b,a,b,b <p/>
     * 窗口:       [a,b,c),b,a,b,b <p/>
     * 新窗口:     a,b,c,[b,a),b,b <p/>
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new LinkedHashMap<>();
        //  i左区间，j右区间
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                //  找到重复的字符，更新窗口下标
                i = Math.max(i, map.get(s.charAt(j)));
            }

            //  +1 是计算窗口区间
            map.put(s.charAt(j), j + 1);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        SlidingWindowOpt demo = new SlidingWindowOpt();
        System.out.println(demo.lengthOfLongestSubstring("tmmzuxt"));
    }
}
