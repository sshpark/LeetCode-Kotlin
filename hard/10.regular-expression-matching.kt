/*
 * @lc app=leetcode id=10 lang=kotlin
 *
 * [10] Regular Expression Matching
 *
 * https://leetcode.com/problems/regular-expression-matching/description/
 *
 * algorithms
 * Hard (25.52%)
 * Likes:    2878
 * Dislikes: 552
 * Total Accepted:    326.9K
 * Total Submissions: 1.3M
 * Testcase Example:  '"aa"\n"a"'
 *
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*'.
 * 
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * Note:
 * 
 * 
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters
 * like . or *.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'.
 * Therefore, by repeating 'a' once, it becomes "aa".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * 
 * 
 * Example 4:
 * 
 * 
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore,
 * it matches "aab".
 * 
 * 
 * Example 5:
 * 
 * 
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 * 
 * 
 */
class Solution {
    fun isMatch(s: String, p: String): Boolean {
        var dp = Array(s.length+1){BooleanArray(p.length+1, {false})}
        dp[0][0] = true

        for (i in 0 .. s.length) {
            for (j in 1 .. p.length) {
                if (i > 0 && (s[i-1] == p[j-1] || p[j-1] == '.')) {
                    dp[i][j] = dp[i-1][j-1]
                }
                if (p[j-1] == '*') {
                    if (i == 0 || (s[i-1] != p[j-2] && p[j-2] != '.')) {
                        dp[i][j] = dp[i][j-2]
                    } else {
                        dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i][j-2]
                    }
                }
            }
        }
        return dp[s.length][p.length]
    }
}

