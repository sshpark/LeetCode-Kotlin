/*
 * @lc app=leetcode id=869 lang=kotlin
 *
 * [869] Reordered Power of 2
 *
 * https://leetcode.com/problems/reordered-power-of-2/description/
 *
 * algorithms
 * Medium (51.23%)
 * Likes:    145
 * Dislikes: 70
 * Total Accepted:    10.7K
 * Total Submissions: 20.9K
 * Testcase Example:  '1'
 *
 * Starting with a positive integer N, we reorder the digits in any order
 * (including the original order) such that the leading digit is not zero.
 * 
 * Return true if and only if we can do this in a way such that the resulting
 * number is a power of 2.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 1
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 10
 * Output: false
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 16
 * Output: true
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: 24
 * Output: false
 * 
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: 46
 * Output: true
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= N <= 10^9
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    private var cnt = IntArray(10)

    fun reorderedPowerOf2(N: Int): Boolean {    
        val str = N.toString()
        
        for (i in str) cnt[i - '0']++

        for (i in 0 until 31) {
            val temp = (1.shl(i)).toString()
            if (temp.length == str.length && ok(temp)) {
                return true
            }
        }
        return false
    }

    private fun ok(str: String): Boolean {
        var vis = IntArray(10)
        for (i in str) vis[i - '0']++

        for (i in 0 until 10)
            if (vis[i] != cnt[i]) return false
        return true
    }
}

