/*
 * @lc app=leetcode id=127 lang=kotlin
 *
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (25.13%)
 * Likes:    1763
 * Dislikes: 883
 * Total Accepted:    292.7K
 * Total Submissions: 1.2M
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * Note:
 * 
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * 
 * 
 * 
 * 
 */
import java.util.LinkedList

class Solution {
    data class Node(
        var str: String = "",
        var step: Int = 0
    )
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        var q = LinkedList<Node>()
        var vis = mutableMapOf<String, Boolean>()

        q.offer(Node(beginWord, 1))
        vis[beginWord] = true

        while (!q.isEmpty()) {
            val top = q.poll()

            if (top.str == endWord) {
                return top.step
            }

            for (i in wordList) {
                if (vis[i] ?: false) continue
                var cnt = 0
                for (j in 0 until beginWord.length)
                    if (top.str[j] != i[j]) cnt++
                if (cnt <= 1) {
                    vis[i] = true
                    q.offer(Node(i, top.step+1))
                }
            }
        }
        return 0
    }
}

