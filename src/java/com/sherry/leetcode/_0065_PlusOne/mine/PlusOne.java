package com.sherry.leetcode._0065_PlusOne.mine;

import java.util.Arrays;

/**
 * 66.加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int[] arr = Arrays.copyOfRange(digits, 0, digits.length);

        //  进位标识
        int move = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            //  主要看最后一位是否进位 不进位
            if (i == arr.length - 1 && arr[i] < 9) {
                arr[i] = arr[i] + 1;
                return arr;
            }

            //  不进位则直接结束
            if (move == 0) {
                return arr;
            }

            int num = arr[i] + move;
            if (num == 10) {
                num = 0;
                move = 1;
            } else {
                move = 0;
            }
            arr[i] = num;
        }

        if (move == 1) {
            int[] newArr = new int[arr.length + 1];
            newArr[0] = 1;
            System.arraycopy(arr, 0, newArr, 1, arr.length);
            return newArr;
        }
        return arr;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,9,9};
        PlusOne demo = new PlusOne();
        int[] result = demo.plusOne(arr);
        System.out.println(result);
    }
}
