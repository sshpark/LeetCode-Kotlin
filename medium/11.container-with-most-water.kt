/*
 * @lc app=leetcode id=11 lang=kotlin
 *
 * [11] Container With Most Water
 */
class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size-1
        var maxa = 0

        while (left < right) {
            maxa = Math.max(maxa, Math.min(height[left], height[right])*(right-left))
            if (height[left] > height[right]) {
                right--
            } else {
                left++
            }
        }
        return maxa
    }
}

