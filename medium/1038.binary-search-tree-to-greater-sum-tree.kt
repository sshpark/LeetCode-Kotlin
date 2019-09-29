/*
 * @lc app=leetcode id=1038 lang=kotlin
 *
 * [1038] Binary Search Tree to Greater Sum Tree
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
class Solution {
    private var cnt = 0

    fun bstToGst(root: TreeNode?): TreeNode? {
        if (root == null) return null
        bstToGst(root?.right)
        val temp = root!!.`val`
        root!!.`val` += cnt
        cnt += temp
        bstToGst(root?.left)
        return root
    }
}

