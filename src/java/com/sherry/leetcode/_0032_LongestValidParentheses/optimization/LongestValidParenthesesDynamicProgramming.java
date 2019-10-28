package com.sherry.leetcode._0032_LongestValidParentheses.optimization;

import java.util.Arrays;

/**
 * 32. 最长有效括号
 * <p>
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 */
public class LongestValidParenthesesDynamicProgramming {

    /**
     * 动态规划
     * <p>
     * 个人总结:
     * <p>
     * 1.依赖dp[i]前面的数据进行计算
     * <p>
     * 2.一定要推导出关系
     */
    public int longestValidParentheses(String s) {
        int max = 0;

        int[] dp = new int[s.length()];

        //  从第二个元素开始
        for (int i = 1; i < s.length(); i++) {
            //  ( =>  dp[i] 就是0

            //  ) =>
            if (')' == s.charAt(i)) {
                //  前一个是 (  =>  在dp[i - 2] 的基础上 +2
                if ('(' == s.charAt(i - 1)) {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                //  前一个是 )
                else if(i - dp[i - 1] > 0   //  防止越界
                        && s.charAt(i - dp[i - 1] - 1) == '(')  //  是否是一对 ()
                {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    public static void main(String[] args) {
        LongestValidParenthesesDynamicProgramming demo = new LongestValidParenthesesDynamicProgramming();
        System.out.println(demo.longestValidParentheses("()()((()))"));
    }
}
