/*
 * @lc app=leetcode id=268 lang=kotlin
 *
 * [268] Missing Number
 *
 * https://leetcode.com/problems/missing-number/description/
 *
 * algorithms
 * Easy (47.91%)
 * Total Accepted:    262.4K
 * Total Submissions: 547K
 * Testcase Example:  '[3,0,1]'
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,0,1]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * 
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant extra space complexity?
 */
class Solution {
    fun missingNumber(nums: IntArray): Int {
        var sum = 0
        var n = nums.size
        nums.forEach {
            sum += it
        }
        return n*(n+1)/2 - sum
    }
}

