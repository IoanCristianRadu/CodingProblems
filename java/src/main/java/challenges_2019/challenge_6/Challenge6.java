package challenges_2019.challenge_6;

// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this
//      P   A   H   N
//      A P L S I I G
//      Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows:
//      Input: s = "PAYPALISHIRING", numRows = 3
//      Output: "PAHNAPLSIIGYIR"

public class Challenge6 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }
}

class Solution {
    public String convert(String s, int numRows) {
        int rowsDown = numRows - 1, column, characterIndex = 0;
        char[][] zigZaggedString = new char[rowsDown + 1][s.length()];
        boolean endOfString = false;

        if (rowsDown != 0) {
            int row = 0, j;
            while (row < s.length()) {
                j = 0;
                while (j < rowsDown) {
                    if (characterIndex < s.length()) {
                        zigZaggedString[j][row] = s.charAt(characterIndex++);
                        j++;
                    } else {
                        endOfString = true;
                        break;
                    }
                }

                column = rowsDown;
                while (column > 0) {
                    if (characterIndex < s.length()) {
                        zigZaggedString[column--][row++] = s.charAt(characterIndex++);
                    } else {
                        endOfString = true;
                        break;
                    }
                }

                if (endOfString) {
                    break;
                }
            }
            StringBuilder solution = new StringBuilder();
            for (row = 0; row < rowsDown + 1; row++) {
                for (j = 0; j < s.length(); j++) {
                    if (zigZaggedString[row][j] != '\u0000') {
                        solution.append(zigZaggedString[row][j]);
                    }
                }
            }
            return solution.toString();
        }
        return s;
    }
}
