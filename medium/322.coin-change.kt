/*
 * @lc app=leetcode id=322 lang=kotlin
 *
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (31.48%)
 * Likes:    2116
 * Dislikes: 82
 * Total Accepted:    231.4K
 * Total Submissions: 733K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1:
 * 
 * 
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3 
 * Explanation: 11 = 5 + 5 + 1
 * 
 * Example 2:
 * 
 * 
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * 
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * 
 */

import java.util.LinkedList

class Solution {
    data class Node(
        var num: Int = 0,
        var step: Int = 0
    )

    fun coinChange(coins: IntArray, amount: Int): Int {
        val n = coins.size
        var dp = BooleanArray(amount+1)
        dp[0] = true
        for (i in 0 until n) {
            for (j in 0 .. amount) {
                if (j <= amount-coins[i]) {
                    if (dp[j]) {
                        dp[j+coins[i]] = true
                    }
                }
            }
        }
        if (dp[amount]) {
            var q =  LinkedList<Node>()
            var vis = BooleanArray(amount+1)
            q.offer(Node(0, 0))
            vis[0] = true

            while (!q.isEmpty()) {
                val top = q.poll()
                if (top.num == amount)
                    return top.step

                for (i in 0 until n) {
                    if (top.num <= amount-coins[i] && !vis[top.num+coins[i]]) {
                        q.offer(Node(top.num+coins[i], top.step+1))
                        vis[top.num+coins[i]] = true
                    }
                }
            }
            return -1
        } else {
            return -1;
        }
    }
}

