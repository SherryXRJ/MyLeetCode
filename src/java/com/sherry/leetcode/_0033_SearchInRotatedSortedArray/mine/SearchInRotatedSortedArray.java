package com.sherry.leetcode._0033_SearchInRotatedSortedArray.mine;

/**
 * 33. 搜索旋转排序数组
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 */
public class SearchInRotatedSortedArray {

    /**
     * 先找旋转点，通过旋转点将数组分为2部分
     *
     * 再判断在哪部分进行二分查找
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        int left = 0, right = nums.length - 1;

        int point = 0;

        //  找旋转点
        while (left <= right) {
            //  中点
            int mid = (right + left) / 2;

            if (mid == 0 || mid == nums.length) break;

            //  旋转点在中点右边
            if (nums[mid] > nums[left] && nums[mid] > nums[right]) {
                left = mid;
            }
            //  旋转点在中点左边
            else if (nums[mid] < nums[left] && nums[mid] < nums[right]) {
                right = mid;
            }
            else {
                // FIXME: 没有旋转点时 point是数组中点，也不影响输出
                point = mid;
                break;
            }
        }

        System.out.println(point);

        //  确定在哪段进行二分查找
        if (target >= nums[0] && target <= nums[point]) return this.binarySearch(nums, 0, point, target);
        else if (target >= nums[point + 1] && target <= nums[nums.length - 1]) return this.binarySearch(nums, point + 1, nums.length - 1, target);
        else return -1;
    }

    public int binarySearch(int nums[], int low, int high, int target){
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (target > nums[mid]) low = mid + 1;
            else if (target < nums[mid]) high = mid - 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray demo = new SearchInRotatedSortedArray();
        System.out.println(demo.search(new int []{1,2,3,4,5,6,7}, 0));
    }
}
