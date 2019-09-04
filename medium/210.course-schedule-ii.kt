/*
 * @lc app=leetcode id=210 lang=kotlin
 *
 * [210] Course Schedule II
 *
 * https://leetcode.com/problems/course-schedule-ii/description/
 *
 * algorithms
 * Medium (35.89%)
 * Likes:    1175
 * Dislikes: 82
 * Total Accepted:    169K
 * Total Submissions: 468.5K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them.
 * If it is impossible to finish all courses, return an empty array.
 * 
 * Example 1:
 * 
 * 
 * Input: 2, [[1,0]] 
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you
 * should have finished   
 * course 0. So the correct course order is [0,1] .
 * 
 * Example 2:
 * 
 * 
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you
 * should have finished both     
 * ⁠            courses 1 and 2. Both courses 1 and 2 should be taken after you
 * finished course 0. 
 * So one correct course order is [0,1,2,3]. Another correct ordering is
 * [0,2,1,3] .
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
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        var q = IntArray(numCourses+1)
        var edges = Array<MutableList<Int>>(numCourses+1) {mutableListOf<Int>()}
            

        var ind = IntArray(numCourses+1)

        var head = 0
        var tail = 0
        
        for (i in prerequisites) {
            ind[i[0]]++
            edges[i[1]].add(i[0])
        }
        var cnt = 0
        var ans = IntArray(numCourses)
        var res = 0

        for (i in 0 until numCourses)
            if (ind[i] == 0) {
                ans[res++] = i
                q[tail++] = i
                cnt++
            }
                
        while (head < tail) {
            var top = q[head]
            
            for (i in edges[top]) {
                ind[i]--
                if (ind[i] == 0) {
                    ans[res++] = i
                    cnt++    
                    q[tail++] = i
                }
            }
            head++
        }
        if (cnt == numCourses) return ans
        return intArrayOf()
    }
}

