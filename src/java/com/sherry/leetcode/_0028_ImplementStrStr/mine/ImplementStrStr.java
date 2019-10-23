package com.sherry.leetcode._0028_ImplementStrStr.mine;

/**
 * 28. 实现 strStr()
 * <p>
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() == 0) return -1;
        if (needle.length() > haystack.length()) return -1;

        char beginChar = needle.charAt(0);
        int i = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == beginChar && i + needle.length() <= haystack.length()) {
                //  检测两个字符串是否相同
                int k = i, j = 0;
                for (; j < needle.length(); j++) {
                    if (needle.charAt(j) != haystack.charAt(k)) break;
                    else k++;
                }
                if (k - i == needle.length()) return i;
            }
            i++;
        }

        return -1;
    }

    public static void main(String[] args) {
        ImplementStrStr demo = new ImplementStrStr();
        int i = demo.strStr("hello", "ll");
        System.out.println(i);
    }
}
