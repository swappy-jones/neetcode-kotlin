package ArraysAndHashing

import java.util.TreeMap

/**
 * https://leetcode.com/problems/group-anagrams/submissions/1165769210/
 */
object GroupAnagram {
    fun main() {
        groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat"))
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val attributeMap = mutableMapOf<String, MutableList<String>>()
        val output = mutableListOf<MutableList<String>>()
        strs.forEach {
            val convert = convertToAlphaString(it)
            if(attributeMap.containsKey(convert)) {
                val list = attributeMap[convert]!!
                list.add(it)
            } else {
                attributeMap[convert] = mutableListOf(it)
            }
            attributeMap[convertToAlphaString(it)]
        }
        attributeMap.forEach {
            output.add(it.value)
        }
        return output
    }


    fun convertToAlphaString(str: String): String{
        val charCount = TreeMap<Char, Int>()
        str.forEach {
            val existingCount = charCount.getOrDefault(it, 0) + 1
            charCount[it] = existingCount
        }
        var output = ""
        charCount.forEach {
            output = output+it.key+it.value
        }
        return output
    }
}