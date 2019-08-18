/*
 * @lc app=leetcode id=69 lang=kotlin
 *
 * [69] Sqrt(x)
 *
 * https://leetcode.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (31.83%)
 * Likes:    842
 * Dislikes: 1469
 * Total Accepted:    401.3K
 * Total Submissions: 1.3M
 * Testcase Example:  '4'
 *
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x, where x is guaranteed to be a
 * non-negative integer.
 * 
 * Since the return type is an integer, the decimal digits are truncated and
 * only the integer part of the result is returned.
 * 
 * Example 1:
 * 
 * 
 * Input: 4
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since 
 * the decimal part is truncated, 2 is returned.
 * 
 * 
 */
class Solution {

    fun mySqrt(x: Int): Int {
        var l: Long = 0
        var r: Long = x.toLong()
        var mid: Long
        var ans: Long = 0
        while (l <= r) {
            mid = (l+r)/2
            // println("mid: ${mid}")
            if (mid*mid == x.toLong()) {
                return mid.toInt()
            }
            if (mid*mid > x) {
                r = mid-1
            } else {
                ans = Math.max(ans, mid)
                l = mid+1
            }
        }
        return ans.toInt()
    }
}
