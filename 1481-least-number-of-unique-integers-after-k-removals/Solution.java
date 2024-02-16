import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(frequencyMap.values());

        while (k > 0) {
            int frequency = minHeap.poll();
            
            if (k >= frequency) {
                k -= frequency;
            } else {
                minHeap.offer(frequency - k);
                k = 0;
            }
        }

        return minHeap.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4, 3, 1, 1, 3, 3, 2, 4, 4};
        int k = 3;
        int result = solution.findLeastNumOfUniqueInts(arr, k);
        System.out.println(result); // Output: 2
    }
}