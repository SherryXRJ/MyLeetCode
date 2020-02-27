package com.sherry.leetcode._0058_LengthofLastWord.mine;

/**
 *
 * 58. 最后一个单词的长度
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
 * 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指仅由字母组成、不包含任何空格的 最大子字符串。
 *
 */
public class LengthofLastWord {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0 || s.trim().length() == 0) return 0;

        String[] arr = s.trim().split(" ");
        return arr[arr.length - 1].length();
    }


}
