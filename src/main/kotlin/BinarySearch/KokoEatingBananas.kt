package BinarySearch

import kotlin.math.ceil

/**
 *  https://leetcode.com/problems/koko-eating-bananas/description/
 */
object KokoEatingBananas {
    /**
     * The logic of the solution is that the speed by which the monkey can eat will lie between 1 and the max number in the array. We calculate the time taken
     * to eat and compare it with the last smaller value. The end result is the smallest time that it took to eat hence the slowest speed at which it eats
     */
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var max = 0
        piles.forEach {
            if(it > max)
                max = it
        }
        var l = 1
        var r = max
        var timeTaken = r
        while(l<=r) {
            val m = l+(r-l)/2
            val hours = computeSpeed(piles, m)
            if(hours<=h) {
                timeTaken = minOf(timeTaken, m)
                r = m-1
            } else {
                l = m+1
            }
        }
        return timeTaken
    }

    fun computeSpeed(piles: IntArray, speed: Int): Long {
        var timeTaken = 0L
        piles.forEach {
            timeTaken += ceil(it/(speed*1.0)).toLong()
        }
        return timeTaken
    }

    

    fun main() {
        minEatingSpeed(intArrayOf(805306368,805306368,805306368), 1000000000)
    }
}