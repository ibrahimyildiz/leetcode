var findWinners = function (matches) {
  let winners = new Map();
  let losers = new Map();
  let answer = [];
  let winArr = [];
  let losArr = [];

  for (let i = 0; i < matches.length; i++) {
      const data = winners.get(matches[i][0].toString());

      if (data) data.count++;
      else winners.set(matches[i][0].toString(), { value: matches[i][0], count: 1 });
  }

  for (let i = 0; i < matches.length; i++) {
      const data = losers.get(matches[i][1].toString());

      if (data) data.count++;
      else losers.set(matches[i][1].toString(), { value: matches[i][1], count: 1 });
  }

  winners.forEach((value, key, map) => {
      if (losers.has(key) && losers.get(key).count < 2) {
          losArr.push(key);
      } else if (!losers.has(key)) {
          winArr.push(key);
      }
  });

  losers.forEach((value, key, map) => {
      if (!winners.has(key) && losers.get(key).count < 2) {
          losArr.push(key);
      }
  });

  answer[0] = winArr.sort((a, b)=> a-b);
  answer[1] = losArr.sort((a, b)=> a-b);

  return answer;
};

// Example usage:
const matches = [[1, 3], [2, 3], [3, 6], [5, 6], [5, 7], [4, 5], [4, 8], [4, 9], [10, 4], [10, 9]];
const result = findWinners(matches);
console.log(result); // [[1,2,10],[4,5,7,8]]
