import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Character> sToTMapping = new HashMap<>();
        Map<Character, Character> tToSMapping = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            if (!sToTMapping.containsKey(sChar) && !tToSMapping.containsKey(tChar)) {
                sToTMapping.put(sChar, tChar);
                tToSMapping.put(tChar, sChar);
            } else {
                if (sToTMapping.getOrDefault(sChar, tChar) != tChar || tToSMapping.getOrDefault(tChar, sChar) != sChar) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        String s1 = "egg";
        String t1 = "add";
        System.out.println(isIsomorphic(s1, t1)); // true

        String s2 = "foo";
        String t2 = "bar";
        System.out.println(isIsomorphic(s2, t2)); // false

        String s3 = "paper";
        String t3 = "title";
        System.out.println(isIsomorphic(s3, t3)); // true
    }
}