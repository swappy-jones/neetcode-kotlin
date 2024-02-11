package ArraysAndHashing

object Anagram {

    /**
     * https://leetcode.com/problems/valid-anagram/
     */
    fun isAnagram(s1: String, s2: String): Boolean {
        return isAnagramLowerCase(s1.lowercase(), s2.lowercase())
    }

    fun isAnagramLowerCase(s1: String, s2: String): Boolean {
        val characters = mutableMapOf<Char, Int>()
        s1.forEach{ ch ->
            characters[ch] = characters.getOrDefault(ch, 0) +1
        }

        s2.forEach {ch ->
            if(characters.getOrDefault(ch, 0) > 0) {
                characters[ch] = characters.getOrDefault(ch, 0) -1
            } else {
                return false
            }
        }
        characters.forEach{
            if(it.value != 0) {
                return false
            }
        }
        return true
    }

    fun main() {
        println(isAnagram("anagram", "nagaram"))
    }
}