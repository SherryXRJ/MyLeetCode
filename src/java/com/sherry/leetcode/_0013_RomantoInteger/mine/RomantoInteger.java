package com.sherry.leetcode._0013_RomantoInteger.mine;


import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
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
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 */
public class RomantoInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            this.put('M', 1000);
            this.put('D', 500);
            this.put('C', 100);
            this.put('L', 50);
            this.put('X', 10);
            this.put('V', 5);
            this.put('I', 1);
        }};

        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            result = (i == chars.length - 1) || (map.get(chars[i]) >= map.get(chars[i + 1]))
                    ? result + map.get(chars[i])
                    : result - map.get(chars[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        RomantoInteger demo = new RomantoInteger();
        int i = demo.romanToInt("MCMXCIV");
        System.out.println(i);
    }
}
