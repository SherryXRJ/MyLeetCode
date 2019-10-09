package com.sherry.leetcode._0020_ValidParentheses.mine;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20.有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * <p>
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (c == ')') {
                if (stack.empty() || stack.pop() != '(') return false;
            } else if (stack.empty() || c == ']') {
                if (stack.empty() || stack.pop() != '[') return false;
            } else if (c == '}') {
                if (stack.empty() || stack.pop() != '{') return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        ValidParentheses demo = new ValidParentheses();
        boolean valid = demo.isValid("[");
        System.out.println(valid);
    }
}
