/*
 * @lc app=leetcode id=329 lang=kotlin
 *
 * [329] Longest Increasing Path in a Matrix
 *
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
 *
 * algorithms
 * Hard (40.64%)
 * Likes:    1136
 * Dislikes: 19
 * Total Accepted:    96.6K
 * Total Submissions: 237.4K
 * Testcase Example:  '[[9,9,4],[6,6,8],[2,1,1]]'
 *
 * Given an integer matrix, find the length of the longest increasing path.
 * 
 * From each cell, you can either move to four directions: left, right, up or
 * down. You may NOT move diagonally or move outside of the boundary (i.e.
 * wrap-around is not allowed).
 * 
 * Example 1:
 * 
 * 
 * Input: nums = 
 * [
 * ⁠ [9,9,4],
 * ⁠ [6,6,8],
 * ⁠ [2,1,1]
 * ] 
 * Output: 4 
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = 
 * [
 * ⁠ [3,4,5],
 * ⁠ [3,2,6],
 * ⁠ [2,2,1]
 * ] 
 * Output: 4 
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally
 * is not allowed.
 * 
 * 
 */
class Solution {
    private var dp = Array(1005){IntArray(1005)}
    private val dir = arrayOf(intArrayOf(0, -1), intArrayOf(0, 1), 
                            intArrayOf(-1, 0), intArrayOf(1, 0))

    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        if (matrix.size == 0) return 0

        var ans = 0
        val n = matrix.size
        val m = matrix[0].size
        for (i in 0 until n)
            for (j in 0 until m)
                ans = Math.max(ans, dfs(matrix, i, j))
        return ans
    }

    private fun dfs(matrix: Array<IntArray>, x: Int, y: Int): Int {
        if (dp[x][y] > 0) return dp[x][y]
        dp[x][y] = 1
        for (i in 0 .. 3) {
            val nx = x+dir[i][0]
            val ny = y+dir[i][1]
            if (nx >= matrix.size || nx < 0 
            || ny >= matrix[0].size || ny < 0) continue
            if (matrix[nx][ny] > matrix[x][y]) {
                dp[x][y] = Math.max(dp[x][y], 1+dfs(matrix, nx, ny))
            }
        }
        return dp[x][y]
    }
}

