/*
 * @lc app=leetcode id=1404 lang=kotlin
 *
 * [1404] Number of Steps to Reduce a Number in Binary Representation to One
 *
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description/
 *
 * algorithms
 * Medium (46.45%)
 * Likes:    112
 * Dislikes: 16
 * Total Accepted:    10.7K
 * Total Submissions: 21.6K
 * Testcase Example:  '"1101"'
 *
 * Given a number s in their binary representation. Return the number of steps
 * to reduce it to 1 under the following rules:
 * 
 * 
 * 
 * If the current number is even, you have to divide it by 2.
 * 
 * 
 * If the current number is odd, you have to add 1 to it.
 * 
 * 
 * 
 * It's guaranteed that you can always reach to one for all testcases.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "1101"
 * Output: 6
 * Explanation: "1101" corressponds to number 13 in their decimal
 * representation.
 * Step 1) 13 is odd, add 1 and obtain 14. 
 * Step 2) 14 is even, divide by 2 and obtain 7.
 * Step 3) 7 is odd, add 1 and obtain 8.
 * Step 4) 8 is even, divide by 2 and obtain 4.  
 * Step 5) 4 is even, divide by 2 and obtain 2. 
 * Step 6) 2 is even, divide by 2 and obtain 1.  
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "10"
 * Output: 1
 * Explanation: "10" corressponds to number 2 in their decimal representation.
 * Step 1) 2 is even, divide by 2 and obtain 1.  
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "1"
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 500
 * s consists of characters '0' or '1'
 * s[0] == '1'
 * 
 * 
 */

// @lc code=start
class Solution {
    fun numSteps(s: String): Int {
        var res = 0
        var cnt = 0
        for (i in s.length-1 downTo 1) {
            res++
            if (s[i]-'0'+cnt == 1) {
                res++
                cnt = 1
            }
        }
        return res+cnt
    }
}
// @lc code=end

