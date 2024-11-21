import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(obj.wordPattern(pattern, s));
    }
}
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" "); // split the string s into words
        if (pattern.length() != words.length) return false; // if pattern length and words length are not equal, return false
        HashMap<Character, String> charToWord = new HashMap<>(); // map to store character to word mapping
        HashMap<String, Character> wordToChar = new HashMap<>(); // map to store word to character mapping
        for (int i = 0; i < words.length; i++) { // iterate through each word
            char c = pattern.charAt(i); // get the character from pattern
            String word = words[i]; // get the word from words array
            if (charToWord.containsKey(c) && !charToWord.get(c).equals(word)) return false; // if character is already mapped to a different word, return false
            if (wordToChar.containsKey(word) && wordToChar.get(word) != c) return false; // if word is already mapped to a different character, return false
            charToWord.put(c, word); // map character to word
            wordToChar.put(word, c); // map word to character
        }
        return true;
    }
}