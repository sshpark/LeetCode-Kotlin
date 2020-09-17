import java.util.*
import kotlin.math.abs

//You are given an array points representing integer coordinates of some points
//on a 2D-plane, where points[i] = [xi, yi]. 
//
// The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan dist
//ance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value
// of val. 
//
// Return the minimum cost to make all points connected. All points are connecte
//d if there is exactly one simple path between any two points. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
//Output: 20
//Explanation:
//
//We can connect the points as shown above to get the minimum cost of 20.
//Notice that there is a unique path between every pair of points.
// 
//
// Example 2: 
//
// 
//Input: points = [[3,12],[-2,5],[-4,1]]
//Output: 18
// 
//
// Example 3: 
//
// 
//Input: points = [[0,0],[1,1],[1,0],[-1,1]]
//Output: 4
// 
//
// Example 4: 
//
// 
//Input: points = [[-1000000,-1000000],[1000000,1000000]]
//Output: 4000000
// 
//
// Example 5: 
//
// 
//Input: points = [[0,0]]
//Output: 0
// 
//
// 
// Constraints:  
//
// 
// 1 <= points.length <= 1000 
// -106 <= xi, yi <= 106 
// All pairs (xi, yi) are distinct. 
// 
// Related Topics Union Find 
// 👍 199 👎 20


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    data class Node(var u: Int, var v: Int, var w: Int)

    companion object {
        val p = IntArray(1005)

        fun find(x: Int): Int {
            if (x != p[x]) p[x] = find(p[x])
            return p[x]
        }

    }

    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val n = points.size
        val q = PriorityQueue<Node> { x, y -> x.w - y.w }
        for (i in 0 until n) {
            for (j in i+1 until n) {
                q.add(Node(i, j, Math.abs(points[i][0]-points[j][0]) +Math.abs(points[i][1]-points[j][1])))
            }
        }
        for (i in 0 until n) p[i] = i
        var res = 0

        while(!q.isEmpty()) {
            val (x, y, w) = q.poll()
            val u = find(x)
            val v = find(y)
            if (u != v) {
                res += w
                p[u] = v
            }
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)
