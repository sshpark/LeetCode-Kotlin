/*
 * @lc app=leetcode id=22 lang=kotlin
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (56.51%)
 * Likes:    3396
 * Dislikes: 202
 * Total Accepted:    401.8K
 * Total Submissions: 700.3K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */

// @lc code=start
class Solution {
    fun generateParenthesis(n: Int): List<String> {
        var res = mutableListOf<String>()
        dfs(n, n, "", res)
        return res
    }

    private fun dfs(left: Int, right: Int, str: String, res: MutableList<String>) {
        if (left > right) return ;
        if (left == 0 && right == 0) {
            res.add(str);
        } else {
            if (left > 0) dfs(left-1, right, str+'(', res);
            if (right > 0) dfs(left, right-1, str+')', res);
        }
    }
}
// @lc code=end

