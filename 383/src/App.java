public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String ransomNote = "aa", magazine = "aab";
        System.out.println(obj.canConstruct(ransomNote, magazine));
    }
}
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int count[] = new int[26]; // Array to store the count of each character
        for (char ch : magazine.toCharArray()) {
            count[ch - 'a']++; // Increment the count for each character in magazine
        }
        for (char ch : ransomNote.toCharArray()) {
            count[ch - 'a']--; // Decrement the count for each character in ransomNote
            if (count[ch - 'a'] < 0) return false; // If count goes negative, return false
        }
        return true; // If all characters are matched, return true
    }
}