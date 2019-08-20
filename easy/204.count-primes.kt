/*
 * @lc app=leetcode id=204 lang=kotlin
 *
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (29.56%)
 * Likes:    1209
 * Dislikes: 434
 * Total Accepted:    259.4K
 * Total Submissions: 875.5K
 * Testcase Example:  '10'
 *
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Example:
 * 
 * 
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * 
 * 
 */
class Solution {
    fun countPrimes(n: Int): Int {
        var isp = BooleanArray(n+1) { true }
        var p = mutableListOf<Int>()

        for (i in 2 until n) {
            if (isp[i]) p.add(i)
            for (j in 0 until p.size) {
                if (i*p[j] >= n) break
                isp[i*p[j]] = false
                if (i%p[j] == 0) break
            }
        }
            
        return p.size.toInt()

    }
}