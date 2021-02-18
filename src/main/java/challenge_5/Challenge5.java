package challenge_5;

// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//      Input: "babad"
//      Output: "bab"
//      Note: "aba" is also a valid answer.

public class Challenge5 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("fsasdffdfdsfsabcdcbafdjgkytmytttabcdefgijklmnmlkjigfedcba"));
    }
}

class Solution {
    public String longestPalindrome(String s) {
        int stringLength = s.length();
        int substringStartingIndex, substringEndingIndex ;
        boolean isPalindrome;
        String finalSubString = "";

        for (int currentSubstringSize = stringLength; currentSubstringSize > 0; currentSubstringSize--) {
            for (int substringStart = 0; substringStart + currentSubstringSize <= stringLength; substringStart++) {
                isPalindrome = true;
                for (int i = substringStart, j = currentSubstringSize + i - 1; i < j; i++, j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPalindrome) {
                    substringStartingIndex = substringStart;
                    substringEndingIndex = currentSubstringSize + substringStart;
                    finalSubString = s.substring(substringStartingIndex, substringEndingIndex);
                    return finalSubString;
                }
            }
        }
        return finalSubString;
    }
}
