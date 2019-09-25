/*
 * @lc app=leetcode id=31 lang=kotlin
 *
 * [31] Next Permutation
 *
 * https://leetcode.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (30.93%)
 * Likes:    2193
 * Dislikes: 706
 * Total Accepted:    273.1K
 * Total Submissions: 878.5K
 * Testcase Example:  '[1,2,3]'
 *
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */
class Solution {
    fun nextPermutation(nums: IntArray): Unit {
        val n = nums.size
        var flag = -1
        for (i in n-1 downTo 1) {
            if (nums[i] > nums[i-1]) {
                flag = i-1
                break
            }
        }
        if (flag == -1) {
            nums.sort(0, n)
        } else {
            var mina = Int.MAX_VALUE
            var st = -1
            for (i in flag+1 until n) {
                if (nums[i] <= nums[flag]) continue
                if (nums[i] < mina) {
                    mina = nums[i]
                    st = i
                }
            }
            val temp = nums[flag]
            nums[flag] = nums[st]
            nums[st] = temp
            nums.sort(flag+1, n)
        }
    }
}

