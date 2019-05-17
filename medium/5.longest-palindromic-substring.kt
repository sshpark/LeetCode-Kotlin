/*
 * @lc app=leetcode id=5 lang=kotlin
 *
 * [5] Longest Palindromic Substring
 */
class Solution {
    fun longestPalindrome(s: String): String {
        var str = "$#"
        for (i in 0 until s.length) {
            str += s[i]
            str += "#"
        }
        str += "^"

        var RL = IntArray(str.length, {0})
        var maxr = 0
        var pos = 0

        var maxlen = 0
        var id = 0

        for (i in 1 until str.length-1) {
            RL[i] = if (i < maxr) Math.min(RL[2*pos-i], maxr-i) else 1

            while (str[i-RL[i]] == str[i+RL[i]]) RL[i]++
            
            if (RL[i]+i > maxr) {
                maxr = RL[i]+i
                pos = i
            }
        }

        for (i in 1 until str.length-1) {
            if (RL[i] > maxlen) {
                maxlen = RL[i]
                id = i
            }
        }
        val start = (id-maxlen)/2
        val end = start+maxlen-1
        return s.substring(start, end)
    }
}