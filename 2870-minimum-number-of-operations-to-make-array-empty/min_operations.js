function minOperations(nums) {
    let res = 0;
    const counts = getCharacterFrequencyMap(nums);

    for(let [char, count] of counts) {
        if(count == 1) return -1;
        res += Math.floor(count / 3) + (count % 3 === 0 ? 0 : 1);
    }

    return res;
}

function getCharacterFrequencyMap(word) {
    const freqMap = new Map();
    for (const char of word) {
        freqMap.set(char, (freqMap.get(char) || 0) + 1);
    }
    return freqMap;
}

// Example usage:
const nums1 = [2, 3, 3, 2, 2, 4, 2, 3, 4];
const result1 = minOperations(nums1);
console.log(result1); // Output: 4

const nums2 = [2, 1, 2, 2, 3, 3];
const result2 = minOperations(nums2);
console.log(result2); // Output: -1