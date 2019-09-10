/*
 * @lc app=leetcode id=310 lang=kotlin
 *
 * [310] Minimum Height Trees
 *
 * https://leetcode.com/problems/minimum-height-trees/description/
 *
 * algorithms
 * Medium (30.65%)
 * Likes:    1167
 * Dislikes: 71
 * Total Accepted:    71.9K
 * Total Submissions: 233.7K
 * Testcase Example:  '4\n[[1,0],[1,2],[1,3]]'
 *
 * For an undirected graph with tree characteristics, we can choose any node as
 * the root. The result graph is then a rooted tree. Among all possible rooted
 * trees, those with minimum height are called minimum height trees (MHTs).
 * Given such a graph, write a function to find all the MHTs and return a list
 * of their root labels.
 * 
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be
 * given the number n and a list of undirected edges (each edge is a pair of
 * labels).
 * 
 * You can assume that no duplicate edges will appear in edges. Since all edges
 * are undirected, [0, 1] is the same as [1, 0] and thus will not appear
 * together in edges.
 * 
 * Example 1 :
 * 
 * 
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * 
 * ⁠       0
 * ⁠       |
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3 
 * 
 * Output: [1]
 * 
 * 
 * Example 2 :
 * 
 * 
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * 
 * ⁠    0  1  2
 * ⁠     \ | /
 * ⁠       3
 * ⁠       |
 * ⁠       4
 * ⁠       |
 * ⁠       5 
 * 
 * Output: [3, 4]
 * 
 * Note:
 * 
 * 
 * According to the definition of tree on Wikipedia: “a tree is an undirected
 * graph in which any two vertices are connected by exactly one path. In other
 * words, any connected graph without simple cycles is a tree.”
 * The height of a rooted tree is the number of edges on the longest downward
 * path between the root and a leaf.
 * 
 * 
 */

import java.util.LinkedList
/*
 * 拓扑排序，每次删除度为 1 的点，最后剩下 1 或者 2 个点就是答案
 */ 
class Solution {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (n == 1) return listOf(0)
        var q = LinkedList<Int>()
        var e = Array<MutableList<Int>>(n+1) { mutableListOf<Int>() }
        var vis = BooleanArray(n+1)
        var ind = IntArray(n+1)

        for (edge in edges) {
            ind[edge[0]]++
            ind[edge[1]]++
            e[edge[0]].add(edge[1])
            e[edge[1]].add(edge[0])
        }
        var cnt = n

        for (i in 0 until n) {
            if (ind[i] == 1) {
                vis[i] = true
                q.offer(i)
            }
        }

        while (cnt > 2) {
            val sz = q.size
            cnt -= sz

            for (i in 0 until sz) {
                val top = q.poll()

                for (j in e[top]) {
                    if (!vis[j]) {
                        ind[j]--
                        if (ind[j] == 1) q.offer(j)
                    }
                }
            }
        }
        return q.toList()
    }
}

