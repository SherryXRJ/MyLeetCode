package com.sherry.leetcode._0032_LongestValidParentheses.optimization;

import java.util.Stack;

/**
 * 32. 最长有效括号
 * <p>
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 */
public class LongestValidParentheses {

    /**
     * 官方的的Stack骚操作
     * <p>
     * 通过字符串下标计算
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        //  先入栈 -1
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            //  (  => 入栈下标
            if ('(' == s.charAt(i)) {
                stack.push(i);
            }
            //  ) => 0.出栈   1.栈为空 那么入栈下标   2.栈不为空，通过计算 当前下标 - 栈顶坐标
            else {
                stack.pop();
                if (stack.empty()) stack.push(i);
                else max = Math.max(max, i - stack.peek());
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses demo = new LongestValidParentheses();
        System.out.println(demo.longestValidParentheses("(()"));
    }
}
