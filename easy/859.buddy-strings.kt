/*
 * @lc app=leetcode id=859 lang=kotlin
 *
 * [859] Buddy Strings
 *
 * https://leetcode.com/problems/buddy-strings/description/
 *
 * algorithms
 * Easy (27.80%)
 * Likes:    362
 * Dislikes: 217
 * Total Accepted:    30.8K
 * Total Submissions: 110.5K
 * Testcase Example:  '"ab"\n"ba"'
 *
 * Given two strings A and B of lowercase letters, return true if and only if
 * we can swap two letters in A so that the result equals B.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: A = "ab", B = "ba"
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = "ab", B = "ab"
 * Output: false
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: A = "aa", B = "aa"
 * Output: true
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * 
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: A = "", B = "aa"
 * Output: false
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist only of lowercase letters.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    private fun judge(A: String, B: String): Boolean{
        if ((A == B && A[0] == A[1]) || (A != B && A[0] == B[1] && A[1] == B[0]))
            return true
        return false
    }

    fun buddyStrings(A: String, B: String): Boolean {
        if (A.length != B.length || A.length < 2 || B.length < 2) return false
        var diff = 0
        var st1 = ""
        var st2 = ""

        for (i in 0 until A.length) {
            if (A[i] != B[i]) {
                diff++
                st1 += A[i]
                st2 += B[i]
            }
        }
        if (diff == 1 || diff > 2) return false
        else if (diff == 2) return judge(st1, st2)
        else {
            var nums = IntArray(30)
            for (i in 0 until A.length) {
                nums[A[i]-'a']++
                if (nums[A[i]-'a'] >= 2) return true
            }
            return false
        }
        
    }
}
// @lc code=end

