/*
 * @lc app=leetcode id=21 lang=kotlin
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (51.55%)
 * Likes:    3559
 * Dislikes: 529
 * Total Accepted:    890.9K
 * Total Submissions: 1.7M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
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
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var result: ListNode? = ListNode(0)
        var current = result
        
        var node1 = l1
        var node2 = l2
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                current?.next = node2
                break
            }
            if (node2 == null) {
                current?.next = node1
                break
            }

            if (node1?.`val` < node2?.`val`) {
                current?.next = node1
                node1 = node1?.next
            } else {
                current?.next = node2
                node2 = node2?.next
            }
            current = current?.next
        }
        return result?.next
    }
}
// @lc code=end

