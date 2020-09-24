//Given two strings s and t, you want to transform string s into string t using 
//the following operation any number of times: 
//
// 
// Choose a non-empty substring in s and sort it in-place so the characters are 
//in ascending order. 
// 
//
// For example, applying the operation on the underlined substring in "14234" re
//sults in "12344". 
//
// Return true if it is possible to transform string s into string t. Otherwise,
// return false. 
//
// A substring is a contiguous sequence of characters within a string. 
//
// 
// Example 1: 
//
// 
//Input: s = "84532", t = "34852"
//Output: true
//Explanation: You can transform s into t using the following sort operations:
//"84532" (from index 2 to 3) -> "84352"
//"84352" (from index 0 to 2) -> "34852"
// 
//
// Example 2: 
//
// 
//Input: s = "34521", t = "23415"
//Output: true
//Explanation: You can transform s into t using the following sort operations:
//"34521" -> "23451"
//"23451" -> "23415"
// 
//
// Example 3: 
//
// 
//Input: s = "12345", t = "12435"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: s = "1", t = "2"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// s.length == t.length 
// 1 <= s.length <= 105 
// s and t only contain digits from '0' to '9'. 
// 
// Related Topics String Greedy 
// 👍 157 👎 3


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun isTransformable(s: String, t: String): Boolean {
        val idx = Array<MutableList<Int>>(10) { mutableListOf() }
        val pos = IntArray(10)

        for ((index, value) in s.withIndex()) {
            idx[value-'0'].add(index)
        }

        for ((index, value) in t.withIndex()) {
            val d = value-'0'
            if (pos[d] >= idx[d].size) return false
            for (j in 0 until d) {
                if (pos[j] < idx[j].size && idx[j][pos[j]] < idx[d][pos[d]]) return false
            }
            pos[d]++
        }
        return true
    }
}
//leetcode submit region end(Prohibit modification and deletion)
