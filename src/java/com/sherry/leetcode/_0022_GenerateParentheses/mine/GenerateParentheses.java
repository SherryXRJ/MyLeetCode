package com.sherry.leetcode._0022_GenerateParentheses.mine;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * <p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParentheses {

    private List<String> result = new ArrayList<>();

    /**
     * 参考官方 回溯法
     */
    public List<String> generateParenthesis(int n) {
        this.backtrack("", 0, 0, n);
        return result;
    }

    private void backtrack(String str, int open, int close, int max){
        //  最大字符数为 max * 2
        if (str.length() == max * 2) {
            result.add(str);
            return;
        }

        if (open < max)
            backtrack(str + "(", open + 1, close, max);
        if (close < open)
            backtrack(str+")", open, close + 1, max);
    }

    public static void main(String[] args) {
        GenerateParentheses demo = new GenerateParentheses();
        List<String> strings = demo.generateParenthesis(3);
        System.out.println(strings);
    }

}
