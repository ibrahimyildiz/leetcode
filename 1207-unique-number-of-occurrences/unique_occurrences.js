const uniqueOccurrences = (arr) => {
    const occurenceMap = new Map();

    for(const num of arr) {
        occurenceMap.set(num, (occurenceMap.get(num) || 0) + 1);
    }
    

    const occurenceSet = new Set(occurenceMap.values());

    return occurenceSet.size === occurenceMap.size;
}

// Example usage:
const arr1 = [1, 2, 2, 1, 1, 3];
const arr2 = [1, 2];
const arr3 = [-3, 0, 1, -3, 1, 1, 1, -3, 10, 0];

console.log(uniqueOccurrences(arr1)); // Output: true
console.log(uniqueOccurrences(arr2)); // Output: false
console.log(uniqueOccurrences(arr3)); // Output: true