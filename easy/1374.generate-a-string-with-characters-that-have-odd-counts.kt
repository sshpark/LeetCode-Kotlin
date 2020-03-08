/*
 * @lc app=leetcode id=1374 lang=kotlin
 *
 * [1374] Generate a String With Characters That Have Odd Counts
 *
 * https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/description/
 *
 * algorithms
 * Easy (77.26%)
 * Likes:    10
 * Dislikes: 29
 * Total Accepted:    7.8K
 * Total Submissions: 10.1K
 * Testcase Example:  '4'
 *
 * Given an integer n, return a string with n characters such that each
 * character in such string occurs an odd number of times.
 * 
 * The returned string must contain only lowercase English letters. If there
 * are multiples valid strings, return any of them.  
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 4
 * Output: "pppz"
 * Explanation: "pppz" is a valid string since the character 'p' occurs three
 * times and the character 'z' occurs once. Note that there are many other
 * valid strings such as "ohhh" and "love".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 2
 * Output: "xy"
 * Explanation: "xy" is a valid string since the characters 'x' and 'y' occur
 * once. Note that there are many other valid strings such as "ag" and "ur".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 7
 * Output: "holasss"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 500
 * 
 */

// @lc code=start
class Solution {
    fun generateTheString(n: Int): String {
        var res = ""
        if (n%2 == 1) {
            for (i in 0 until n) res += "a"
            return res
        } else {
            for (i in 1 until n) res += "a"
            return res+"b"
        }
    }
}
// @lc code=end

