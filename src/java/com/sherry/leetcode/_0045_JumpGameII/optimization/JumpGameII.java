package com.sherry.leetcode._0045_JumpGameII.optimization;

/**
 * 45. 跳跃游戏 II
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 */
public class JumpGameII {

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return 0;

        //  步数
        int times = 0;

        //  边界
        int end = 0;

        //  最大距离
        int maxPos = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            //  最远能跳多远
            maxPos = Math.max(maxPos, i + nums[i]);

            //  在边界时再增加步数，跳的距离取决于在可跳范围内的最大值
            if (i == end) {
                end = maxPos;
                ++times;
            }
        }

        return times;
    }

    public static void main(String[] args) {
        JumpGameII demo = new JumpGameII();
        //  1,2,1,1,1
        //  2,1,1,1,1
        //  3,2,1,1,0
        //  10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0
        System.out.println("\n" + demo.jump(new int[]{8, 8, 8, 20, 1, 1, 1, 1, 1, 1, 1, 0}));
    }
}
