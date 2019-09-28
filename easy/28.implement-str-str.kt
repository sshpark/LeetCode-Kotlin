/*
 * @lc app=leetcode id=28 lang=kotlin
 *
 * [28] Implement strStr()
 *
 * https://leetcode.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (32.70%)
 * Likes:    1053
 * Dislikes: 1501
 * Total Accepted:    497.5K
 * Total Submissions: 1.5M
 * Testcase Example:  '"hello"\n"ll"'
 *
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Example 1:
 * 
 * 
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * 
 * 
 * Clarification:
 * 
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 * 
 */

// @lc code=start
class Solution {
    fun strStr(haystack: String, needle: String): Int {
        if (needle == "") return 0
        
        val n = haystack.length
        val m = needle.length

        for (i in 0 .. n-m) {
            for (j in 0 until m) {
                if (needle[j] != haystack[i+j])
                    break
                if (j == m-1) return i
            }
        }
        return -1
    }
}
// @lc code=end

