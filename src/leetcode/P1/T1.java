package leetcode.P1;

import java.util.HashMap;
import java.util.Map;

public class T1 {
    public static void main(String[] args){
        Solution solution = new Solution();

        int[] numbers = {2,7,11,15};
        int[] sol = solution.twoSum(numbers,9);
        System.out.println(sol[0] + " " + sol[1]);
    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target){
        Map<Integer, Integer> map = createMap(numbers);
        return findPair(map,numbers,target);
    }

    public Map<Integer, Integer> createMap(int[] numbers){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            map.put(numbers[i],i);
        }
        return map;
    }

    public int[] findPair(Map<Integer,Integer> map, int[] numbers, int target){
        for(int i=0; i<numbers.length;i++){
            int goal = target - numbers[i];
            if(map.containsKey(goal) && map.get(goal) != i){
                return new int[] {i, map.get(goal)};
            }
        }
        return null;
    }
}
