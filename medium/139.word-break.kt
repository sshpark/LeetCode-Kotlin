/*
 * @lc app=leetcode id=139 lang=kotlin
 *
 * [139] Word Break
 *
 * https://leetcode.com/problems/word-break/description/
 *
 * algorithms
 * Medium (36.23%)
 * Likes:    2558
 * Dislikes: 137
 * Total Accepted:    372K
 * Total Submissions: 1M
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * 
 * Note:
 * 
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet
 * code".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * 
 * 
 */
class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val n = s.length
        var dp = BooleanArray(n+1) { false }
        dp[0] = true

        for (i in 1 .. n) {
            for(j in 0 .. i-1) {
                if (dp[j]) {
                    val str = s.substring(j, i)
                    if (str in wordDict) {
                        dp[i] = true
                        break
                    }
                }
            }
        }
        return dp[n]
    }
}

