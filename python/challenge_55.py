from typing import List


# Challenge 55: https://leetcode.com/problems/jump-game/
class Solution:
    # for the recursive solution
    def __init__(self):
        self.found = False

    def canJump(self, nums: List[int]) -> bool:
        return self.canJumpIterative(nums)

        # self.canJumpRecursive(nums)
        # return self.found

    def canJumpIterative(self, nums: List[int]) -> bool:
        if len(nums) == 1:
            return True

        jump = nums
        current_location = 0
        last_jump_index = 0
        last_jump_length = jump[0]
        while jump[0] != 0:
            if current_location >= len(jump) - 1:
                return True
            if jump[current_location] != 0:
                last_jump_length = jump[current_location]
                last_jump_index = current_location
                current_location += jump[current_location]
            else:
                if last_jump_length == 0:
                    current_location -= 1
                else:
                    current_location -= 1
                    jump[last_jump_index] -= 1
                    last_jump_length -= 1
        return False

    def canJumpRecursive(self, nums: List[int]) -> None:
        if not self.found:
            if not nums:
                return

            if len(nums) == 1:
                self.found = True

            maxJumpLength = nums[0]
            for i in range(maxJumpLength, 0, -1):
                self.canJump(nums[i:])
