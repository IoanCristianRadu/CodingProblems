package challenges_2021.challenge_26;

public class DuplicateRemover {
    // int[] nums is a sorted array
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int previousElement = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (previousElement != nums[i]) {
                previousElement = nums[i];
                if (index != i) {
                    nums[index] = nums[i];
                }
                index++;
            }
        }

        return index;
    }
}
