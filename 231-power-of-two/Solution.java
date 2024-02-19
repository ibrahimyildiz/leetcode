public class Solution {

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        // Example usage:
        int num = 16;
        boolean result = isPowerOfTwo(num);
        System.out.println(num + " is a power of two: " + result);
    }
}
