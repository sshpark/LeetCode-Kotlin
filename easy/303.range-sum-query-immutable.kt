/*
 * @lc app=leetcode id=303 lang=kotlin
 *
 * [303] Range Sum Query - Immutable
 *
 * https://leetcode.com/problems/range-sum-query-immutable/description/
 *
 * algorithms
 * Easy (39.27%)
 * Likes:    528
 * Dislikes: 832
 * Total Accepted:    150.6K
 * Total Submissions: 382.7K
 * Testcase Example:  '["NumArray","sumRange","sumRange","sumRange"]\n[[[-2,0,3,-5,2,-1]],[0,2],[2,5],[0,5]]'
 *
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * Example:
 * 
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 
 * 
 * 
 * Note:
 * 
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 * 
 * 
 */
class NumArray(nums: IntArray) {
    var dp = IntArray(nums.size+1)

    init {
        for (i in 1 .. nums.size)
            dp[i] = dp[i-1]+nums[i-1]
    }

    fun sumRange(i: Int, j: Int): Int {
        return dp[j+1]-dp[i]    
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(i,j)
 */

