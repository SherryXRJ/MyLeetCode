package com.sherry.leetcode._0064_MinimumPathSum.mine;

/**
 * 64.给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //  定义: 当前位置的最小和(加上grid[i][j])
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    //  当前位置既可通过【右移】到达也可通过【下移】到达
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if (i > 0) {
                    //  当前位置只能通过【下移】到达
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else if (j > 0) {
                    //  当前位置只能通过【右移】到达
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
//        int[][] arr = new int[][]{{1,3,1}, {1,5,1}, {4,2,1}};
        int[][] arr = new int[][]{{1,2,3}, {4,5,6}};
        MinimumPathSum demo = new MinimumPathSum();
        int sum = demo.minPathSum(arr);
        System.out.println(sum);
    }
}
