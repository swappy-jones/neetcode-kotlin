package TwoPointer

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
object RainWaterTrapping {

    // O(N) time and O(N) space
    fun trap(height: IntArray): Int {
        val maxLeftHeight = IntArray(height.size)
        val maxRightHeight = IntArray(height.size)
        for (i in 1 until height.size) {
            maxLeftHeight[i] = maxOf(height[i-1], maxLeftHeight[i-1])
        }
        for (i in (height.size-2) downTo  0) {
            maxRightHeight[i] = maxOf(height[i+1], maxRightHeight[i+1])
        }
        var sum =0
        for(i in height.indices) {
            val trappableUnit = minOf(maxLeftHeight[i], maxRightHeight[i]) - height[i]
            sum += maxOf(trappableUnit, 0)
        }
        return sum
    }

    fun main() {
        trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1))
    }
}