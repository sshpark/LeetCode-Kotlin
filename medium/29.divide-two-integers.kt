/*
 * @lc app=leetcode id=29 lang=kotlin
 *
 * [29] Divide Two Integers
 *
 * https://leetcode.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (16.15%)
 * Likes:    736
 * Dislikes: 3527
 * Total Accepted:    208.7K
 * Total Submissions: 1.3M
 * Testcase Example:  '10\n3'
 *
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero.
 * 
 * Example 1:
 * 
 * 
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * 
 * Note:
 * 
 * 
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
 * of this problem, assume that your function returns 2^31 − 1 when the
 * division result overflows.
 * 
 * 
 */
class Solution {
    fun divide(dividend: Int, divisor: Int): Int {
        if (dividend == Int.MIN_VALUE && divisor == -1) {
            return Int.MAX_VALUE
        }

        var a = Math.abs(dividend.toLong())
        var b = Math.abs(divisor.toLong())
        var res = 0

        while (a >= b) {
            var sum = b
            var cnt = 1

            while (sum+sum <= a) {
                sum += sum
                cnt += cnt
            }
            a -= sum
            res += cnt
        }
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            res = -res
        return res
    }
}

