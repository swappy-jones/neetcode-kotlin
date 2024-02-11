package Stack

/**
 * https://leetcode.com/problems/generate-parentheses/submissions/1167578958/
 */
object GenerateParenthesis {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        backTrack(n, 0,0, "", result)
        return result
    }

    fun backTrack(n: Int, open: Int, closed: Int, current: String, result: MutableList<String>) {
        if(open == n && closed == n) {
            result.add(current)
        }
        if(open< n) {
            backTrack(n, open+1, closed, "$current(", result)
        }
        if(open>closed) {
            backTrack(n, open, closed+1, "$current)", result)
        }
    }

    fun main() {
        generateParenthesis(3)
    }
}