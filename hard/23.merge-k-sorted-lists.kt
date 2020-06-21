/*
 * @lc app=leetcode id=23 lang=kotlin
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (39.49%)
 * Likes:    4576
 * Dislikes: 284
 * Total Accepted:    634.6K
 * Total Submissions: 1.6M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * 
 * 
 */

// @lc code=start
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val queue = PriorityQueue<ListNode>() { a, b -> a.`val`-b.`val` }
        for (list in lists) {
            if (list != null) {
                queue.add(list)
            }
        }

        var head: ListNode? = null
        var last: ListNode? = null
        while (queue.isNotEmpty()) {
            val top = queue.peek()
            queue.remove()
            if(top?.next != null) {
                queue.add(top.next)
            }
            if (head == null) {
                head = top
                last = top
            } else {
                last?.next = top
                last = top
            }
        }
        return head
    }
}
// @lc code=end

