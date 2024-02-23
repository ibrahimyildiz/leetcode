import java.util.*;

class Solution {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (src == dst) {
            return 0;
        }

        // Initialize prices with infinity
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        // Relax each edge at most k times
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(prices, n);
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                // Update price only if there's a better path
                if (prices[from] != Integer.MAX_VALUE) {
                    temp[to] = Math.min(temp[to], prices[from] + price);
                }
            }
            prices = temp;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0;
        int dst = 3;
        int k = 1;

        int result = findCheapestPrice(n, flights, src, dst, k);
        System.out.println(result); // 700
    }
}