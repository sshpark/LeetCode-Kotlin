/*
 * @lc app=leetcode id=1473 lang=kotlin
 *
 * [1473] Paint House III
 *
 * https://leetcode.com/problems/paint-house-iii/description/
 *
 * algorithms
 * Hard (42.66%)
 * Likes:    157
 * Dislikes: 6
 * Total Accepted:    3.8K
 * Total Submissions: 8.5K
 * Testcase Example:  '[0,0,0,0,0]\n[[1,10],[10,1],[10,1],[1,10],[5,1]]\n5\n2\n3'
 *
 * There is a row of m houses in a small city, each house must be painted with
 * one of the n colors (labeled from 1 to n), some houses that has been painted
 * last summer should not be painted again.
 * 
 * A neighborhood is a maximal group of continuous houses that are painted with
 * the same color. (For example: houses = [1,2,2,3,3,2,1,1] contains 5
 * neighborhoods  [{1}, {2,2}, {3,3}, {2}, {1,1}]).
 * 
 * Given an array houses, an m * n matrix cost and an integer target
 * where:
 * 
 * 
 * houses[i]: is the color of the house i, 0 if the house is not painted
 * yet.
 * cost[i][j]: is the cost of paint the house i with the color j+1.
 * 
 * 
 * Return the minimum cost of painting all the remaining houses in such a way
 * that there are exactly target neighborhoods, if not possible return -1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m =
 * 5, n = 2, target = 3
 * Output: 9
 * Explanation: Paint houses of this way [1,2,2,1,1]
 * This array contains target = 3 neighborhoods, [{1}, {2,2}, {1,1}].
 * Cost of paint all houses (1 + 1 + 1 + 1 + 5) = 9.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m =
 * 5, n = 2, target = 3
 * Output: 11
 * Explanation: Some houses are already painted, Paint the houses of this way
 * [2,2,1,2,2]
 * This array contains target = 3 neighborhoods, [{2,2}, {1}, {2,2}]. 
 * Cost of paint the first and last house (10 + 1) = 11.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: houses = [0,0,0,0,0], cost = [[1,10],[10,1],[1,10],[10,1],[1,10]], m
 * = 5, n = 2, target = 5
 * Output: 5
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: houses = [3,1,2,3], cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]], m = 4,
 * n = 3, target = 3
 * Output: -1
 * Explanation: Houses are already painted with a total of 4 neighborhoods
 * [{3},{1},{2},{3}] different of target = 3.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == houses.length == cost.length
 * n == cost[i].length
 * 1 <= m <= 100
 * 1 <= n <= 20
 * 1 <= target <= m
 * 0 <= houses[i] <= n
 * 1 <= cost[i][j] <= 10^4
 * 
 */

// @lc code=start
class Solution {
    fun minCost(houses: IntArray, cost: Array<IntArray>, m: Int, n: Int, target: Int): Int {
        val dp = Array<Array<Array<Int>>>(m){Array<Array<Int>>(n+1){Array<Int>(target+1) { Int.MAX_VALUE }}}
        if (houses[0] == 0) {
            for (i in 1 .. n) dp[0][i][0] = cost[0][i-1]
        } else {
            dp[0][houses[0]][0] = 0
        }

        for (i in 1 until m) {
            for (j in 1 .. n) {
                for (k in 0 until target) {
                    if (houses[i] == 0) {
                        for (j_old in 1 .. n) {
                            if (dp[i-1][j_old][k] == Int.MAX_VALUE) continue

                            if (j_old == j) {
                                dp[i][j][k] = Math.min(dp[i - 1][j_old][k] + cost[i][j - 1], dp[i][j][k])
                            } else {
                                dp[i][j][k + 1] = Math.min(dp[i - 1][j_old][k] + cost[i][j - 1], dp[i][j][k + 1])
                            }
                        }
                    } else {
                        if (dp[i - 1][j][k] == Int.MAX_VALUE) continue
                        
                        if (houses[i] == j) {
                            dp[i][j][k] = Math.min(dp[i - 1][j][k], dp[i][j][k])
                        } else {
                            dp[i][houses[i]][k + 1] = Math.min(dp[i - 1][j][k], dp[i][houses[i]][k + 1])
                        }
                    }
                }
            }
        }
        var ans = Int.MAX_VALUE
        for (j in 1 .. n) {
            ans = Math.min(ans, dp[m - 1][j][target - 1])
        }
        return if (ans == Int.MAX_VALUE) -1 else ans;
    }
}
// @lc code=end

