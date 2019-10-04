/*
 * @lc app=leetcode id=621 lang=kotlin
 *
 * [621] Task Scheduler
 *
 * https://leetcode.com/problems/task-scheduler/description/
 *
 * algorithms
 * Medium (46.10%)
 * Likes:    1983
 * Dislikes: 361
 * Total Accepted:    106.9K
 * Total Submissions: 229.9K
 * Testcase Example:  '["A","A","A","B","B","B"]\n2'
 *
 * Given a char array representing tasks CPU need to do. It contains capital
 * letters A to Z where different letters represent different tasks. Tasks
 * could be done without original order. Each task could be done in one
 * interval. For each interval, CPU could finish one task or just be idle.
 * 
 * However, there is a non-negative cooling interval n that means between two
 * same tasks, there must be at least n intervals that CPU are doing different
 * tasks or just be idle.
 * 
 * You need to return the least number of intervals the CPU will take to finish
 * all the given tasks.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 * 
 * 
 */

// @lc code=start
class Solution {

    /**
    * mx-1是可以分为的块数，n+1是每块中的个数，
    * 后面的 25-x 是还需要补全的个数
    */
    fun leastInterval(tasks: CharArray, n: Int): Int {
        var cnt = IntArray(26)

        for (i in tasks) cnt[i-'A']++
        cnt.sort()
        var x = 25
        var mx = cnt[25]
        while (x >= 0 && cnt[x] == mx) x--
        return Math.max(tasks.size, (mx-1)*(n+1)+25-x)
    }
}
// @lc code=end

