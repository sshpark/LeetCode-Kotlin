/*
 * @lc app=leetcode id=53 lang=kotlin
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (44.19%)
 * Likes:    4757
 * Dislikes: 176
 * Total Accepted:    588.8K
 * Total Submissions: 1.3M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 */
class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var sum = 0
        var maxa = -2147483647
        nums.forEach { a ->
            if (sum < 0) {
                sum = a
            } else {
                sum += a
            }
            maxa = Math.max(sum, maxa)
        }
        return maxa
    }
}

