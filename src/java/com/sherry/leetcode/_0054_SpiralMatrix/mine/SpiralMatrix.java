package com.sherry.leetcode._0054_SpiralMatrix.mine;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length ==0) return new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        int size = matrix[0].length * matrix.length;

        int row = matrix.length - 1;
        int col = matrix[0].length - 1;

        //  0:不动  1:向右  -1:向左
        int horizontal = 0;

        //  0:不动  1:向下  -1:向上
        int vertical = 0;


        int step = 0;
        for (int i = 0, j = 0, k = 0; k < size; k++) {
            //  水平方向
            j += horizontal;

            //  垂直方向
            i += vertical;

            list.add(matrix[i][j]);


            //  扭转
            /*
                主要判断奇数列 > 行数的情况，
                1 , 2,  3
                6 , 7,  8
                11,12, 13
                16,17, 18

                7 这个点很特殊，它看上去同时满足【左上顶点】、【右上顶点】、【平移顶点】
                这里要以【右上端点】优先，先考虑垂直前进
             */
            if ((i == step && j == col - step) || (col % 2 == 0 && j == col / 2 && j == col) ) {   //  右上端点
                horizontal = 0;
                vertical = 1;
            } else if (i == step && j == step && col != 0) { //  左上顶点
                horizontal = 1;
                vertical = 0;
            } else if ((j == col - step && i == row - step)) {    //  右下顶点
                vertical = 0;
                horizontal = -1;
            } else if (j == step && i == row - step) {      //  左下顶点
                vertical = -1;
                horizontal = 0;
            } else if (j == step && i == step + 1 && j != col / 2) {      //  平移顶点
                horizontal = 1;
                vertical = 0;
                ++step;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        SpiralMatrix demo = new SpiralMatrix();
//        List<Integer> integers = demo.spiralOrder(new int[][]{{1}, {4}, {7}});
//        List<Integer> integers = demo.spiralOrder(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});
        List<Integer> integers = demo.spiralOrder(new int[][]{{1,2,3,4}, {5,6,7,8},{9,10,11,12}});
//        List<Integer> integers = demo.spiralOrder(new int[][]{{2,3,4}, {5,6,7},{8,9,10},{11,12,13},{14,15,16}});
        System.out.println(integers);
    }

}
