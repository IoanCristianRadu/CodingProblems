package challenges_2019.challenge_15;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Challenge15Test {
    @Test
    public void bruteForce() {
        Solution challenge15 = new Solution();
        List<List<Integer>> expected = challenge15.bruteForce(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> actual = new ArrayList<>();
        List<Integer> firstElement = new ArrayList(Arrays.asList(-1, 0, 1));
        List<Integer> secondElement = new ArrayList(Arrays.asList(-1, -1, 2));
        actual.add(firstElement);
        actual.add(secondElement);
        assertEquals(expected, actual);
    }
}