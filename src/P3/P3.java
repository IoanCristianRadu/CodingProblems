package P3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Given a string, find the length of the longest substring without repeating characters.
//      Input: "abcabcbb"
//      Output: 3
//      Explanation: The answer is "abc", with the length of 3.

public class P3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abba"));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String inputWord) {
        Set<Character> visitedLetters = new HashSet<>();
        int rightIndex = 0, leftIndex = 0, highestLetterCount = 0;
        int wordSize = inputWord.length();
        while (rightIndex < wordSize && leftIndex < wordSize) {
            if (!visitedLetters.contains(inputWord.charAt(rightIndex))) {
                visitedLetters.add(inputWord.charAt(rightIndex));
                rightIndex++;
                highestLetterCount = Math.max(highestLetterCount, rightIndex - leftIndex);
            } else {
                visitedLetters.remove(inputWord.charAt(leftIndex));
                leftIndex++;
            }
        }
        return highestLetterCount;
    }

    //Original try: brute force ; hashmap is useless in this situation -> use hashset
    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        int size = 0;
        int maxSize = 0;

        for (int i = 0; i < s.length(); i++) {
            if (maxSize < size) {
                maxSize = size;
            }
            size = 0;
            map.clear();
            for (int j = i; j < s.length(); j++) {
                if (map.get(s.charAt(j)) == null || !map.get(s.charAt(j))) {
                    map.put(s.charAt(j), true);
                    size++;
                } else {
                    break;
                }
            }
        }

        if (maxSize == 0) {
            return size;
        }
        if (maxSize < size) {
            return size;
        }
        return maxSize;
    }
}
