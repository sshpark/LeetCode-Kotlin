/*
 * @lc app=leetcode id=8 lang=kotlin
 *
 * [8] String to Integer (atoi)
 */
class Solution {
    fun myAtoi(str: String): Int {
        var ans =  arrayListOf<Int>()

        var first = false
        var flag = 1
        var pos = 0

        for (i in 0 until str.length) {
            if (str[i] != ' ') {
                if (str[i] in '0' .. '9' || str[i] == '-' || str[i] == '+') {
                    if (str[i] == '-') flag = -1
                    first = true
                    pos = i
                }
                break
            }
        }

        if (!first) {
            return 0
        } else {
            pos = if (str[pos] == '-' || str[pos] == '+') pos+1 else pos
            while (pos < str.length && str[pos] == '0') pos++
            while (pos < str.length && str[pos] in '0'..'9') {
                ans.add(str[pos]-'0')
                pos++
            }
            var cnt: Long = 1
            var res: Long = 0

            if (ans.size > 10) {
                return if (flag == -1) -2147483648 else 2147483647
            }

            for (i in ans.size-1 downTo 0) {
                res += ans[i]*cnt
                cnt *= 10

                if (res >= Int.MAX_VALUE) break
            }
            res *= flag

            if (res < Int.MIN_VALUE) res = -2147483648
            if (res > Int.MAX_VALUE) res = 2147483647

            return res.toInt()
        }
    }
}
