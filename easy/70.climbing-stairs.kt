/*
 * @lc app=leetcode id=70 lang=kotlin
 *
 * [70] Climbing Stairs
 *
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (44.72%)
 * Likes:    2470
 * Dislikes: 89
 * Total Accepted:    444.8K
 * Total Submissions: 994.4K
 * Testcase Example:  '2'
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * 
 */
class Solution {
    fun climbStairs(n: Int): Int {
        var dp = IntArray(55, {0})
        dp[1] = 1
        dp[2] = 2

        (3 .. n).forEach { i ->
            dp[i] = dp[i-1]+dp[i-2]
        }
        return dp[n]
    }
}

