public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println(solution.exist(board, word));
    }
}
class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) { // iterate over each row
            for(int j = 0; j < board[0].length; j++) { // iterate over each column
                if(board[i][j] == word.charAt(0)) { // check if the first character matches
                    System.out.println(i + " " + j); // print the position
                    if(findWord(board, word, 0, i, j)) return true; // start the search
                }
            }
        }
        return false; // return false if word is not found
    }
    boolean findWord(char[][] board, String word, int index, int r, int c) {
        if(index == word.length()) return true; // if all characters are matched
        if(r < 0 || c < 0 || r == board.length || c == board[0].length || board[r][c] != word.charAt(index) || board[r][c] == '#') {
            return false; // if out of bounds or character does not match or already visited
        }
        char ch = board[r][c]; // store the current character
        board[r][c] = '#'; // mark as visited
        if(findWord(board, word, index + 1, r, c + 1)) return true; // search right
        if(findWord(board, word, index + 1, r, c - 1)) return true; // search left
        if(findWord(board, word, index + 1, r + 1, c)) return true; // search down
        if(findWord(board, word, index + 1, r - 1, c)) return true; // search up
        board[r][c] = ch; // unmark the visited cell
        return false; // return false if word is not found
    }
}