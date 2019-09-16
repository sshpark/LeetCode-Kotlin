/*
 * @lc app=leetcode id=67 lang=kotlin
 *
 * [67] Add Binary
 *
 * https://leetcode.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (40.17%)
 * Likes:    1144
 * Dislikes: 219
 * Total Accepted:    337.4K
 * Total Submissions: 832.8K
 * Testcase Example:  '"11"\n"1"'
 *
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * 
 * Input: a = "11", b = "1"
 * Output: "100"
 * 
 * Example 2:
 * 
 * 
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 */
class Solution {
    fun addBinary(a: String, b: String): String {
        var lena = a.length-1
        var lenb = b.length-1
        var res: String = ""
        var cnt = 0

        while (lena >= 0 || lenb >= 0) {
            var temp = 0
            if (lena >= 0) temp += a[lena]-'0'
            lena--
            if (lenb >= 0) temp += b[lenb]-'0'
            lenb--
            res += ((temp+cnt)%2).toString()
            cnt = (temp+cnt)/2
        }
        if (cnt > 0) res += "1"
        return res.reversed()
    }
}

