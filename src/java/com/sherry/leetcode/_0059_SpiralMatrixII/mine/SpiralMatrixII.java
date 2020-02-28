package com.sherry.leetcode._0059_SpiralMatrixII.mine;

import java.util.Arrays;

/**
 *
 * 59. 螺旋矩阵 II
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        if (n == 0) return new int[][]{};

        int[][] matrix = new int[n][n];

        //  horizontal 1:向右  -1:向左  0:不动
        //  vertical   1:向下  -1:向上  0:不动
        int horizontal = 1, vertical = 0;

        //  边界
        int limit = n - 1;

        int num = 1;
        for (int i = 0, j = 0; num <= n * n; num++) {

            //  右上端点
            if (i + j == limit && j >= i) {
                vertical = 1;
                horizontal = 0;
            }
            //  右下端点
            else if (i == j && i > limit / 2){
                vertical = 0;
                horizontal = -1;
            }
            //  左下端点
            else if (i + j == limit && i > j) {
                vertical = -1;
                horizontal = 0;
            }
            //  左上端点
            else if (i == j && i < limit / 2) {
                horizontal = 1;
                vertical = 0;
            }
            //  平移顶点
            else if (j + 1 == i && i <= limit / 2) {
                horizontal = 1;
                vertical = 0;
            }

            matrix[i][j] = num;

            //  调整i, j坐标
            i += vertical;
            j += horizontal;
        }

        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixII solution = new SpiralMatrixII();
        int[][] ints = solution.generateMatrix(0);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
