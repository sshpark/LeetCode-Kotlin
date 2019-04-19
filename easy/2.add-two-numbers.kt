/*
 * @lc app=leetcode id=2 lang=kotlin
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (30.92%)
 * Total Accepted:    831.4K
 * Total Submissions: 2.7M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * 
 */
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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val head = ListNode(0)
        var p = l1
        var q = l2
        var cur = head
        var cnt = 0

        while (q != null || p != null) {
            val x = p?.`val` ?: 0
            val y = q?.`val` ?: 0

            val temp = x+y+cnt
            cnt = temp/10
            cur.next = ListNode(temp%10)
            cur = cur.next
            if (p != null) p = p?.next
            if (q != null) q = q?.next
        }
        if (cnt > 0) {
            cur.next = ListNode(cnt)
        }
        return head.next
    }
}

