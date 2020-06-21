/*
 * @lc app=leetcode id=169 lang=kotlin
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (56.05%)
 * Likes:    2615
 * Dislikes: 206
 * Total Accepted:    528.4K
 * Total Submissions: 939.8K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 */

// @lc code=start
class Solution {
    fun majorityElement(nums: IntArray): Int {
        val n = nums.size/2
        val mm = mutableMapOf<Int, Int>()
        nums.forEach { 
            mm.put(it, mm.getOrDefault(it, 0)+1)
            if (mm.getOrDefault(it, 0) > n) return it
        }
        return -1
    }
}
// @lc code=end

