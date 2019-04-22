`/*
 * @lc app=leetcode id=96 lang=kotlin
 *
 * [96] Unique Binary Search Trees
 *
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 *
 * algorithms
 * Medium (45.70%)
 * Total Accepted:    193.2K
 * Total Submissions: 422.5K
 * Testcase Example:  '3'
 *
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1 ... n?
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
 * 
 * 
 */
class Solution {
    // catalan数：h(n) = h(n-1)*(4*n-2)/(n+1)
    fun numTrees(n: Int): Int {
        var x: Long = 1
        var res: Long = 1
        
        for (i in 1..n) {
            res = x*(4*i-2)/(i+1)
            x = res
        }
        return res.toInt()
    }
}

