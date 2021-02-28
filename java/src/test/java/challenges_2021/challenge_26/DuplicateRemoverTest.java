package challenges_2021.challenge_26;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DuplicateRemoverTest {
    @Test
    public void removeDuplicates() {
        DuplicateRemover duplicateRemover = new DuplicateRemover();
        int[] actual = new int[]{1, 1, 2, 3};
        int[] expected = new int[]{1, 2, 3};
        int expectedSize = 3;
        int actualSize = duplicateRemover.removeDuplicates(actual);


        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
        assertEquals(expected[2], actual[2]);
        assertEquals(expectedSize, actualSize);
    }
}