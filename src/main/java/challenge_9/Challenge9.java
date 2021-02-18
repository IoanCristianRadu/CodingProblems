package challenge_9;

// Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
//      Input: 121
//      Output: true
//
// Runtime: 73 ms, faster than 98.74% of Java online submissions for Palindrome Number.
// Memory Usage: 38.9 MB, less than 99.60% of Java online submissions for Palindrome Number.

public class Challenge9 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(1234321));
    }
}

class Solution {
    public boolean isPalindrome(int testedNumber) {
        int reverse = 0, actual = testedNumber;
        if (testedNumber < 0) return false;

        while (actual != 0) {
            reverse = reverse * 10 + actual % 10;
            actual = actual / 10;
        }
        return reverse == testedNumber;
    }
}
