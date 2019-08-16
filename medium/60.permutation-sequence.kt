/*
 * @lc app=leetcode id=60 lang=kotlin
 *
 * [60] Permutation Sequence
 *
 * https://leetcode.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (33.74%)
 * Likes:    931
 * Dislikes: 244
 * Total Accepted:    146.2K
 * Total Submissions: 432.6K
 * Testcase Example:  '3\n3'
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * Given n and k, return the k^th permutation sequence.
 * 
 * Note:
 * 
 * 
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3, k = 3
 * Output: "213"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 4, k = 9
 * Output: "2314"
 * 
 * 
 */
class Solution {
    private fun getsum(n: Int): Int{
        var ans = 1
        for (i in 2 .. n) ans *= i
        return ans
    }
    // 康托展开·
    fun getPermutation(n: Int, k: Int): String {
        var vis = IntArray(n+1, {0})
        var res = ""
        var tn = n
        var tk = k
        for (x in 0 until n) {
            val p = getsum(tn-1)
            var row = tk/p
            if (tk != row*p)
                row++
            var cnt = 0
            var s = 0
            for (i in 0 until n)
                if (vis[i] == 0) {
                    cnt++
                    if (cnt == row) {
                        vis[i] = 1
                        s = i+1
                        break;
                    }
                }
            res += s.toString()
            tk =tk%p
            if (tk == 0) {
                tk = p
            }
            tn--
        }
        return res
    }
}

