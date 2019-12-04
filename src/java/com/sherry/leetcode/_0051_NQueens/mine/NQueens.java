package com.sherry.leetcode._0051_NQueens.mine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N皇后
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 */
public class NQueens {

    private List<List<String>> result = new ArrayList<>();

    private int[][] chessboard;

    /**
     * 列
     */
    private int[] col;

    /**
     * 正斜率
     */
    private int[] positiveSlope;

    /**
     * 负斜率
     */
    private int[] negativeSlope;

    public List<List<String>> solveNQueens(int n) {

        col = new int[n];
        positiveSlope = new int[(n << 1) - 1];
        negativeSlope = new int[(n << 1) - 1];
        int row[] = new int[n];
        return null;
    }

    public void backtrack(int n, List<String> tempList, List<List<String>> curMap, int row, int queenCount){

        for (int j = 0; j < n; j++) {
            if (col[j] != 1 && positiveSlope[j + row] != 1 && negativeSlope[j - row] != 1) {

            }
        }


    }
    private boolean checkRefreshChessboard(int x, int y) {
        //  行、列检查
        for (int i = 0; i < chessboard.length ; i++) {
            if (x == i && y == i) continue;
            if (chessboard[x][i] == 1) return false;
            if (chessboard[i][y] == 1) return false;
        }


        //  正斜率
        for (int i = 0; i < chessboard.length; i++) {
            if (x == i && y == i) continue;
            int j = x + y - i;
            if (chessboard[i][j] == 1) return false;
        }

        //  负斜率
        for (int i = 0, j = i + (y - x); i < chessboard.length; i++) {
            if (x == i && y == i) continue;

            if (chessboard[i][j] == 1) return false;
        }

        return true;
    }



}
