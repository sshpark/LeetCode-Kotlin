/*
 * @lc app=leetcode id=24 lang=kotlin
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (45.94%)
 * Likes:    1438
 * Dislikes: 128
 * Total Accepted:    363.8K
 * Total Submissions: 779.5K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
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
    fun swapPairs(head: ListNode?): ListNode? {
        var G: ListNode? = ListNode(0)
        G?.next = head
        var p = G
        var head = head

        while (head != null && head.next != null) {
            var temp = head?.next
            head?.next = temp.next
            temp?.next = head
            p?.next = temp
            p = head
            head = head?.next
        }
        return G?.next
    }
}
// @lc code=end

