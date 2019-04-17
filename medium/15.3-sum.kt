/*
 * @lc app=leetcode id=15 lang=kotlin
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (23.76%)
 * Total Accepted:    521.8K
 * Total Submissions: 2.2M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val res = mutableListOf<List<Int>>()
        var x: Int
        var y: Int
        for (i in 0 until nums.size-2) {
            if (nums[i] > 0) break
            if (i > 0 && nums[i] == nums[i-1]) continue
            x = i+1
            y = nums.size-1
            while (x < y) {
                val temp = nums[x]+nums[y]+nums[i]
                if (temp == 0) {
                    res.add(listOf(nums[i], nums[x], nums[y]))

                    // 去重操作
                    while (x < y && nums[x] == nums[x+1]) x++
                    while (x < y && nums[y] == nums[y-1]) y--
                    x++
                    y--
                } else if (temp > 0) {
                    y--
                } else {
                    x++
                }
            }        
        }
        return res
    }
}
// fun main(args: Array<String>) {
//     val a = Solution().threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
//     a.forEach {
//         it.forEach { i ->
//             print("$i ")
//         }
//         println("")
//     }
// }
