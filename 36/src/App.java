public class App {
    public static void main(String[] args) throws Exception {
        Solution obj=new Solution();
        char[][] board={{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(obj.isValidSudoku(board));
    }
}
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows=new boolean[9][9];
        boolean[][] col=new boolean[9][9];
        boolean[][] box=new boolean[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int num=board[i][j]-'1'; 
                    int boxindex=(i/3)*3+(j/3);
                    if(rows[i][num] || col[j][num] || box[boxindex][num]){
                        return false;
                    }
                    rows[i][num]=true;
                    col[j][num]=true;
                    box[boxindex][num]=true;
                
                }
            }
            
        }
        return true;
    }
}