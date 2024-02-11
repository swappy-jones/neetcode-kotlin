package Stack

import java.util.*

/**
 * https://leetcode.com/problems/car-fleet/
 */
object CarFleet {

    /**
     * Logic behind the below solution is that we first sort the cars based on how far they are from the target in descending order
     * the car at any given position cannot pass the one that's ahead of it, essentially they will form a bunch of cars that will arrive
     * at the destination at the same time. Hence, we calculate the time that it will take for a car to reach the target.
     * If the time taken to reach the target for car n[i-1] is less than n[i], they will reach the destination together
     */
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val list = mutableListOf<Pair<Int, Int>>()
        val output = Stack<Float>()
        for(i in position.indices) {
            list.add(Pair(position[i], speed[i]))
        }
        list.sortByDescending { it.first }

        for(i in list.indices) {
            output.add((target-list[i].first)/list[i].second.toFloat())
            if(output.size > 1 && output[output.size-1] <= output[output.size-2]) {
                output.pop()
            }
        }
        return output.size
    }

    fun main() {
        carFleet(12, intArrayOf(10,8,0,5,3), intArrayOf(2,4,1,1,3))
    }
}