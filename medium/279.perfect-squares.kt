/*
 * @lc app=leetcode id=279 lang=kotlin
 *
 * [279] Perfect Squares
 *
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (41.37%)
 * Total Accepted:    173.3K
 * Total Submissions: 418K
 * Testcase Example:  '12'
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * 
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * 
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
class Solution {
    fun numSquares(n: Int): Int {
        var mN = n
        while (mN % 4 == 0) mN /= 4
        if (mN % 8 == 7) return 4
        var i = 0
        while (i*i <= n) {
            val temp = Math.sqrt(n-i*i*1.0).toInt()
            if (n == temp*temp+i*i) {
                return if (temp == 0 || i == 0) 1 else 2
            }
            i++
        }
        return 3
    }
}
fun main(args: Array<String>) {
    val test = Solution()
    println(test.numSquares(29825))
}