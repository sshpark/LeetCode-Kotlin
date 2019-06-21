/*
 * @lc app=leetcode id=14 lang=kotlin
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (33.28%)
 * Likes:    1381
 * Dislikes: 1329
 * Total Accepted:    475.4K
 * Total Submissions: 1.4M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size == 0) return ""
        var len = 0
        var res = ""
        for (j in 0 until strs[0].length) {
            val c = strs[0][j]
            for (i in 1 until strs.size) {
                if (j >= strs[i].length || strs[i][j] != c) {
                    return res
                }
            }
            res += c
        }
        return res
    }
}

