/*
 * @lc app=leetcode id=9 lang=kotlin
 *
 * [9] Palindrome Number
 */
class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        var a = IntArray(20)
        var cnt = 0
        var n = x

        while (n > 0) {
            a[cnt++] = n%10
            n /= 10
        }
        for (i in 0 until cnt/2) {
            if (a[i] != a[cnt-i-1]) return false
        }
        return true
    }
}

