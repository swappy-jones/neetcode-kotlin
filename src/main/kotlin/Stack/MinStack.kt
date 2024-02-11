package Stack

/**
 * https://leetcode.com/problems/min-stack/
 */

class MinStack() {
    val array = mutableListOf<Int>()
    val stack = mutableListOf<Int>()
    fun push(num: Int) {
        stack.add(num)
        if(array.isEmpty()) {
            array.add(num)
        } else {
            array.add(
                minOf(num, array.last())
            )
        }
    }

    fun pop() {
        array.removeLast()
        stack.removeLast()
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return array.last()
    }

}