import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String word1 = "cabbba";
        String word2 = "abbccc";
        boolean result = closeStrings(word1, word2);
        System.out.println(result); // Output: true
    }

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> freqMap1 = getCharacterFrequencyMap(word1);
        Map<Character, Integer> freqMap2 = getCharacterFrequencyMap(word2);

        String chars1 = getSortedCharacters(freqMap1);
        String chars2 = getSortedCharacters(freqMap2);

        String freqs1 = getSortedFrequencies(freqMap1);
        String freqs2 = getSortedFrequencies(freqMap2);

        return chars1.equals(chars2) && freqs1.equals(freqs2);
    }

    private static Map<Character, Integer> getCharacterFrequencyMap(String word) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        return freqMap;
    }

    private static String getSortedCharacters(Map<Character, Integer> freqMap) {
        char[] chars = new char[freqMap.size()];
        int index = 0;
        for (char c : freqMap.keySet()) {
            chars[index++] = c;
        }
        Arrays.sort(chars);
        return new String(chars);
    }

    private static String getSortedFrequencies(Map<Character, Integer> freqMap) {
        int[] frequencies = new int[freqMap.size()];
        int index = 0;
        for (int frequency : freqMap.values()) {
            frequencies[index++] = frequency;
        }
        Arrays.sort(frequencies);
        return Arrays.toString(frequencies);
    }
}