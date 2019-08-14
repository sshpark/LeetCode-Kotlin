/*
 * @lc app=leetcode id=18 lang=kotlin
 *
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (31.15%)
 * Likes:    1202
 * Dislikes: 238
 * Total Accepted:    252.9K
 * Total Submissions: 810.5K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */
class Solution {
    // val res = mutableListOf<MutableList<Int> >()
    // var vis = BooleanArray(1005, {false})
    // var visb = BooleanArray(10005, {false})
    // var b = IntArray(1005)
    // var id = IntArray(1005)
    
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        var res = mutableListOf<MutableList<Int>>()

        if (nums.isEmpty()) return res

        nums.sort()
        val n = nums.size.toInt()
        var i = 0
        var j = 0
        while (i < n) {
            j = i+1
            while (j < n) {
                var left = j+1
                var right = n-1

                while (left < right) {
                    val cursum = nums[i]+nums[j]+nums[left]+nums[right]
                    if (cursum == target) {
                        res.add(mutableListOf(nums[i], nums[j], nums[left], nums[right]))

                        while (left < right && nums[left] == nums[left+1]) ++left
                        while (left < right && nums[right] == nums[right-1]) --right
                        ++left
                        --right
                    } else if (cursum < target) {
                        ++left
                    } else {
                        --right
                    }
                }
                while (j+1 < n && nums[j] == nums[j+1]) ++j
                ++j
            }
            while (i+1 < n && nums[i] == nums[i+1]) ++i
            ++i
        }
        return res
    }

//     fun dfs(nums: IntArray, step: Int, n: Int, t: Int) {
//         if (step > 3) {
//             val sum = b[0]+b[1]+b[2]+b[3]
//             val ok = id[0]+id[1]+id[2]+id[3]
//             if (sum == t && visb[ok] == false) {
//                 visb[ok] = true
//                 // b.sort(0, 3)
//                 res.add(mutableListOf(b[0], b[1], b[2], b[3]))
//             }
//             return
//         }
//         for (i in 0 until n) {
//             if (!vis[i]) {
//                 b[step] = nums[i]
//                 id[step] = i
//                 vis[i] = true
//                 dfs(nums, step+1, n, t)
//                 vis[i] = false
//             }
//         }
//     }
}
// fun main(args: Array<String>) {
//     val s = Solution().fourSum(intArrayOf(-3,-2,-1,0,0,1,2,3), 0)
//     for (i in s)
//         println(i)
// }

