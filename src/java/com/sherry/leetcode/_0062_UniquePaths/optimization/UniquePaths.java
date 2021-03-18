package com.sherry.leetcode._0062_UniquePaths.optimization;

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        //  定义到达该位置的路径数量(不是该位置可移动的位置数量)
        int[][] f = new int[m][n];

        //  初始化位置
        f[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    //  当前位置即可通过右移和下移到达
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                } else if (i > 0) {
                    //  只能下移
                    f[i][j] = f[i - 1][j];
                } else if (j > 0) {
                    //  只能右移
                    f[i][j] = f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths demo = new UniquePaths();
        int paths = demo.uniquePaths(3, 2);
        System.out.println(paths);
    }
}
