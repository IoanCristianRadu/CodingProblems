import unittest
from challenge_66 import Solution


class SolutionTests(unittest.TestCase):
    def setUp(self) -> None:
        self.s = Solution()

    def testNormalFlow(self):
        unittest.TestCase.assertEquals(self, [2, 3, 2], self.s.plusOne([2, 3, 1]))

    def testMiddle(self):
        unittest.TestCase.assertEquals(self, [2, 1, 0, 0], self.s.plusOne([2, 0, 9, 9]))

    def testIncrementSize(self):
        unittest.TestCase.assertEquals(self, [1, 0, 0, 0], self.s.plusOne([9, 9, 9]))


if __name__ == '__main__':
    unittest.main()
