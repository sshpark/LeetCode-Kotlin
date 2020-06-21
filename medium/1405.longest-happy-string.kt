/*
 * @lc app=leetcode id=1405 lang=kotlin
 *
 * [1405] Longest Happy String
 *
 * https://leetcode.com/problems/longest-happy-string/description/
 *
 * algorithms
 * Medium (38.06%)
 * Likes:    175
 * Dislikes: 56
 * Total Accepted:    7.2K
 * Total Submissions: 15.6K
 * Testcase Example:  '1\n1\n7'
 *
 * A string is called happy if it does not have any of the strings 'aaa', 'bbb'
 * or 'ccc' as a substring.
 * 
 * Given three integers a, b and c, return any string s, which satisfies
 * following conditions:
 * 
 * 
 * s is happy and longest possible.
 * s contains at most a occurrences of the letter 'a', at most b occurrences of
 * the letter 'b' and at most c occurrences of the letter 'c'.
 * s will only contain 'a', 'b' and 'c' letters.
 * 
 * 
 * If there is no such string s return the empty string "".
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: a = 1, b = 1, c = 7
 * Output: "ccaccbcc"
 * Explanation: "ccbccacc" would also be a correct answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: a = 2, b = 2, c = 1
 * Output: "aabbc"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: a = 7, b = 1, c = 0
 * Output: "aabaa"
 * Explanation: It's the only correct answer in this case.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 * 
 * 
 */

// @lc code=start
class Solution {
    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val total = a + b + c
        val f = intArrayOf(a, b, c)
        val l = IntArray(3)
        var res = ""
        for (x in 0 until total) {
            for (i in 0 until 3) {
                val j = (i+1)%3
                val k = (i+2)%3
                if ((f[i] >= f[j] && f[i] >= f[k] && l[i] != 2) 
                || (f[i] > 0 && (l[j] == 2 || l[k] == 2))) {
                    res += 'a' + i
                    l[i]++
                    f[i]--
                    l[j] = 0
                    l[k] = 0
                    break
                }
            }
        }
        return res
    }
}
// @lc code=end

