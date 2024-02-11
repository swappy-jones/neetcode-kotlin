package Stack

import java.util.*

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/1167545921/
 */
object ReversePolishNotation {

    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<String>()
        tokens.forEach {
            when (it) {
                "+" -> {
                    val a = stack.pop().toInt()
                    val b = stack.pop().toInt()
                    stack.add("${a+b}")
                }
                "-" -> {
                    val a = stack.pop().toInt()
                    val b = stack.pop().toInt()
                    stack.add("${b-a}")
                }
                "*" -> {
                    val a = stack.pop().toInt()
                    val b = stack.pop().toInt()
                    stack.add("${a*b}")
                }
                "/" -> {
                    val a = stack.pop().toInt()
                    val b = stack.pop().toInt()
                    stack.add("${b/a}")
                }
                else -> {
                    stack.add(it)
                }
            }
        }
        return stack.pop().toInt()
    }

    fun main() {
        evalRPN(arrayOf("4","13","5","/","+"))
    }
}