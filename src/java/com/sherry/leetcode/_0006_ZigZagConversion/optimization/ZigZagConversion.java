package com.sherry.leetcode._0006_ZigZagConversion.optimization;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class ZigZagConversion {

    /**
     * 按行找出每个位置的规律(参考了官网解法)<p/>
     * 系数 k = numRows - 1 <p/>
     * 索引 i 字符所在字符串索引<p/>
     * 通过一维数组存储每行数据<p/>
     * cursor 所在一维数组的位置
     * down: 向下表示(第一行输出的位置) <p/>
     * up:  向上表示（最后一行输出的位置）<p/>
     * 如何变换方向down、up: 索引i可以整除k(i % k == 0), i / k 为偶数=> 向下 ； i / k 为奇数=> 向上<p/>
     * 时间复杂度O(n)
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s; //特殊处理

        //  系数k
        int k = numRows - 1;
        //  初始化一维数组,每个元素就是每行需要输出的字符串
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int num = 0; num < numRows; num++) {
            rows[num] = new StringBuilder();
        }
        //  默认方向是向下的
        boolean down = true;
        //  游标
        int cursor = 0;
        for (int i = 0; i < s.length(); i++) {
            rows[cursor].append(s.charAt(i));
            //  判断是否需要转换方向
            if (i % k == 0) {
                //  (i / k) 为偶数 => 向下 ; (i / k) 为奇数 => 向上
                down = ((i / k) & 1) != 1;
            }
            //  向下: 游标 + 1; 向上: 游标 - 1
            cursor += down ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion demo = new ZigZagConversion();
        String convert = demo.convert("LEETCODEISHIRING", 4);
        System.out.println(convert);
    }

}
