/*
 * @lc app=leetcode id=872 lang=kotlin
 *
 * [872] Leaf-Similar Trees
 *
 * https://leetcode.com/problems/leaf-similar-trees/description/
 *
 * algorithms
 * Easy (64.83%)
 * Likes:    587
 * Dislikes: 30
 * Total Accepted:    73.1K
 * Total Submissions: 112.8K
 * Testcase Example:  '[3,5,1,6,2,9,8,null,null,7,4]\n' +
  '[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]'
 *
 * Consider all the leaves of a binary tree.  From left to right order, the
 * values of those leaves form a leaf value sequence.
 * 
 * 
 * 
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4,
 * 9, 8).
 * 
 * Two binary trees are considered leaf-similar if their leaf value sequence is
 * the same.
 * 
 * Return true if and only if the two given trees with head nodes root1 and
 * root2 are leaf-similar.
 * 
 * 
 * Constraints:
 * 
 * 
 * Both of the given trees will have between 1 and 200 nodes.
 * Both of the given trees will have values between 0 and 200
 * 
 * 
 */

// @lc code=start
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
class Solution {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()
        getSequence(root1, list1)
        getSequence(root2, list2)

        if (list1.size != list2.size) return false


        for (i in 0 until list1.size) {
            if (list1[i] != list2[i]) {
                return false
            }
        }
        return true
    }

    fun getSequence(root: TreeNode?, res: MutableList<Int>) {
        if (root?.left == null && root?.right == null) res.add(root!!.`val`)
        if (root?.left != null) getSequence(root?.left, res)
        if (root?.right != null) getSequence(root?.right, res)
    }
}
// @lc code=end

