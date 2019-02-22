package P11;

public class P11 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    }
}

class Solution {
    public int maxArea(int[] height) {
        int maxVolume = 0;
        int rectangleHeight, rectangleLength, rectangleVolume;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                rectangleHeight = Math.min(height[i], height[j]);
                rectangleLength = j-i;
                rectangleVolume = rectangleHeight * rectangleLength;
                if(maxVolume < rectangleVolume){
                    maxVolume = rectangleVolume;
                }
            }
        }
        return maxVolume;
    }
}
