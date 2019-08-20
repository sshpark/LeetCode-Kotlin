/*
 * @lc app=leetcode id=300 lang=kotlin
 *
 * [300] Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (41.17%)
 * Likes:    2833
 * Dislikes: 67
 * Total Accepted:    248.1K
 * Total Submissions: 601.8K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * Example:
 * 
 * 
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore
 * the length is 4. 
 * 
 * Note: 
 * 
 * 
 * There may be more than one LIS combination, it is only necessary for you to
 * return the length.
 * Your algorithm should run in O(n^2) complexity.
 * 
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 */
class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        var ans = 0
        val n = nums.size

        var dp = IntArray(nums.size+1, {1})
        dp[0] = 1
        for (i in 1 until n) 
            for (j in 0 until i) 
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j]+1)

        for (i in 0 until n) {
            ans = Math.max(ans, dp[i])
        }
        return ans
    }
}

