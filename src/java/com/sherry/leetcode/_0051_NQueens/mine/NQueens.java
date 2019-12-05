package com.sherry.leetcode._0051_NQueens.mine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 51. N皇后
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 */
public class NQueens {

    private List<List<String>> result = new ArrayList<>();

    ////////////////////这3个字段是状态校验///////////////////////////
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
    ///////////////////////////////////////////////////////////////

    /**
     * n个棋子，元素值表示第几列的棋子
     */
    private int[] nums;

    /**
     * 皇后
     *
     * 栈下标表示棋盘第几行，元素表示在该行第几列
     */
    private Stack<Integer> queens = new Stack<>();

    public List<List<String>> solveNQueens(int n) {

        col = new int[n];
        positiveSlope = new int[(n << 1) - 1];
        negativeSlope = new int[(n << 1) - 1];

        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }

        backtrack(n, 0);
        return result;
    }

    public void backtrack(int n, int row){
        if (n == row) {
            List<String> rowStr = new ArrayList<>();
            for (Integer e : queens) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    stringBuilder.append(".");
                }
                stringBuilder.replace(e, e + 1, "Q");
                rowStr.add(stringBuilder.toString());
            }
            result.add(rowStr);
            return;
        }

        for (int j = 0; j < n; j++) {
            //  j - row + n - 1     防止下标越界(负数)
            if (col[j] != 1 && positiveSlope[j + row] != 1 && negativeSlope[j - row + n - 1] != 1) {
                //  放棋子
                queens.add(nums[j]);

                col[j] = 1;
                positiveSlope[j + row] = 1;
                negativeSlope[j - row + n - 1] = 1;

                backtrack(n, row + 1);

                //  回退回来
                queens.pop();
                col[j] = 0;
                positiveSlope[j + row] = 0;
                negativeSlope[j - row + n - 1] = 0;
            }
        }
    }

    public static void main(String[] args) {
        NQueens demo = new NQueens();
        List<List<String>> lists = demo.solveNQueens(4);
        System.out.println(lists);
    }

}
