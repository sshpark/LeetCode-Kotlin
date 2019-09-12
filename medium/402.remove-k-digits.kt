/*
 * @lc app=leetcode id=402 lang=kotlin
 *
 * [402] Remove K Digits
 *
 * https://leetcode.com/problems/remove-k-digits/description/
 *
 * algorithms
 * Medium (26.95%)
 * Likes:    1099
 * Dislikes: 66
 * Total Accepted:    71.4K
 * Total Submissions: 264.7K
 * Testcase Example:  '"1432219"\n3'
 *
 * Given a non-negative integer num represented as a string, remove k digits
 * from the number so that the new number is the smallest possible.
 * 
 * 
 * Note:
 * 
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219
 * which is the smallest.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the
 * output must not contain leading zeroes.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with
 * nothing which is 0.
 * 
 * 
 */
class Solution {
    fun removeKdigits(num: String, k: Int): String {
        var newL = num.length - k
        var s = k
        var stk = CharArray(num.length)
        var top = 0

        for (i in num) {
            while (s > 0 && top > 0 && stk[top-1] > i) {
                top--
                s--
            }
            stk[top++] = i
        }

        var offset = 0
        while (offset < newL && stk[offset] == '0') {
            offset++
        }
        return if (offset == newL) "0" else String(stk, offset, newL-offset)
    }
}

