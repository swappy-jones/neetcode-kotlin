package ArraysAndHashing

object TwoPair {
    fun main() {
        val arr = mutableListOf(3,2,4).toIntArray()
        print(twoSum( arr, 6))
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, i ->
            val compliment = target - i;
            if(map.containsKey(compliment)) {
                return intArrayOf(index, map.getOrDefault(compliment, 0))
            }
            map[i] = index
        }
        return intArrayOf()
    }
}