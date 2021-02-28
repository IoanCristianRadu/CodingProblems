from typing import List


# Challenge 66: https://leetcode.com/problems/plus-one/
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        if digits[-1] != 9:
            digits[-1] += 1
            return digits

        for i in range(len(digits) - 1, -1, -1):
            if digits[i] == 9:
                digits[i] = 0
                continue
            else:
                digits[i] += 1
                return digits

        # if you are here [9,9,9] -> [1,0,0,0]
        digits.insert(0, 1)
        return digits
