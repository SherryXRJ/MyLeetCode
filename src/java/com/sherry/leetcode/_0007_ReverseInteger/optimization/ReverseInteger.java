package com.sherry.leetcode._0007_ReverseInteger.optimization;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。<p/>
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321<p/>
 *
 * 示例 2:
 * 输入: -123
 * 输出: -321<p/>
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21<p/>
 *
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。<p/>
 */
public class ReverseInteger {

    public int reverse(int x) {
        int num = 0;
        while (x != 0) {
            //  最高位
            int temp = x % 10;
            x /= 10;

            //  溢出问题
            if (num > Integer.MAX_VALUE / 10) return 0;
            if (num < Integer.MIN_VALUE / 10) return 0;

            num = num * 10 + temp;
        }
        return num;
    }

    public static void main(String[] args) {
        ReverseInteger demo = new ReverseInteger();
        int reverse = demo.reverse(Integer.MAX_VALUE);
        System.out.println(reverse);
    }
}
