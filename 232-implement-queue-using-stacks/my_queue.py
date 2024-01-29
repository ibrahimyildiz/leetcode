class MyQueue:
    def __init__(self):
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        self.s1.append(x) # Push elements to stack1

    def pop(self) -> int:
        # If stack2 is empty, transfer elements from stack1
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2.pop() # Pop from stack2
    
    def peek(self) -> int:
         # If stack2 is empty, transfer elements from stack1
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2[-1] # Peek from stack2 without popping
    
    def empty(self) -> bool:
        return max(len(self.s1), len(self.s2)) == 0 # Check if both stacks are empty
 
# Example usage:
queue = MyQueue()
queue.push(1)
queue.push(2)
print(queue.peek())  # Output: 1
print(queue.pop())   # Output: 1
print(queue.empty())  # Output: False