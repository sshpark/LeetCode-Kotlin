/*
 * @lc app=leetcode id=372 lang=kotlin
 *
 * [372] Super Pow
 *
 * https://leetcode.com/problems/super-pow/description/
 *
 * algorithms
 * Medium (35.86%)
 * Likes:    146
 * Dislikes: 602
 * Total Accepted:    29.8K
 * Total Submissions: 83.1K
 * Testcase Example:  '2\n[3]'
 *
 * Your task is to calculate a^b mod 1337 where a is a positive integer and b
 * is an extremely large positive integer given in the form of an array.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: a = 2, b = [3]
 * Output: 8
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: a = 2, b = [1,0]
 * Output: 1024
 * 
 * 
 * 
 */
class Solution {
    private fun qpow(a: Long, b: Long): Long {
        var ans = 1L
        var b = b
        var a = a%1337
        while (b > 0) {
            if (b%2 == 1L) ans = ans*a
            a = a*a%1337
            b = b.shr(1)
        }
        return ans
    }
    /*
     * 4^432 = 4^(400+30+2)
     *       = 4^400 * 4^30 * 4^2
     *       = (4^100)^4 * (4^10)^3 * (4^1)^2
     */ 
    fun superPow(a: Int, b: IntArray): Int {
        var ans = 1L
        var cnt = a.toLong()
        

        for (i in b.size-1 downTo 0) {
            ans = ans * qpow(cnt, b[i].toLong()) % 1337
            cnt = qpow(cnt, 10)
        }

        return ans.toInt()
    }
}

