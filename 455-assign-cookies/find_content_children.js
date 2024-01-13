function findContentChildren(g, s) {
    g.sort((a, b) => a - b); // Sort greed factors in ascending order
    s.sort((a, b) => a - b); // Sort cookie sizes in ascending order

    let contentChildren = 0;
    let i = 0; // Index for greed factors
    let j = 0; // Index for cookie sizes

    while (i < g.length && j < s.length) {
        if (s[j] >= g[i]) {
            // Assign the cookie to the child
            contentChildren++;
            i++;
        }
        j++;
    }

    return contentChildren;
}

// Example usage:
const greedFactors = [1, 2, 3];
const cookieSizes = [1, 1];
const result = findContentChildren(greedFactors, cookieSizes);
console.log(result); // Output: 1