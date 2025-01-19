import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        char[][] board = {
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        Solution solution = new Solution();
        List<String> result = solution.findWords(board, words);
        System.out.println(result); // Output: ["eat", "oath"]
    }
}
class Solution {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26]; // Array to store child nodes
        String word = null; // Store word at the end of the path
    }

    private void insertWord(TrieNode root, String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) { // Traverse each character in the word
            int index = c - 'a'; // Calculate index for the character
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(); // Create new TrieNode if not exists
            }
            node = node.children[index]; // Move to the child node
        }
        node.word = word; // Store the word at the end node
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            insertWord(root, word); // Insert all words into the Trie
        }
        Set<String> result = new HashSet<>(); // To store the result words
        int m = board.length, n = board[0].length; // Dimensions of the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result); // Start DFS from each cell
            }
        }
        return new ArrayList<>(result); // Convert result set to list
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, Set<String> result) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) return; // Return if visited or no child node
        node = node.children[c - 'a']; // Move to the child node
        if (node.word != null) {
            result.add(node.word); // Add word to result if found
            node.word = null; // Avoid duplicate entries
        }
        board[i][j] = '#'; // Mark the cell as visited
        int[] dirs = {-1, 0, 1, 0, -1}; // Directions for moving in the board
        for (int d = 0; d < 4; d++) {
            int ni = i + dirs[d], nj = j + dirs[d + 1]; // Calculate new indices
            if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length) {
                dfs(board, ni, nj, node, result); // Continue DFS in the new cell
            }
        }
        board[i][j] = c; // Restore the cell
    }
}