/*
 * @lc app=leetcode id=999 lang=kotlin
 *
 * [999] Available Captures for Rook
 *
 * https://leetcode.com/problems/available-captures-for-rook/description/
 *
 * algorithms
 * Easy (65.97%)
 * Likes:    100
 * Dislikes: 255
 * Total Accepted:    17.2K
 * Total Submissions: 26.1K
 * Testcase Example:  '[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]'
 *
 * On an 8 x 8 chessboard, there is one white rook.  There also may be empty
 * squares, white bishops, and black pawns.  These are given as characters 'R',
 * '.', 'B', and 'p' respectively. Uppercase characters represent white pieces,
 * and lowercase characters represent black pieces.
 * 
 * The rook moves as in the rules of Chess: it chooses one of four cardinal
 * directions (north, east, west, and south), then moves in that direction
 * until it chooses to stop, reaches the edge of the board, or captures an
 * opposite colored pawn by moving to the same square it occupies.  Also, rooks
 * cannot move into the same square as other friendly bishops.
 * 
 * Return the number of pawns the rook can capture in one move.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input:
 * [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation: 
 * In this example the rook is able to capture all the pawns.
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input:
 * [[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 0
 * Explanation: 
 * Bishops are blocking the rook to capture any pawn.
 * 
 * 
 * Example 3:
 * 
 * 
 * 
 * 
 * Input:
 * [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation: 
 * The rook can capture the pawns at positions b5, d6 and f5.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * board.length == board[i].length == 8
 * board[i][j] is either 'R', '.', 'B', or 'p'
 * There is exactly one cell with board[i][j] == 'R'
 * 
 * 
 */
class Solution {
    fun numRookCaptures(board: Array<CharArray>): Int {
        var ans = 0
        var (sx, sy) = Pair(0, 0)

        loop@ for (i in 0 until 8) {
            for (j in 0 until 8 ) {
                if (board[i][j] == 'R') {
                    sx = i
                    sy = j
                    break@loop
                }
            }
        }
        var (tx, ty) = Pair(sx, sy)
        while (true) {
            if (board[tx][ty] == 'p') {
                ans++
                break
            }
            if (board[tx][ty] == 'B') break
            tx--
            if (tx < 0) break
        }
        tx = sx
        ty = sy
        while (true) {
            if (board[tx][ty] == 'p') {
                ans++
                break
            }
            if (board[tx][ty] == 'B') break
            ty++
            if (ty >= 8) break
        }
        tx = sx
        ty = sy
        while (true) {
            if (board[tx][ty] == 'p') {
                ans++
                break
            }
            if (board[tx][ty] == 'B') break
            tx++
            if (tx >= 8) break
        }
        tx = sx
        ty = sy
        while (true) {
            if (board[tx][ty] == 'p') {
                ans++
                break
            }
            if (board[tx][ty] == 'B') break
            ty--
            if (ty < 0) break
        }
        return ans
    }
}

