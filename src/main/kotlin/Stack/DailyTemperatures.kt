package Stack

import java.util.*

/**
 * https://leetcode.com/problems/daily-temperatures/description/
 */
object DailyTemperatures {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = Stack<Pair<Int, Int>>()
        val result = IntArray(temperatures.size)
        temperatures.forEachIndexed { index, num ->
            if(stack.empty()) {
                stack.add(Pair(num, index))
            } else {
                while (stack.isNotEmpty() && num > stack.peek().first) {
                    val item = stack.pop()
                    result[item.second] =  index - item.second
                }
                stack.add(Pair(num, index))
            }
        }
        return result
    }

    fun main() {
        dailyTemperatures(intArrayOf(73,74,75,71,69,72,76,73))
    }
}