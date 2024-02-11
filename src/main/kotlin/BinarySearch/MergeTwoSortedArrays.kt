package BinarySearch

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 */
object MergeTwoSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val totalSize = nums1.size + nums2.size

        val (small, big) = if (nums1.size < nums2.size) nums1 to nums2 else nums2 to nums1

        var left = 0
        var right = small.size

        while (left <= right) {
            val smallMid = (left + right) / 2
            val smallLeftMax = if (smallMid > 0) small[smallMid - 1] else Int.MIN_VALUE
            val smallRightMin = if (smallMid < small.size) small[smallMid] else Int.MAX_VALUE

            val bigMid = ((totalSize + 1) / 2) - smallMid
            val bigLeftMax = if (bigMid > 0) big[bigMid - 1] else Int.MIN_VALUE
            val bigRightMin = if (bigMid < big.size) big[bigMid] else Int.MAX_VALUE

            val leftMax = maxOf(smallLeftMax, bigLeftMax)
            val rightMin = minOf(smallRightMin, bigRightMin)

            if (leftMax <= rightMin) {
                return if (totalSize % 2 == 1) leftMax.toDouble() else {
                    (leftMax + rightMin) * 0.5
                }
            }

            if (smallLeftMax == leftMax) {
                right = smallMid - 1
            } else {
                left = smallMid + 1
            }
        }

        return -1.0
    }

    fun main() {
        print(findMedianSortedArrays(intArrayOf(1,3), intArrayOf(2)))
    }
}