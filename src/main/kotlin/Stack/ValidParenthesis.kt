package Stack

import java.util.Stack

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 */
object ValidParenthesis {

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        s.forEach {
            if(it == '(' || it == '{' || it == '[') {
                stack.push(it)
            } else {
                if(stack.isNotEmpty() && (stack.peek() == '(' && it == ')' ||
                    stack.peek() == '{' && it == '}' ||
                    stack.peek() == '[' && it == ']')) {
                    stack.pop()
                } else {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }

    fun main() {
        print(isValid("]"))
    }
}