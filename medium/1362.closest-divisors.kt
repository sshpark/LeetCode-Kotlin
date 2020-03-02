/*
 * @lc app=leetcode id=1362 lang=kotlin
 *
 * [1362] Closest Divisors
 *
 * https://leetcode.com/problems/closest-divisors/description/
 *
 * algorithms
 * Medium (53.70%)
 * Likes:    40
 * Dislikes: 21
 * Total Accepted:    5.9K
 * Total Submissions: 10.9K
 * Testcase Example:  '8'
 *
 * Given an integer num, find the closest two integers in absolute difference
 * whose product equals num + 1 or num + 2.
 * 
 * Return the two integers in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: num = 8
 * Output: [3,3]
 * Explanation: For num + 1 = 9, the closest divisors are 3 & 3, for num + 2 =
 * 10, the closest divisors are 2 & 5, hence 3 & 3 is chosen.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: num = 123
 * Output: [5,25]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: num = 999
 * Output: [40,25]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= num <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    fun closestDivisors(num: Int): IntArray {
        val len = Math.sqrt((num+2).toDouble()).toInt()
        for (i in len downTo 1) {
            if ((num+1)%i == 0) return intArrayOf(i, (num+1)/i)
            if ((num+2)%i == 0) return intArrayOf(i, (num+2)/i)
        }
        return intArrayOf(0, 0)
    }
}
// @lc code=end

