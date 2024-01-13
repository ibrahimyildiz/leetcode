function findMatrix(nums) {
    const result = [];
    const seen = new Set();

    for (const num of nums) {
        let added = false;

        for (let row of result) {
            if (!row.includes(num) && !added) {
                row.push(num);
                seen.add(num);
                added = true;
            }
        }

        if (!added) {
            result.push([num]);
            seen.add(num);
        }
    }

    return result;
}

// Example usage:
const nums = [1, 3, 4, 1, 2, 3, 1];
const result = findMatrix(nums);
console.log(result);
