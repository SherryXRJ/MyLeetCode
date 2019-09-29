package com.sherry.leetcode._0011_ContainerWithMostWater.optimization;


/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 示例:
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class ContainerWithMostWaterDualPointer {

    /**
     * 双指针，左右指针同时扫描，移动时舍弃短的那部分
     * 时间复杂度O(n)
     */
    public int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length - 1;
        while (left < right) {
            max = Math.max(max,
                    Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] l = new int[]{2, 3, 4, 5, 18, 17, 6};
        ContainerWithMostWaterDualPointer demo = new ContainerWithMostWaterDualPointer();
        int maxArea = demo.maxArea(l);
        System.out.println(maxArea);
    }

}
