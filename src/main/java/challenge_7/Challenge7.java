package challenge_7;

// Given a 32-bit signed integer, reverse digits of an integer.
//      Output: 321
//      Input: 123

public class Challenge7 {
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        System.out.println(solution7.reverse(1534236469));
    }
}

class Solution7 {
    public int reverse(int number) {
        long reversed = 0;
        while (number != 0) {
            reversed = 10 * reversed + number % 10;
            number = number / 10;
        }
        if (reversed < Integer.MAX_VALUE && reversed > Integer.MIN_VALUE) return (int) reversed;

        return 0;
    }
}
