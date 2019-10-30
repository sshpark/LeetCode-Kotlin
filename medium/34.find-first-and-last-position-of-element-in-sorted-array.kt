/*
 * @lc app=leetcode id=34 lang=kotlin
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (34.46%)
 * Likes:    2153
 * Dislikes: 100
 * Total Accepted:    369.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 */

// @lc code=start
class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.size == 0) return intArrayOf(-1, -1)

        var l: Int = 0
        var r: Int = nums.size-1
        var mid = 0
        var res = IntArray(2)

        while (l < r) {
            mid = (l+r) / 2
            if (nums[mid] < target) {
                l = mid+1
            } else {
                r = mid
            }
        }
        if (nums[l] != target) return intArrayOf(-1, -1)
        res[0] = l

        r = nums.size-1

        while (l < r) {
            mid = (l+r) / 2 + 1
            if (nums[mid] == target) {
                l = mid
            } else {
                r = mid-1
            }
        }
        res[1] = l
        return res
    }
}
// @lc code=end

