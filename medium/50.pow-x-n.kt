/*
 * @lc app=leetcode id=50 lang=kotlin
 *
 * [50] Pow(x, n)
 *
 * https://leetcode.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (28.35%)
 * Likes:    924
 * Dislikes: 2262
 * Total Accepted:    346.6K
 * Total Submissions: 1.2M
 * Testcase Example:  '2.00000\n10'
 *
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 * 
 * Example 1:
 * 
 * 
 * Input: 2.00000, 10
 * Output: 1024.00000
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 2.10000, 3
 * Output: 9.26100
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 
 * Note:
 * 
 * 
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 * 
 * 
 */
class Solution {
    fun myPow(x: Double, n: Int): Double {
        var ans = 1.0
        var a = x
        var b = Math.abs(n.toLong())

        while (b > 0) {
            if (b%2 == 1L) ans = ans*a
            a *= a
            b = b.shr(1)
        }
        if (n < 0) return 1/ans
        else return ans
    }
}

