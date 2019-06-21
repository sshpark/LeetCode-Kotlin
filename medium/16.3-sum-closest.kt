/*
 * @lc app=leetcode id=16 lang=kotlin
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (43.58%)
 * Likes:    1138
 * Dislikes: 82
 * Total Accepted:    353.1K
 * Total Submissions: 771.6K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var mina = Int.MAX_VALUE
        var closedSum = 0

        for (i in 0 until nums.size-2) {
            var left = i+1
            var right = nums.size-1
            while (left < right) {
                var sum = nums[i]+nums[left]+nums[right]
                var diff = Math.abs(sum-target)

                if (diff < mina) {
                    closedSum = sum
                    mina = diff
                }

                if (sum < target) {
                    left++
                } else if (sum > target) {
                    right--
                } else {
                    return sum
                }
            }
        }
        return closedSum
    }
}

