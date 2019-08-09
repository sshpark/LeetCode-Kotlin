/*
 * @lc app=leetcode id=32 lang=kotlin
 *
 * [32] Longest Valid Parentheses
 *
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (25.23%)
 * Likes:    2094
 * Dislikes: 96
 * Total Accepted:    205.3K
 * Total Submissions: 789.7K
 * Testcase Example:  '"(()"'
 *
 * Given a string containing just the characters '(' and ')', find the length
 * of the longest valid (well-formed) parentheses substring.
 * 
 * Example 1:
 * 
 * 
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 * 
 * 
 */
class Solution {
    fun longestValidParentheses(s: String): Int {
        var dp = IntArray(100000, {0})
        var res = 0
        for (i in 2 .. s.length) {
            if (s[i-1] == ')') {
                if (i-dp[i-1]-2 >= 0 && s[i-dp[i-1]-2] == '(') {
                    dp[i] = dp[i-1]+2
                    dp[i] += dp[i-dp[i]]
                }
            }
            if (res < dp[i]) res = dp[i]
        }
        return res
    }
}

