package TwoPointer

/**
 * https://leetcode.com/problems/valid-palindrome/description/
 */
object ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        var i =0
        var j = s.length-1
        while(i < j) {
            while(i<j && !Character.isLetterOrDigit(s[i])) {
                i++
            }
            while(i<j && !Character.isLetterOrDigit(s[j])) {
                j--
            }
            if(s[i].lowercase() != s[j].lowercase()) {
                return false
            }
            i++
            j--
        }
        return true
    }

    fun main() {
        print(isPalindrome("race a car"))
    }
}