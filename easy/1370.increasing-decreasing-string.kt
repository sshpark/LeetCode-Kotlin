/*
 * @lc app=leetcode id=1370 lang=kotlin
 *
 * [1370] Increasing Decreasing String
 *
 * https://leetcode.com/problems/increasing-decreasing-string/description/
 *
 * algorithms
 * Easy (78.72%)
 * Likes:    51
 * Dislikes: 34
 * Total Accepted:    5.3K
 * Total Submissions: 6.8K
 * Testcase Example:  '"aaaabbbbcccc"'
 *
 * Given a string s. You should re-order the string using the following
 * algorithm:
 * 
 * 
 * Pick the smallest character from s and append it to the result.
 * Pick the smallest character from s which is greater than the last appended
 * character to the result and append it.
 * Repeat step 2 until you cannot pick more characters.
 * Pick the largest character from s and append it to the result.
 * Pick the largest character from s which is smaller than the last appended
 * character to the result and append it.
 * Repeat step 5 until you cannot pick more characters.
 * Repeat the steps from 1 to 6 until you pick all characters from s.
 * 
 * 
 * In each step, If the smallest or the largest character appears more than
 * once you can choose any occurrence and append it to the result.
 * 
 * Return the result string after sorting s with this algorithm.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "aaaabbbbcccc"
 * Output: "abccbaabccba"
 * Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
 * After steps 4, 5 and 6 of the first iteration, result = "abccba"
 * First iteration is done. Now s = "aabbcc" and we go back to step 1
 * After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
 * After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "rat"
 * Output: "art"
 * Explanation: The word "rat" becomes "art" after re-ordering it with the
 * mentioned algorithm.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "leetcode"
 * Output: "cdelotee"
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "ggggggg"
 * Output: "ggggggg"
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: s = "spo"
 * Output: "ops"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 500
 * s contains only lower-case English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    fun sortString(s: String): String {
        var ans = StringBuilder()
        var cnt = IntArray(26)
        for (c in s) cnt[c-'a']++
        while (ans.length < s.length) {
            add(cnt, ans, true)
            add(cnt, ans, false)
        }
        return ans.toString()
    }

    private fun add(cnt: IntArray, ans: StringBuilder, asc:Boolean) {
        for (i in 0 until 26) {
            val j = if (asc) i else 25-i
            if (cnt[j]-- > 0)
                ans.append((j+'a'.toInt()).toChar())
        }
    }
}
// @lc code=end

