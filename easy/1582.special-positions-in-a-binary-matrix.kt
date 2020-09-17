/*
 * @lc app=leetcode id=1582 lang=kotlin
 *
 * [1582] Special Positions in a Binary Matrix
 *
 * https://leetcode.com/problems/special-positions-in-a-binary-matrix/description/
 *
 * algorithms
 * Easy (63.55%)
 * Likes:    84
 * Dislikes: 4
 * Total Accepted:    9.7K
 * Total Submissions: 15.2K
 * Testcase Example:  '[[1,0,0],[0,0,1],[1,0,0]]'
 *
 * Given a rows x cols matrix mat, where mat[i][j] is either 0 or 1, return the
 * number of special positions in mat.
 * 
 * A position (i,j) is called special if mat[i][j] == 1 and all other elements
 * in row i and column j are 0 (rows and columns are 0-indexed).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: mat = [[1,0,0],
 * [0,0,1],
 * [1,0,0]]
 * Output: 1
 * Explanation: (1,2) is a special position because mat[1][2] == 1 and all
 * other elements in row 1 and column 2 are 0.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: mat = [[1,0,0],
 * [0,1,0],
 * [0,0,1]]
 * Output: 3
 * Explanation: (0,0), (1,1) and (2,2) are special positions. 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: mat = [[0,0,0,1],
 * [1,0,0,0],
 * [0,1,1,0],
 * [0,0,0,0]]
 * Output: 2
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: mat = [[0,0,0,0,0],
 * [1,0,0,0,0],
 * [0,1,0,0,0],
 * [0,0,1,0,0],
 * [0,0,0,1,1]]
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] is 0 or 1.
 * 
 * 
 */

// @lc code=start
class Solution {
    fun numSpecial(mat: Array<IntArray>): Int {
        var res = 0
        for (i in 0 until mat.size) {
            var cnt = 0
            for (j in 0 until mat[0].size) {
                if (mat[i][j] == 1) {
                    cnt++
                    if (cnt > 1) break
                    var ok = true
                    for (k in 0 until mat.size) {
                        if (i != k && mat[k][j] != 0) {
                            ok = false
                            break
                        }
                    }
                    for (k in 0 until mat[0].size) {
                        if (j != k && mat[i][k] != 0) {
                            ok = false
                            break
                        }
                    }
                    res = res + if (ok) 1 else 0
                }
            }
        }
        return res
    }
}
// @lc code=end

