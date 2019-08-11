/*
 * @lc app=leetcode id=85 lang=kotlin
 *
 * [85] Maximal Rectangle
 *
 * https://leetcode.com/problems/maximal-rectangle/description/
 *
 * algorithms
 * Hard (34.14%)
 * Likes:    1614
 * Dislikes: 53
 * Total Accepted:    130.2K
 * Total Submissions: 381.2K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing only 1's and return its area.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * ⁠ ["1","0","1","0","0"],
 * ⁠ ["1","0","1","1","1"],
 * ⁠ ["1","1","1","1","1"],
 * ⁠ ["1","0","0","1","0"]
 * ]
 * Output: 6
 * 
 * 
 */
class Solution {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        if (matrix.size == 0) return 0

        val n = matrix.size
        val m = matrix[0].size

        var dp = Array(n+5){IntArray(m+5)}
        
        for (i in 0 until n)
            for (j in 0 until m)
                dp[i+1][j+1] = matrix[i][j]-'0'

        var col = Array(n+5){IntArray(m+5)}
        for (i in 1 .. m) {
            for (j in 1 .. n) {
                if (dp[j][i] == 1)
                    col[j][i] = col[j-1][i]+dp[j][i] 
            }
        }
        // for (i in 1 ..n) {
        //     for (j in 1 .. m) {
        //         print("${col[i][j]} ")
        //     }
        //     println()
        // }
        var maxa = 0
        for (i in 1 .. n) {
            for (j in i .. n) {
                var r = IntArray(m+1)
                for (k in 1 .. m)
                    r[k] = col[j][k]-col[i-1][k]
                // println("${i} ${j}")
                // for (k in 1 .. m) {
                //     print("${r[k]} ")
                // }
                // println()
                // println()
                var temp = 0
                for (k in 1 .. m) {
                    if (r[k] == r[k-1]) {
                        temp += r[k]
                    } else {
                        temp = r[k]
                    }
                    maxa = Math.max(maxa, temp)
                }
            }
        }
        return maxa
    }
}
// fun main(args: Array<String>) {
//     val s = Solution()
//     println(s.maximalRectangle(arrayOf(charArrayOf('0', '1'), charArrayOf('1', '0'))))
// }

