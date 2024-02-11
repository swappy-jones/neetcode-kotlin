package ArraysAndHashing

/**
 * https://leetcode.com/problems/product-of-array-except-self/description/
 */
object ProductOfArrayExceptSelf {

    fun productExceptSelf(nums: IntArray): IntArray {
        var containsZero = false
        var product = 1
        var zeroCount = 0
        nums.forEach {
            if(it != 0) {
                product *= it
            } else {
                ++zeroCount
                containsZero = true
            }
        }
        if(zeroCount>1) {
            product = 0
        }
        val output = mutableListOf<Int>()
        if(containsZero) {
            nums.forEach {
                if(it == 0) {
                    output.add(product)
                } else {
                    output.add(0)
                }
            }
        } else {
            nums.forEach {
                output.add(product/it)
            }
        }
        return output.toIntArray()
    }

    fun main() {
        productExceptSelf(intArrayOf(-1,1,0,-3,3))
    }
}