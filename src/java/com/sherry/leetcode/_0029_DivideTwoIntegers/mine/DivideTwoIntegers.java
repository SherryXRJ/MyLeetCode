package com.sherry.leetcode._0029_DivideTwoIntegers.mine;

/**
 * 29. 两数相除
 * <p>
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * TODO :待完成
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);

        //  符号
        int symbol = (dividend >= 0 && divisor >= 0) || (dividend < 0 && divisor < 0) ? 1 : -1;

        int ans = 1, temp = absDivisor;
        while (temp < absDividend) {
            temp += absDivisor;
            ans += 1;

//            absDivisor = absDivisor << 1;
        }

        return symbol > 0 ? ans - 1 : -(ans - 1);
    }

    public static void main(String[] args) {
        DivideTwoIntegers demo = new DivideTwoIntegers();
        int divide = demo.divide(61, 4);
        System.out.println(divide);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

}
