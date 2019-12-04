package com.sherry.leetcode._0050_Pow.mine;

/**
 * 50. Pow(x, n)
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class Pow {

    /**
     * 暴力法
     * 0.00001，2147483647 超时
     */
    public double myPow(double x, int n) {

        double result = 1;
        for (int i = 0; i < Math.abs(n); i++) {
            result *= n > 0 ? x : (1f / x);
        }
        return result;
    }

    public static void main(String[] args) {
        Pow demo = new Pow();
        System.out.println(demo.myPow(0.00001, 2147483647));
    }
}
