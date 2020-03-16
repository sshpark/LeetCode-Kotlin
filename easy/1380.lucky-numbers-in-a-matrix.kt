/*
 * @lc app=leetcode id=1380 lang=kotlin
 *
 * [1380] Lucky Numbers in a Matrix
 *
 * https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/
 *
 * algorithms
 * Easy (76.49%)
 * Likes:    46
 * Dislikes: 2
 * Total Accepted:    7.3K
 * Total Submissions: 9.5K
 * Testcase Example:  '[[3,7,8],[9,11,13],[15,16,17]]'
 *
 * Given a m * n matrix of distinct numbers, return all lucky numbers in the
 * matrix in any order.
 * 
 * A lucky number is an element of the matrix such that it is the minimum
 * element in its row and maximum in its column.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * Output: [15]
 * Explanation: 15 is the only lucky number since it is the minimum in its row
 * and the maximum in its column
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * Output: [12]
 * Explanation: 12 is the only lucky number since it is the minimum in its row
 * and the maximum in its column.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: matrix = [[7,8],[1,2]]
 * Output: [7]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 10^5.
 * All elements in the matrix are distinct.
 * 
 */

// @lc code=start
class Solution {
    fun luckyNumbers (matrix: Array<IntArray>): List<Int> {
        val n = matrix.size
        val m = matrix[0].size
        val res = mutableListOf<Int>()
        for (i in 0 until n) {
            var temp = 1000000
            var pos = 0
            for (j in 0 until m) {
                if (matrix[i][j] < temp) {
                    temp = matrix[i][j]
                    pos = j
                }
            }
            var flag = true
            for (j in 0 until n) {
                if (j != i && matrix[j][pos] > temp) {
                    flag = false
                    break
                }
            }
            if (flag) res.add(temp)
        }
        return res
    }
}
// @lc code=end

