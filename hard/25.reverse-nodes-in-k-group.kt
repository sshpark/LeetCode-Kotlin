/*
 * @lc app=leetcode id=25 lang=kotlin
 *
 * [25] Reverse Nodes in k-Group
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (41.26%)
 * Likes:    2105
 * Dislikes: 357
 * Total Accepted:    263.1K
 * Total Submissions: 637.5K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the
 * linked list. If the number of nodes is not a multiple of k then left-out
 * nodes in the end should remain as it is.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * 
 * 
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be
 * changed.
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
/**
-1->1->2->3->4->5
 |        |  |
pre      cur next

-1->3->2->1->4->5
    |     |  |
   cur   pre next
 */
class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val dummy: ListNode? = ListNode(-1)
        dummy?.next = head
        var pre = dummy
        var cur = pre?.next
        
        var num = 0
        while (cur != null) {
            ++num
            cur = cur?.next
        }

        while (num >= k) {
            cur = pre?.next
            for (i in 1 until k) {
                val t = cur?.next
                cur?.next = t?.next
                t?.next = pre?.next
                pre?.next = t
            }
            pre = cur
            num -= k
        }
        return dummy?.next
    }
}
// @lc code=end

