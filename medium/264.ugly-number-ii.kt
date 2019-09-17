/*
 * @lc app=leetcode id=264 lang=kotlin
 *
 * [264] Ugly Number II
 *
 * https://leetcode.com/problems/ugly-number-ii/description/
 *
 * algorithms
 * Medium (37.15%)
 * Likes:    1085
 * Dislikes: 72
 * Total Accepted:    115.2K
 * Total Submissions: 307.8K
 * Testcase Example:  '10'
 *
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3,
 * 5. 
 * 
 * Example:
 * 
 * 
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10
 * ugly numbers.
 * 
 * Note:  
 * 
 * 
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 * 
 */
class Solution {
    fun nthUglyNumber(n: Int): Int {
        var ug = IntArray(n+1)
        ug[0] = 1
        var id2 = 0
        var id3 = 0
        var id5 = 0
        var cnt = 1
        while (cnt < n) {
            val temp = Math.min(ug[id2]*2, Math.min(ug[id3]*3, ug[id5]*5))
            if (temp == ug[id2]*2) id2++
            if (temp == ug[id3]*3) id3++
            if (temp == ug[id5]*5) id5++
            ug[cnt++] = temp
        }
        return ug[n-1]
    }
}

