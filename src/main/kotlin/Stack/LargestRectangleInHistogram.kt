package Stack

import java.util.*

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
object LargestRectangleInHistogram {

    /**
     * We keep adding all the heights to the stack if they are in increasing order, once we are at a height which is smaller than the height at the top of stack,
     * we start popping the stack and calculating max based on the height and index, which essentially means that we iterate the stack from top, and the distance
     * travelled from the start of pop is the width and since we already have the height, we get the sum. after we iterate through the array once, the elements
     * left in the stack have a start point allocated which is the index where the elements were last popped to.
     */
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = Stack<Pair<Int, Int>>()
        var max = 0
        for(i in heights.indices) {
            var start = i
            while(stack.isNotEmpty() && heights[i] < stack.peek().second) {
                val item = stack.pop()
                max = maxOf(max, item.second*(i-item.first))
                start = item.first
            }
            stack.add(Pair(start, heights[i]))
        }

        stack.forEach {
            max = maxOf(max, it.second*(heights.size-it.first))
        }
        return max
    }

    fun main() {
        print(largestRectangleArea(intArrayOf(2,1,2)))
    }
}