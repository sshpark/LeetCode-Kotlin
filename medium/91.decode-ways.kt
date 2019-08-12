 /*
 * @lc app=leetcode id=91 lang=kotlin
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (22.67%)
 * Likes:    1542
 * Dislikes: 1788
 * Total Accepted:    280K
 * Total Submissions: 1.2M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */
class Solution {
    fun numDecodings(s: String): Int {
        val n = s.length

        var dp = IntArray(n+1)
        
        dp[0] = 1
        for (i in 1 .. n) {
            if (s[i-1] != '0') dp[i] = dp[i-1]
            if (i != 1 && (s[i-2]-'0')*10+(s[i-1]-'0') < 27 
            && (s[i-2]-'0')*10+(s[i-1]-'0') > 9) dp[i] += dp[i-2]
        }
        return dp[n]
    }
}

