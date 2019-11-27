package com.sherry.leetcode._0036_ValidSudoku.mine;

import java.util.HashMap;
import java.util.Map;

/**
 * 36. 有效的数独
 *
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        //  存 【值】: 【个数】

        //  行
        Map<Integer, Integer>[] rows = new HashMap[9];
        //  列
        Map<Integer, Integer>[] cols = new HashMap[9];
        //  块
        Map<Integer, Integer>[] boxes = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int c = board[i][j];
                if (c != '.') {
                    //  计算在哪个块
                    int boxIndex = (i / 3) * 3 + (j / 3);


                    rows[i].put(c, rows[i].getOrDefault(c, 0) + 1);
                    cols[j].put(c, cols[j].getOrDefault(c, 0) + 1);
                    boxes[boxIndex].put(c, boxes[boxIndex].getOrDefault(c, 0) + 1);

                    if (rows[i].get(c) > 1) return false;
                    if (cols[j].get(c) > 1) return false;
                    if (boxes[boxIndex].get(c) > 1) return false;
                }

            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] sudoku = new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        ValidSudoku demo = new ValidSudoku();
        System.out.println(demo.isValidSudoku(sudoku));
    }
}
