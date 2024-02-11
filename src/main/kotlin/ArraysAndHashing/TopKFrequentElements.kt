package ArraysAndHashing

/**
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 */
object TopKFrequentElements {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        val invertedMap = hashMapOf<Int, MutableList<Int>>()
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) +1
        }
        val output = mutableListOf<Int>()
        val result = mutableListOf<Int>()
        map.forEach {
            if(invertedMap.containsKey(it.value)) {
                val list = invertedMap[it.value]!!
                list.add(it.key)
                invertedMap[it.value] = list
            } else {
                invertedMap[it.value] = mutableListOf(it.key)
            }
        }
        invertedMap.forEach {mapEntry ->
            mapEntry.value.forEach{
                output.add(it)
            }
        }

        return output.reversed().take(k).toIntArray()
    }

    fun main() {
        print(topKFrequent(intArrayOf(1,1,1,2,2,3), 2))
    }
}