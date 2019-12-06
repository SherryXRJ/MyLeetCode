package com.sherry.leetcode._0055_JumpGame.mine;

/**
 * 55. 跳跃游戏
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return true;

        int maxPosition = nums[0];

        int limit = nums[0];
        for (int i = 0; i < nums.length; i++) {
            //  最大位移位置 达到不到当前位置 则返回false
            if (maxPosition < i) return false;

            //  到达临界点时判断一下 是否可以跳完，跳不完则刷新临界点
            if (i == limit) {
                limit = maxPosition;
                if (limit >= nums.length - 1) return true;
            }

            //  可以跳到的位置
            maxPosition = Math.max(maxPosition, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        JumpGame demo = new JumpGame();
        //  2,3,1,1,4
        //  1,1,0,1
        //  5,9,3,2,1,0,2,3,3,1,0,0
        System.out.println(demo.canJump(new int[]{2,3,0,1,4}));
    }

}
