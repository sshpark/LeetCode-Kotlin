/*
 * @lc app=leetcode id=63 lang=kotlin
 *
 * [63] Unique Paths II
 *
 * https://leetcode.com/problems/unique-paths-ii/description/
 *
 * algorithms
 * Medium (33.60%)
 * Likes:    939
 * Dislikes: 151
 * Total Accepted:    214.9K
 * Total Submissions: 639.5K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * 
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * Note: m and n will be at most 100.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * 
 * 
 */
class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        var dp = Array(105){IntArray(105, {0})}
        
        dp[0][0] = if (obstacleGrid[0][0] == 1) 0 else 1

        for (i in 1 until obstacleGrid.size) 
            if (obstacleGrid[i][0] != 1)
                dp[i][0] = dp[i-1][0]

        for (i in 1 until obstacleGrid[0].size) 
            if (obstacleGrid[0][i] != 1)
                dp[0][i] = dp[0][i-1]
        
        for (i in 1 until obstacleGrid.size) {
            for (j in 1 until obstacleGrid[0].size) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0
                else dp[i][j] = dp[i-1][j] + dp[i][j-1]
            }
        }
        return dp[obstacleGrid.size-1][obstacleGrid[0].size-1]
    }
}

