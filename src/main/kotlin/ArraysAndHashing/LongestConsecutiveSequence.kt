package ArraysAndHashing

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
object LongestConsecutiveSequence {

    fun longestConsecutive(nums: IntArray): Int {
        val set = hashSetOf<Int>()
        for(i in nums.indices) {
            set.add(nums[i])
        }
        var longest = 0
        for(n in set) {
            if(set.contains(n-1).not()) {
                var start = n
                var sequenceLength = 1
                while(set.contains(++start)) {
                    sequenceLength++
                }
                if(sequenceLength> longest) {
                    longest = sequenceLength
                }
            }
        }
        return longest
    }

    fun main() {
        longestConsecutive(intArrayOf(0,-1))
    }
}