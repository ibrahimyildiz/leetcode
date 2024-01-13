/**
 * @param {string} s
 * @return {boolean}
 */
var halvesAreAlike = function(s) {
    const countVowels = (str) => {
        const vowels = new Set(['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']);
        let count = 0;

        for (const char of str) {
            if (vowels.has(char)) {
                count++;
            }
        }

        return count;
    };

    const halfLength = s.length / 2;
    const firstHalf = s.slice(0, halfLength);
    const secondHalf = s.slice(halfLength);

    return countVowels(firstHalf) === countVowels(secondHalf);
};

// Example usage:
const inputString = "AbCdEfGh";
const result = halvesAreAlike(inputString);
console.log(result); // Output: true