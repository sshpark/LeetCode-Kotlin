/*
 * @lc app=leetcode id=1550 lang=kotlin
 *
 * [1550] Three Consecutive Odds
 *
 * https://leetcode.com/problems/three-consecutive-odds/description/
 *
 * algorithms
 * Easy (68.07%)
 * Likes:    53
 * Dislikes: 8
 * Total Accepted:    11.9K
 * Total Submissions: 17.4K
 * Testcase Example:  '[2,6,4,1]'
 *
 * Given an integer array arr, return true if there are three consecutive odd
 * numbers in the array. Otherwise, return false.
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [2,6,4,1]
 * Output: false
 * Explanation: There are no three consecutive odds.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [1,2,34,3,4,5,7,23,12]
 * Output: true
 * Explanation: [5,7,23] are three consecutive odds.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        val n = arr.size
        for (i in 0 until arr.size-2) {
            if (arr[i]%2 == 1 && arr[i+1]%2 == 1 && arr[i+2]%2 == 1) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

