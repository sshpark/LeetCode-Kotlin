/*
 * @lc app=leetcode id=72 lang=kotlin
 *
 * [72] Edit Distance
 *
 * https://leetcode.com/problems/edit-distance/description/
 *
 * algorithms
 * Hard (38.79%)
 * Likes:    2323
 * Dislikes: 35
 * Total Accepted:    187.5K
 * Total Submissions: 483.4K
 * Testcase Example:  '"horse"\n"ros"'
 *
 * Given two words word1 and word2, find the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * 
 * Insert a character
 * Delete a character
 * Replace a character
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation: 
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation: 
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * 
 * 
 */
class Solution {
    fun minDistance(word1: String, word2: String): Int {
        if (word1 == "") return word2.length
        if (word2 == "") return word1.length
        val n = word1.length
        val m = word2.length

        var dp = Array(n+1){IntArray(m+1)}
        
    
        for (i in 0 .. n)  dp[i][0] = i
        for (i in 0 .. m)  dp[0][i] = i

        for (i in 1 .. n) {
            for (j in 1 .. m) {
                if (word1[i-1] == word2[j-1]) {
                    dp[i][j] = dp[i-1][j-1]
                } else {
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]))+1
                }
            }
        }
        return dp[n][m]
    }
}

