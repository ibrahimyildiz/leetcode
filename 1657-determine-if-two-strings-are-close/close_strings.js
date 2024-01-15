function closeStrings(word1, word2) {
    if (word1.length !== word2.length) {
        return false;
    }

    const freqMap1 = getCharacterFrequencyMap(word1);
    const freqMap2 = getCharacterFrequencyMap(word2);

    const chars1 = Array.from(freqMap1.keys()).sort().join('');
    const chars2 = Array.from(freqMap2.keys()).sort().join('');

    const freqs1 = Array.from(freqMap1.values()).sort().join('');
    const freqs2 = Array.from(freqMap2.values()).sort().join('');

    return chars1 === chars2 && freqs1 === freqs2;
}

function getCharacterFrequencyMap(word) {
    const freqMap = new Map();
    for (const char of word) {
        freqMap.set(char, (freqMap.get(char) || 0) + 1);
    }
    return freqMap;
}

// Example usage:
const word1 = "cabbba";
const word2 = "abbccc";
const result = closeStrings(word1, word2);
console.log(result); // Output: true
