package TwoPointer

object ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size-1
        var max = 0
        while(left<right) {
            max = maxOf(minOf(height[left], height[right]) * (right-left), max)
            if(height[left] > height[right]) {
                right--
            } else {
                left++
            }
        }
        return max
    }

    fun main() {
        maxArea(intArrayOf(1,8,6,2,5,4,8,3,7))
    }
}