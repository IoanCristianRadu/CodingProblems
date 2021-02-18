package challenge_8;

// Implement atoi which converts a string to an integer.
//      Input: "4193 with words"
//      Output: 4193
//      Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
//
//      Input: "words and 987"
//      Output: 0
//      Explanation: The first non-whitespace character is 'w', which is not a numerical
//      digit or a +/- sign. Therefore no valid conversion could be performed.

public class Challenge8 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("   -42"));
    }
}

class Solution {
    StringBuilder number = new StringBuilder();
    boolean numberHasSign = false;
    boolean firstZeroesHandled = false;

    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;

        handleNumberSigns(str);
        processString(str);
        return processReturnValue(number.toString());
    }

    public void handleNumberSigns(String str){
        numberHasSign = checkMinusSign(str);
        if(numberHasSign){
            number.append(str.charAt(0));
        } else{
            numberHasSign = checkPlusSign(str);
        }
    }

    public boolean checkMinusSign(String str){
        if(str.charAt(0) == '-' && str.length() > 1) {
            if (str.charAt(1) == '0' || str.charAt(1) == '1' || str.charAt(1) == '2' ||
                    str.charAt(1) == '3' || str.charAt(1) == '4' || str.charAt(1) == '5' ||
                    str.charAt(1) == '6' || str.charAt(1) == '7' || str.charAt(1) == '8' ||
                    str.charAt(1) == '9') {
                return true;
            }
        }
        return false;
    }

    public boolean checkPlusSign(String str){
        if(str.charAt(0) == '+' && str.length() > 1) {
            if (str.charAt(1) == '0' || str.charAt(1) == '1' || str.charAt(1) == '2' ||
                    str.charAt(1) == '3' || str.charAt(1) == '4' || str.charAt(1) == '5' ||
                    str.charAt(1) == '6' || str.charAt(1) == '7' || str.charAt(1) == '8' ||
                    str.charAt(1) == '9') {
                return true;
            }
        }
        return false;
    }

    public void processString(String str){
        for (int i = numberHasSign ? 1 : 0; i < str.length(); i++) {
            if(!firstZeroesHandled && str.charAt(i) == '0'){
                //do nothing
            }
            else if (str.charAt(i) == '0' || str.charAt(i) == '1' || str.charAt(i) == '2' ||
                    str.charAt(i) == '3' || str.charAt(i) == '4' || str.charAt(i) == '5' ||
                    str.charAt(i) == '6' || str.charAt(i) == '7' || str.charAt(i) == '8' ||
                    str.charAt(i) == '9') {
                number.append(str.charAt(i));
                firstZeroesHandled = true;
            }
            else break;
        }
    }

    public Integer processReturnValue(String result){
        if ( result.length() == 0 || (result.length() == 1 && result.charAt(0) == '-')){
            return 0;
        }
        if (result.length() > 11) {
            if (result.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }

        long solution = Long.parseLong(this.number.toString());
        if (solution <= Integer.MAX_VALUE && solution >= Integer.MIN_VALUE) {
            return (int) solution;
        }

        if (solution < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return Integer.MAX_VALUE;
    }
}
