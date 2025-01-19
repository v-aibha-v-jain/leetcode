public class App {
    public static void main(String[] args) throws Exception {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // false
        System.out.println(wordDictionary.search("bad")); // true
        System.out.println(wordDictionary.search(".ad")); // true
        System.out.println(wordDictionary.search("b..")); // true
    }
}
class WordDictionary {
    Trie t;
    public WordDictionary() {
        t = new Trie(); // Initialize the Trie
    }
    
    public void addWord(String word) {
        t.insertWord(word); // Add word to the Trie
    }
    
    public boolean search(String word) {
        return t.search(word, t.root); // Search word in the Trie
    }
}

class Node {
    Node links[];
    boolean isEndOfWord;
    Node() {
        links = new Node[26]; // Initialize links for 26 letters
        isEndOfWord = false; // Mark end of word as false
    }
    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null); // Check if character exists in links
    }
    void create(char ch, Node newNode) {
        links[ch - 'a'] = newNode; // Create a new node for character
    }
    Node get(char ch) {
        return links[ch - 'a']; // Get the node for character
    }
    void setEnd() {
        this.isEndOfWord = true; // Mark end of word as true
    }
}

class Trie {
    Node root;
    Trie() {
        root = new Node(); // Initialize the root node
    }
    void insertWord(String word) {
        Node pCrawls = root;
        for (char ch : word.toCharArray()) {
            if (!pCrawls.containsKey(ch)) {
                pCrawls.create(ch, new Node()); // Create node if character not present
            }
            pCrawls = pCrawls.get(ch); // Move to the next node
        }
        pCrawls.setEnd(); // Mark the end of the word
    }
    boolean search(String word, Node root) {
        Node pCrawls = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (int j = 0; j < 26; j++) {
                    if (pCrawls.links[j] != null) {
                        if (search(word.substring(i + 1, word.length()), pCrawls.links[j])) {
                            return true; // Return true if any path matches
                        }
                    }
                }
                return false; // Return false if no paths match
            } else {
                if (!pCrawls.containsKey(ch)) {
                    return false; // Return false if character not found
                }
                pCrawls = pCrawls.get(ch); // Move to the next node
            }
        }
        return pCrawls.isEndOfWord; // Return true if end of word is reached
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */