/*
 * @lc app=leetcode id=64 lang=kotlin
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (47.98%)
 * Likes:    1523
 * Dislikes: 42
 * Total Accepted:    249.1K
 * Total Submissions: 519.2K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * 
 * 
 */
class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        var dp = Array(1005){IntArray(1005, {0})}
        
        dp[0][0] = grid[0][0]
        for (i in 1 until grid.size) dp[i][0] = dp[i-1][0]+grid[i][0]
        for (i in 1 until grid[0].size) dp[0][i] = dp[0][i-1]+grid[0][i]

        for (i in 1 until grid.size) {
            for (j in 1 until grid[0].size) {
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j])+grid[i][j]
            }
        }
        return dp[grid.size-1][grid[0].size-1]
    }
}

