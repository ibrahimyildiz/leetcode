import random 

class RandomizedSet:
    def __init__(self):
        self.map = {}
        self.array = []
    
    def insert(self, val: int) -> bool:
        if val in self.map:
            return False
        self.map[val] = len(self.array)
        self.array.append(val)

        return True
    
    def remove(self, val: int) -> bool:
        if val not in self.map:
            return False
        
        index = self.map[val]
        last_value = self.array[-1]

        self.array[index] = last_value
        self.map[last_value] = index

        self.array.pop()
        del self.map[val]

        return True
    
    def get_random(self) -> int:
        return random.choice(self.array)
    
# Example usage:
randomized_set = RandomizedSet()
print(randomized_set.insert(1))       # True
print(randomized_set.remove(2))       # False
print(randomized_set.insert(2))       # True
print(randomized_set.get_random())     # Either 1 or 2
print(randomized_set.remove(1))       # True
print(randomized_set.insert(2))       # False
print(randomized_set.get_random())     # 2