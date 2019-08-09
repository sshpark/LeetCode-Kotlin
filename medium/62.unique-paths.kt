/*
 * @lc app=leetcode id=62 lang=kotlin
 *
 * [62] Unique Paths
 *
 * https://leetcode.com/problems/unique-paths/description/
 *
 * algorithms
 * Medium (48.55%)
 * Likes:    1773
 * Dislikes: 121
 * Total Accepted:    314K
 * Total Submissions: 646.8K
 * Testcase Example:  '3\n2'
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * Example 1:
 * 
 * 
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the
 * bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: m = 7, n = 3
 * Output: 28
 * 
 */
class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        var dp = Array(105){IntArray(105, {0})}

        dp[0][1] = 1

        for (i in 1 .. m) {
            for (j in 1 .. n) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1]
            }
        }
        return dp[m][n]
    }
}

