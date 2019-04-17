/*
 * @lc app=leetcode id=38 lang=kotlin
 *
 * [38] Count and Say
 *
 * https://leetcode.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (39.98%)
 * Total Accepted:    270.6K
 * Total Submissions: 676.6K
 * Testcase Example:  '1'
 *
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 * 
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n where 1 ≤ n ≤ 30, generate the n^th term of the
 * count-and-say sequence.
 * 
 * Note: Each term of the sequence of integers will be represented as a
 * string.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 1
 * Output: "1"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 4
 * Output: "1211"
 * 
 */
class Solution {
    fun countAndSay(n: Int): String {
        var last = "1"
        (1 until n).forEach {
            var nextStr = ""
            var cnt = 0
            for (i in 0 until last.length) {
                if (i == 0) {
                    cnt++
                } else if (last[i] == last[i-1]) {
                    cnt++
                } else {
                    nextStr += "${cnt}${last[i-1]}"
                    cnt = 1
                }
                if (i == last.length-1)
                        nextStr += "${cnt}${last[i]}"
            }
            last = nextStr
        }
        return last
    }
}