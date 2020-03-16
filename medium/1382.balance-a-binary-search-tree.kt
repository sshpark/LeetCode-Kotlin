/*
 * @lc app=leetcode id=1382 lang=kotlin
 *
 * [1382] Balance a Binary Search Tree
 *
 * https://leetcode.com/problems/balance-a-binary-search-tree/description/
 *
 * algorithms
 * Medium (73.89%)
 * Likes:    52
 * Dislikes: 9
 * Total Accepted:    5.2K
 * Total Submissions: 7K
 * Testcase Example:  '[1,null,2,null,3,null,4,null,null]'
 *
 * Given a binary search tree, return a balanced binary search tree with the
 * same node values.
 * 
 * A binary search tree is balanced if and only if the depth of the two
 * subtrees of every node never differ by more than 1.
 * 
 * If there is more than one answer, return any of them.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,null,2,null,3,null,4,null,null]
 * Output: [2,1,3,null,null,null,4]
 * Explanation: This is not the only correct answer, [3,1,4,null,2,null,null]
 * is also correct.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is between 1 and 10^4.
 * The tree nodes will have distinct values between 1 and 10^5.
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
class Solution {
    private var arr = IntArray(10005)
    private var cnt = 0

    fun balanceBST(root: TreeNode?): TreeNode? {
        cnt = 0
        var head = root
        dfs(head)
        return sortedArrayToBST(cnt)
    }

    fun dfs(root: TreeNode?) {
        if (root?.left != null) dfs(root?.left)
        arr[cnt++] = root!!.`val`
        if (root?.right != null) dfs(root?.right)
    }
    
    fun sortedArrayToBST(start: Int, end: Int): TreeNode? {
        if (start > end) return null
        val mid = start + (end - start) / 2
        var root: TreeNode? = TreeNode(arr[mid])
        root?.left = sortedArrayToBST(start, mid-1)
        root?.right = sortedArrayToBST(mid+1, end)
        return root
    }

    fun sortedArrayToBST(n: Int): TreeNode? {
        return sortedArrayToBST(0, n-1)
    }
}
// @lc code=end

