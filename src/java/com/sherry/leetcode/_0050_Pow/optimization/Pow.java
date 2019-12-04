package com.sherry.leetcode._0050_Pow.optimization;

/**
 * 50. Pow(x, n)
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class Pow {

    /**
     * 二分查找优化
     */
    public double myPow(double x, int n) {

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return binaryPow(x, n);
    }

    public double binaryPow(double x, int n){
        if (n == 0) return 1;

        /*
            求当前幂的一半 ，根据一半来求，减少次数
            递归时先求出最低次幂的，高次幂依据低次幂的结果来向上求结果
            例如:
                2^8 -> 2^4 -> 2^2 -> 2^1 -> 2^0
                2^7 -> 2^3 -> 2^1 -> 2^0
        */
        double half = binaryPow(x, n / 2);

        System.out.println(half);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        Pow demo = new Pow();
        System.out.println(demo.myPow(2, 7));
    }
}
