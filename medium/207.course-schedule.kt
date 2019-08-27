/*
 * @lc app=leetcode id=207 lang=kotlin
 *
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (38.86%)
 * Likes:    2103
 * Dislikes: 98
 * Total Accepted:    247.1K
 * Total Submissions: 634.4K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * Example 1:
 * 
 * 
 * Input: 2, [[1,0]] 
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * Example 2:
 * 
 * 
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should
 * also have finished course 1. So it is impossible.
 * 
 * 
 * Note:
 * 
 * 
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input
 * prerequisites.
 * 
 * 
 */
class Solution {
    // 拓扑排序
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        var q = IntArray(numCourses+1)
        var edges = Array<MutableList<Int>>(numCourses+1) {mutableListOf<Int>()}
            

        var ind = IntArray(numCourses+1)

        var head = 0
        var tail = 0
        
        for (i in prerequisites) {
            ind[i[1]]++
            edges[i[0]].add(i[1])
        }
        var cnt = 0

        for (i in 0 until numCourses)
            if (ind[i] == 0) {
                q[tail++] = i
                cnt++
            }
                
        while (head < tail) {
            var top = q[head]
            
            for (i in edges[top]) {
                ind[i]--
                if (ind[i] == 0) {
                    cnt++    
                    q[tail++] = i
                }
            }
            head++
        }
        return cnt == numCourses
    }
}

