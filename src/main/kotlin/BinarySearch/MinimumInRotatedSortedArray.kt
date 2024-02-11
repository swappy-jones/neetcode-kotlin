package BinarySearch

object MinimumInRotatedSortedArray {
    fun findMin(nums: IntArray): Int {
        var l =0
        var r = nums.size-1
        var min = nums[0]
        while(l<=r) {
            if(nums[l]<nums[r]) {
                return minOf(nums[l], min)
            }
            val m = (l+r)/2

            min = minOf(nums[m], min)

            if(nums[l] <= nums[m]) {
                l = m+1
            } else {
                r = m-1
            }
        }
        return min
    }

    fun main() {
        print(findMin(intArrayOf(8,9,2,3,4)))
    }
}