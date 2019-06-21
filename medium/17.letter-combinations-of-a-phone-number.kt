/*
 * @lc app=leetcode id=17 lang=kotlin
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (41.07%)
 * Likes:    2236
 * Dislikes: 301
 * Total Accepted:    399.4K
 * Total Submissions: 954.7K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
import java.util.LinkedList
class Solution {
    private val mm = mapOf('2' to "abc", '3' to "def", '4' to "ghi", '5' to "jkl", '6' to "mno", '7' to "pqrs", '8' to "tuv", '9' to "wxyz")

    fun letterCombinations(digits: String): List<String> {
        var res = mutableListOf<String>()
        if (digits.length == 0) return res
        var word: String = ""

        fun dfs(cur: Int) {
            if (cur >= digits.length) {
                res.add(word)
                return ;
            }
            for (i in mm[digits[cur]]!!) {
                word += i
                dfs(cur+1)
                word = word.substring(0, word.length-1)
            }
        }
        dfs(0)
        return res
    }
}
