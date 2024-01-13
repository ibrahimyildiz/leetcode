function minSteps(s, t) {
    if (s.length !== t.length) {
        throw new Error('Input strings must have the same length');
    }

    const charFrequency = new Array(26).fill(0); // Assuming ASCII lowercase characters

    for (let i = 0; i < s.length; i++) {
        charFrequency[s.charCodeAt(i) - 'a'.charCodeAt(0)]++;
        charFrequency[t.charCodeAt(i) - 'a'.charCodeAt(0)]--;
    }

    const steps = charFrequency.reduce((accumulator, currentValue) => accumulator + Math.abs(currentValue), 0);

    return steps / 2; // Each step involves changing one character in either s or t
}

// Example usage:
const s = "leetcode";
const t = "practice";
const result = minSteps(s, t);
console.log(result); // Output: 5
