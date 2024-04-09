from typing import List

class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        n = len(tickets)
        value = tickets[k]
        time = 0
        for i in range(n):
            if i < k:
                time += min(tickets[i], value)
            elif i == k:
                time += value
            else:
                if tickets[i] < value:
                    time += tickets[i]
                else:
                    time += value - 1
        return time

# Example usage:
solution = Solution()
tickets = [2, 3, 2]
k = 2
print(solution.timeRequiredToBuy(tickets, k))  # 6
