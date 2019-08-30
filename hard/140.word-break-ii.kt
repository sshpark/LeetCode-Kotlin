/*
 * @lc app=leetcode id=140 lang=kotlin
 *
 * [140] Word Break II
 *
 * https://leetcode.com/problems/word-break-ii/description/
 *
 * algorithms
 * Hard (27.98%)
 * Likes:    1122
 * Dislikes: 261
 * Total Accepted:    171.4K
 * Total Submissions: 611.3K
 * Testcase Example:  '"catsanddog"\n["cat","cats","and","sand","dog"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is
 * a valid dictionary word. Return all such possible sentences.
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
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 * 
 */
class Solution {
    var dp = mutableMapOf<String, List<String>>()

    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        if (dp.containsKey(s)) return dp[s]!!
        var a = mutableListOf<String>()

        for (i in wordDict.indices) {
            val temp = wordDict[i]
            if (s.length >= temp.length && s.substring(0, temp.length) == temp) {
                if (temp.length == s.length) {
                    a.add(temp)
                } else {
                    val subR = wordBreak(s.substring(temp.length), wordDict)
                    for (j in subR.indices) {
                        a.add("${temp} ${subR[j]}")
                    }
                }
            }
        }
        dp[s] = a
        return a
    }
}

