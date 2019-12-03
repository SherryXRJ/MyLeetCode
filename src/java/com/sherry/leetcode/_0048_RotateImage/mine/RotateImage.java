package com.sherry.leetcode._0048_RotateImage.mine;

import java.util.Arrays;

/**
 * 48. 旋转图像
 * <p>
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix.length == 0) return;
        int row = matrix.length - 1, col = matrix.length - 1;

        int curMatrixWidth = row;
        //  取外层范围
        for (int i = 0; i < curMatrixWidth; i++) {
            for (int j = i; j < curMatrixWidth; j++) {
                //  交换4个点

                //  左上端点    A
                int x1 = i, y1 = j;

                //  右上端点    B
                int x2 = j, y2 = curMatrixWidth;

                //  右下端点    C
                int x3 = curMatrixWidth , y3 = col - j;

                //  左下端点    D
                int x4 = row  - j, y4 = i;

                swap(matrix, x1, y1, x2, y2);   //  A点归位
                swap(matrix, x1, y1, x3, y3);   //  B点归位
                swap(matrix, x1, y1, x4, y4);   //  C、D点归位
            }
            curMatrixWidth--;
        }

    }

    public void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5,1,9,11}, {2, 4, 8,10}, {13, 3, 6, 7},{15,14,12,16}};
        RotateImage demo = new RotateImage();
        demo.rotate(matrix);
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
