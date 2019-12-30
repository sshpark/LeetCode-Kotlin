/*
 * @lc app=leetcode.cn id=1305 lang=kotlin
 *
 * [1305] 两棵二叉搜索树中的所有元素
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
class Solution {
    private val res: MutableList<Int> = mutableListOf()

    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        dfs(root1)
        dfs(root2)
        return res.sorted()
    }

    private fun dfs(root: TreeNode?) {
        if (root == null) return
        if (root?.left != null) dfs(root?.left);
        if (root?.right != null) dfs(root?.right);
        res.add(root!!.`val`)
    }
}
// @lc code=end

