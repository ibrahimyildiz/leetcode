function numberOfBeams(bank) {
    let beamCount = 0;
  
    for (let i = 0; i < bank.length - 1; i++) {
      const row1 = bank[i];
      for (let j = i + 1; j < bank.length; j++) {
        const row2 = bank[j];
  
        // Check for clear path between devices
        if (row1.includes('1') && row2.includes('1') && !bank.slice(i + 1, j).some(row => row.includes('1'))) {
          beamCount += row1.replace(/0/g, '').length * row2.replace(/0/g, '').length;
        }
      }
    }
  
    return beamCount;
  }

  // Example usage:
const bank = [
    "011001",
    "000000",
    "010100",
    "001000",
];

const result = numberOfBeams(bank);
console.log(result); // Output: 8
  