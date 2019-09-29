package com.sherry.leetcode._0012_IntegertoRoman.mine;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 */
public class IntegertoRoman {

    /**
     * 贪心算法
     */
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        //  从码表中最大的部分依次取
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            while (num >= nums[i]) {
                sb.append(symbols[i]);
                num -= nums[i];
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        IntegertoRoman demo = new IntegertoRoman();
        String roman = demo.intToRoman(1994);
        System.out.println(roman);
    }
}
