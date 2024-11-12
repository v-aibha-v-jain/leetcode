import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>(); // list to store result indices
        if (s == null || s.length() == 0 || words == null || words.length == 0) // check for null or empty input
            return result; // return empty result if input is invalid
        int wordLength = words[0].length(); // length of each word
        int wordCount = words.length; // number of words
        int totalLength = wordLength * wordCount; // total length of concatenated words
        Map<String, Integer> wordMap = new HashMap<>(); // map to store word frequency
        for (String word : words) // iterate over words
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1); // update word frequency in map
        for (int i = 0; i < wordLength; i++) { // iterate over each character in the word length
            int start = i; // start index of the window
            int end = i; // end index of the window
            Map<String, Integer> currentMap = new HashMap<>(); // map to store current window word frequency
            while (end + wordLength <= s.length()) { // iterate while end index is within bounds
                String word = s.substring(end, end + wordLength); // get the current word from string
                end += wordLength; // move end index by word length
                if (wordMap.containsKey(word)) { // check if word is in the word map
                    currentMap.put(word, currentMap.getOrDefault(word, 0) + 1); // update current window word frequency
                    while (currentMap.get(word) > wordMap.get(word)) { // if current word frequency exceeds required frequency
                        String firstWord = s.substring(start, start + wordLength); // get the first word in the current window
                        currentMap.put(firstWord, currentMap.get(firstWord) - 1); // decrease frequency of the first word
                        start += wordLength; // move start index by word length
                    }
                    if (end - start == totalLength) // check if current window matches total length of concatenated words
                        result.add(start); // add start index to result
                } else { // if word is not in the word map
                    currentMap.clear(); // clear current window word frequency map
                    start = end; // move start index to end
                }
            }
        }
        return result;
    }
}