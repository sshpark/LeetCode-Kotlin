/*
 * @lc app=leetcode id=213 lang=kotlin
 *
 * [213] House Robber II
 *
 * https://leetcode.com/problems/house-robber-ii/description/
 *
 * algorithms
 * Medium (35.52%)
 * Likes:    1013
 * Dislikes: 35
 * Total Accepted:    127.2K
 * Total Submissions: 357.9K
 * Testcase Example:  '[2,3,2]'
 *
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last
 * one. Meanwhile, adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were broken into on
 * the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money
 * = 2),
 * because they are adjacent houses.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money =
 * 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 */
class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        return Math.max(pre_rob(nums.sliceArray(0 until nums.size-1)),
        pre_rob(nums.sliceArray(1 until nums.size)))
    }

    fun pre_rob(nums: IntArray): Int {
        if (nums.size == 0) return 0
        if (nums.size == 1) return nums[0]

        var l = Math.max(nums[0], nums[1])
        var ll = nums[0]

        for (i in 2 until nums.size) {
            val temp = l
            l = Math.max(l, ll+nums[i])
            ll = temp
        }
        return l     
    }
}

