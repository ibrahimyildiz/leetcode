class Solution {
    public static int lengthOfLastWord(String s) {
        s = s.trim();

        int length = 0;
        int i = s.length() - 1;

        while (i>=0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    public static void main(String[] args) {
        String s1 = "Hello World";
        String s2 = "   fly me   to   the moon  ";
        String s3 = "luffy is still joyboy";

        System.out.println(lengthOfLastWord(s1)); // 5
        System.out.println(lengthOfLastWord(s2)); // 4
        System.out.println(lengthOfLastWord(s3)); // 6
    }
}