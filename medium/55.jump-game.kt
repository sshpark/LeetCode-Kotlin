/*
 * @lc app=leetcode id=55 lang=kotlin
 *
 * [55] Jump Game
 *
 * https://leetcode.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (31.47%)
 * Total Accepted:    243.1K
 * Total Submissions: 772.6K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its
 * maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * 
 * 
 */
class Solution {
    fun canJump(nums: IntArray): Boolean {
        val n = nums.size
        var reach = 0
        for (i in 0 until n) {
            if (i > reach || reach >= n-1) break
            reach = Math.max(reach, i+nums[i])
        }
        return reach >= n-1
    }
}

