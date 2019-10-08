package com.sherry.leetcode._0017_LetterCombinationsOfAPhoneNumber.mine;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 * <p>
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOfAPhoneNumber {

    private Map<String, List<String>> map = new HashMap<String, List<String>>(8){{
        put("1", Collections.singletonList(""));
        put("2", Arrays.asList("a", "b", "c"));
        put("3", Arrays.asList("d", "e", "f"));
        put("4", Arrays.asList("g", "h", "i"));
        put("5", Arrays.asList("j", "k", "l"));
        put("6", Arrays.asList("m", "n", "o"));
        put("7", Arrays.asList("p", "q", "r", "s"));
        put("8", Arrays.asList("t", "u", "v"));
        put("9", Arrays.asList("w", "x", "y", "z"));
    }};

    private List<String> result = new ArrayList<>();

    /**
     * 参考官方 回溯算法
     */
    public List<String> letterCombinations(String digits) {
        if (digits != null && digits.length() != 0)
            this.backtrack("", digits);
        return result;
    }

    private void backtrack(String str, String nextDigits){
        if (nextDigits.length() == 0) {
            result.add(str);
        } else {
            String digit = nextDigits.substring(0, 1);
            List<String> stringList = map.get(digit);
            for (String aStringList : stringList) {
                backtrack(str + aStringList, nextDigits.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber demo = new LetterCombinationsOfAPhoneNumber();
        List<String> result = demo.letterCombinations("234");
        System.out.println(result);
    }
}
