package BinarySearch

/**
 *  https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/1172026210/
 */
object SearchInRotatedSortedArray {
    /**
     * We first find the minimum element in the array, which will help break our array into two sorted halves. This enables us to apply binary search
     * in two separate lists
     */
    fun search(nums: IntArray, target: Int): Int {
        val pivot = findPivot(nums)
        val leftSearch = binarySearch(0,pivot, nums, target)
        return if(leftSearch == -1) {
            binarySearch(pivot,nums.size-1, nums, target)
        } else {
            leftSearch
        }
    }

    fun binarySearch(l: Int, r: Int, nums: IntArray, target: Int): Int {
        if(l<=r) {
            val m = (l+r)/2
            if(nums[m] == target) {
                return m
            }
            if(nums[m]< target) {
                return binarySearch(m+1, r, nums, target)
            }
            return  binarySearch(l, m-1, nums, target)
        }
        return -1
    }

    fun findPivot(nums: IntArray): Int {
        var l = 0
        var r = nums.size-1
        var min = nums[0]
        var minIndex = 0
        while(l<=r) {
            if(nums[l]<nums[r]) {
                if(min< nums[l]) {
                    return minIndex
                } else {
                    return l
                }
            }
            val m = (l+r)/2
            if (nums[m]<= min) {
                min = nums[m]
                minIndex = m
            }
            if(nums[l] <= nums[m]) {
                l = m+1
            } else {
                r = m-1
            }
        }
        return minIndex
    }
    fun main() {
        search(intArrayOf(4,5,6,7,0,1,2), 0)
    }
}