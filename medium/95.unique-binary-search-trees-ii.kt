/*
 * @lc app=leetcode id=95 lang=kotlin
 *
 * [95] Unique Binary Search Trees II
 *
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 *
 * algorithms
 * Medium (36.68%)
 * Likes:    1406
 * Dislikes: 120
 * Total Accepted:    149.2K
 * Total Submissions: 406.6K
 * Testcase Example:  '3'
 *
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
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
class Solution {
    fun generateTrees(n: Int): List<TreeNode?> {
        if (n == 0) return mutableListOf<TreeNode?>()
        return dfs(1, n)
    }

    private fun dfs(l: Int, r: Int): List<TreeNode?> {
        if (l > r) {
            return mutableListOf<TreeNode?>(null)
        }
        var res =  mutableListOf<TreeNode?>()
        for (root in l .. r) {
            var left = dfs(l, root-1)
            var right = dfs(root+1, r)

            for (x in left)
                for (y in right) {
                    var temp = TreeNode(root)
                    temp.left = x
                    temp.right = y
                    res.add(temp)
                }
        }
        return res
    }
}

