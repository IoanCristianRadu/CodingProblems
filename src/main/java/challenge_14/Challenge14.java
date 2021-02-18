package challenge_14;

// Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string "".
//      Runtime: 4 ms, faster than 99.85% of Java online submissions for Longest Common Prefix.

public class Challenge14 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(words));
    }
}

class Solution {
    public String longestCommonPrefix(String[] words) {
        if (words.length == 0) return "";
        if (words.length == 1) return words[0];

        boolean differentLetters = false;
        int commonLettersFromStart = 0;
        try {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                for (String word : words) {
                    if (word.charAt(i) != words[0].charAt(i)) {
                        differentLetters = true;
                        break;
                    }
                }
                if (differentLetters) {
                    break;
                } else {
                    commonLettersFromStart++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (commonLettersFromStart > -1) {
            return words[0].substring(0, commonLettersFromStart);
        }
        return "";
    }
}