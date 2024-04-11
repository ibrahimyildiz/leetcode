from collections import deque
from typing import List

class Solution:
    def deckRevealedIncreasing(self, deck: List[int]) -> List[int]:
        deck.sort()
        
        n = len(deck)
        result = [0] * n
        indices = deque(range(n))
        
        for card in deck:
            idx = indices.popleft() 
            result[idx] = card       
            if indices:              
                indices.append(indices.popleft()) 
        
        return result
    
# Example usage
solution = Solution()
deck = [3, 1, 4, 2, 5]
revealed_order = solution.deckRevealedIncreasing(deck)
print(f"Revealed order: {revealed_order}") # [1, 5, 2, 4, 3]