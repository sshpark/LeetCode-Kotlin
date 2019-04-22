/*
 * @lc app=leetcode id=94 lang=kotlin
 *
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (55.96%)
 * Total Accepted:    439.9K
 * Total Submissions: 785.6K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,3,2]
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
class Solution {
    private val res = mutableListOf<Int>()
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) 
            return res

        if (root.left != null) {
            inorderTraversal(root.left)
        }
        res.add(root.`val`)
        
        if (root.right != null) {
            inorderTraversal(root.right)
        }
        return res
    }
}

