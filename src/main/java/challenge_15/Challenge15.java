package challenge_15;

import java.util.*;
import java.util.stream.Collectors;

// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
// Find all unique triplets in the array which gives the sum of zero.
// The solution set must not contain duplicate triplets.

class Challenge15 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.bruteForce(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}

class Solution {
    public List<List<Integer>> bruteForce(int[] numbers) {
        List<List<Integer>> solution = new ArrayList<>();

        if (numbers.length < 3) {
            return new ArrayList<>();
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    if (numbers[i] + numbers[j] + numbers[k] == 0) {
                        List<Integer> solutionSet = new ArrayList<>();

                        solutionSet.add(numbers[i]);
                        solutionSet.add(numbers[j]);
                        solutionSet.add(numbers[k]);
                        solutionSet.sort(Comparator.comparingInt(a -> a));
                        solution.add(solutionSet);
                    }
                }
            }
        }
        return solution.stream().distinct().collect(Collectors.toList());
    }
}