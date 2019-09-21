/*
 * @lc app=leetcode id=515 lang=kotlin
 *
 * [515] Find Largest Value in Each Tree Row
 *
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 *
 * algorithms
 * Medium (58.37%)
 * Likes:    562
 * Dislikes: 48
 * Total Accepted:    71.8K
 * Total Submissions: 122.6K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * You need to find the largest value in each row of a binary tree.
 * 
 * Example:
 * 
 * Input: 
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      / \   \  
 * ⁠     5   3   9 
 * 
 * Output: [1, 3, 9]
 * 
 * 
 * 
 */
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

import java.util.LinkedList

// BFS 遍历每一层元素
class Solution {
    fun largestValues(root: TreeNode?): List<Int> {
        if (root == null) return listOf<Int>()

        var q = LinkedList<TreeNode?>()
        var res = mutableListOf<Int>()
        q.offer(root)
        
        while (true) {
            var maxa = Int.MIN_VALUE
            val cnt = q.size
            if (cnt == 0) break
            for (i in 0 until cnt) {
                val top = q.poll()
                // println(top!!.`val`)
                maxa = Math.max(maxa, top!!.`val`)

                if (top?.left != null) q.offer(top?.left)
                if (top?.right != null) q.offer(top?.right)
            }
            res.add(maxa)
        }
        return res
    }
}

