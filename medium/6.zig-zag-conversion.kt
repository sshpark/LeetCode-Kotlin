/*
 * @lc app=leetcode id=6 lang=kotlin
 *
 * [6] ZigZag Conversion
 */
class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s

        var n = s.length
        var res = ""
        var cnt = numRows


        for (i in 0 until numRows) {
            cnt = if (cnt - 1 == 0) numRows-1 else cnt-1

            var x = cnt*2
            var j = i
            while (j < n) {
                res += s[j]
                j += x
                if ((numRows-1)*2-x != 0)
                    x = (numRows-1)*2-x
            }
        }
        return res
    }
}
