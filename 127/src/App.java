import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(obj.ladderLength(beginWord, endWord, wordList));
    }
}

class Solution {
    class Pair {
        String first;
        int second;
        Pair(String _first, int _second) {
            this.first = _first;
            this.second = _second;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>(); // Queue to store the current word and the number of steps
        q.add(new Pair(beginWord, 1)); // Add the beginWord with step count 1
        Set<String> st = new HashSet<>(); // Set to store the word list for quick lookup
        int len = wordList.size(); // Get the size of the word list
        for (int i = 0; i < len; i++) {
            st.add(wordList.get(i)); // Add all words from wordList to the set
        }
        st.remove(beginWord); // Remove the beginWord from the set
        while (!q.isEmpty()) { // While the queue is not empty
            String word = q.peek().first; // Get the current word
            int steps = q.peek().second; // Get the current step count
            q.remove(); // Remove the current word from the queue
            if (word.equals(endWord)) return steps; // If the current word is the endWord, return the steps
            for (int i = 0; i < word.length(); i++) { // For each character in the word
                for (char ch = 'a'; ch <= 'z'; ch++) { // Replace it with every possible character from 'a' to 'z'
                    char replacedCharArray[] = word.toCharArray(); // Convert the word to a character array
                    replacedCharArray[i] = ch; // Replace the character at position i
                    String replacedWord = new String(replacedCharArray); // Convert the character array back to a string
                    if (st.contains(replacedWord)) { // If the replaced word is in the set
                        st.remove(replacedWord); // Remove the replaced word from the set
                        q.add(new Pair(replacedWord, steps + 1)); // Add the replaced word to the queue with incremented step count
                    }
                }
            }
        }
        return 0; // If no transformation sequence is found, return 0
    }
}