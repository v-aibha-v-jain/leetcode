import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}
class Trie {
    List<String> x; // List to store words
    public Trie() {
        x = new ArrayList<String>(); // Initialize the list
    }
    public void insert(String word) {
        x.add(word); // Add word to the list
    }
    public boolean search(String word) {
        return x.contains(word); // Check if the list contains the word
    }
    public boolean startsWith(String prefix) {
        for (String y : x) { // Iterate through the list
            if (y.startsWith(prefix)) { // Check if any word starts with the prefix
                return true; // Return true if prefix is found
            }
        }
        return false; // Return false if prefix is not found
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */