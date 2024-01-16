class RandomizedSet {
    constructor() {
        this.map = new Map();
        this.array = [];
    }

    insert(val) {
        if(this.map.has(val)) {
            return false;
        }

        this.map.set(val, this.array.length);
        this.array.push(val);
        return true;
    }

    remove(val) {
        if(!this.map.has(val)) {
            return false;
        }

        const index = this.map.get(val);
        const lastValue = this.array[this.array.length-1];

        this.array[index] = lastValue;
        this.map.set(lastValue, index);

        this.array.pop();
        this.map.delete(val);

        return true;
    }


    getRandom() {
        const randomIndex = Math.floor(Math.random() * this.array.length);

        return this.array[randomIndex];
    }
}

// Example usage:
const randomizedSet = new RandomizedSet();
console.log(randomizedSet.insert(1)); // true
console.log(randomizedSet.remove(2)); // false
console.log(randomizedSet.insert(2)); // true
console.log(randomizedSet.getRandom()); // Either 1 or 2
console.log(randomizedSet.remove(1)); // true
console.log(randomizedSet.insert(2)); // false
console.log(randomizedSet.getRandom()); // 2