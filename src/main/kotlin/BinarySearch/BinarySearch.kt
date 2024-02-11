package BinarySearch

/**
 * https://leetcode.com/problems/binary-search/
 */
object BinarySearch {
    fun search(nums: IntArray, target: Int): Int {
        return searchRecurssively(nums, target, 0, nums.size-1)
    }

    fun searchRecurssively(nums: IntArray, target: Int, l: Int, r: Int): Int {
        if(r>=l) {
            val m = l + (r - l) / 2
            if(nums[m] == target) {
                return m
            }
            if(nums[m]< target) {
                return searchRecurssively(nums, target, m+1, r)
            }
            return searchRecurssively(nums, target, l, m-1)
        }
        return -1
    }

    fun main() {
        print(search(intArrayOf(-1,0,3,5,9,12), 9))
    }
}