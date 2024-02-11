package ArraysAndHashing

/**
 * https://leetcode.com/problems/valid-sudoku/solutions/15472/short-simple-java-using-strings/
 */
object ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val set = hashSetOf<String>()
        for(i in board.indices) {
            for(j in board[i].indices) {
                val cell = "(${board[i][j]})"
                if(board[i][j] != '.') {
                    if(!set.add("Row $i = $cell") ||
                        !set.add("Column $j = $cell") ||
                        !set.add("Block ${i/3}+${j/3}= $cell")) {
                        return false
                    }
                }
            }
        }
        return true
    }
    fun main() {
        isValidSudoku(arrayOf(charArrayOf()))
    }
}