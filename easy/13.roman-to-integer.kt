/*
 * @lc app=leetcode id=13 lang=kotlin
 *
 * [13] Roman to Integer
 */
class Solution {
    private val Rm2I = mapOf('I' to 1, 'V' to 5, 
    'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)

    fun romanToInt(s: String): Int {
        var res = 0
        var i = 0
        while (i < s.length) {
            if (i == s.length-1) {
                res += Rm2I[s[i]]!!
                break
            }
            if (Rm2I[s[i]]!! < Rm2I[s[i+1]]!!) {
                res += Rm2I[s[i+1]]!!-Rm2I[s[i]]!!
                i += 2
            } else {
                res += Rm2I[s[i]]!!
                i++
            }
        }
        return res
    }
}

