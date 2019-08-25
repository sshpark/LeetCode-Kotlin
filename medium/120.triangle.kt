/*
 * @lc app=leetcode id=120 lang=kotlin
 *
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * algorithms
 * Medium (40.39%)
 * Likes:    1261
 * Dislikes: 144
 * Total Accepted:    195.1K
 * Total Submissions: 482.7K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 */
class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        var n = triangle.size

        if (n == 0) return 0

        var dp = Array(n+1) { IntArray(n+1, {0x3f3f3f3f}) }
        dp[0][0] = triangle[0][0]

        for (i in 1 until n)
            for (j in 0 .. i)
                if (j == 0) dp[i][j] = dp[i-1][j]+triangle[i][j]
                else dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1])+triangle[i][j]
        var maxa = 0x3f3f3f3f
        for (i in 0 until n) maxa = Math.min(maxa, dp[n-1][i])
        
        return maxa
    }
}

