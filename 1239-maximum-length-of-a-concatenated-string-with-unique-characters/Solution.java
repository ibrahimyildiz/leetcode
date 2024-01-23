import java.util.HashSet;
import java.util.List;

public class Solution {

    public static int maxLength(List<String> arr) {
        int[] max = {0};
        backtrack(arr, 0, "", new HashSet<>(), max);
        return max[0];
    }

    private static void backtrack(List<String> arr, int index, String current, HashSet<Character> uniqueChars, int[] max) {
        if (isUnique(current)) {
            max[0] = Math.max(max[0], current.length());
        }

        for (int i = index; i < arr.size(); i++) {
            boolean isValid = true;
            HashSet<Character> currentSet = new HashSet<>(uniqueChars);
            for (char c : arr.get(i).toCharArray()) {
                if (!currentSet.add(c)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                backtrack(arr, i + 1, current + arr.get(i), currentSet, max);
            }
        }
    }

    private static boolean isUnique(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Example Usage: 
        List<String> arr = List.of("un", "iq", "ue");
        System.out.println(maxLength(arr)); // Output: 4
    }
}
