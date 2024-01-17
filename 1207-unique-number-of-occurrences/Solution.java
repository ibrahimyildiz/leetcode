import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurenceMap = new HashMap<>();

        for(int num : arr) {
            occurenceMap.put(num, occurenceMap.getOrDefault(num, 0) + 1);
        }

        Set<Integer> occurenceSet = new HashSet<>(occurenceMap.values());
        
        return occurenceSet.size() == occurenceMap.size();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 1, 1, 3};
        int[] arr2 = {1, 2};
        int[] arr3 = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        
        System.out.println(uniqueOccurrences(arr1)); // Output: true
        System.out.println(uniqueOccurrences(arr2)); // Output: false
        System.out.println(uniqueOccurrences(arr3)); // Output: true
    }
}