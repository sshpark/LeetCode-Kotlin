/*
 * @lc app=leetcode id=19 lang=kotlin
 *
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (34.51%)
 * Likes:    2187
 * Dislikes: 161
 * Total Accepted:    459K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, remove the n-th node from the end of list and return
 * its head.
 * 
 * Example:
 * 
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * 
 * Note:
 * 
 * Given n will always be valid.
 * 
 * Follow up:
 * 
 * Could you do this in one pass?
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
    // 快慢指针 
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val temp: ListNode? = ListNode(0).apply { next = head }

        var fast = temp
        var slow = temp

        for (i in 0 .. n) fast = fast?.next

        while (fast != null) {
            fast = fast?.next
            slow = slow?.next    
        }
        slow?.next = slow?.next?.next
        return temp?.next
    }
}
// @lc code=end

