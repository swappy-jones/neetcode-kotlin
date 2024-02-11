package TwoPointer

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/1166578207/
 */
object TwoSumInputArraySorted {

    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var start = 0
        var end = numbers.size -1
        while(start<end) {
            val sum = numbers[start]+numbers[end]
            if(sum == target) {
                return intArrayOf(start+1, end+1)
            } else if(sum> target) {
                end--
            } else {
                start++
            }
        }
        return intArrayOf()
    }

    fun main() {
        print(twoSum(intArrayOf(2,7,11,15), 9))
    }
}