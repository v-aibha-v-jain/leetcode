public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        char[][] box = {{'#','.','#'}};
        char[][] result = solution.rotateTheBox(box);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length; // number of rows
        int n = box[0].length; // number of columns
        for (int i = 0; i < m; i++) { // iterate over each row
            int l = 0; // left boundary of the current segment
            int stones = 0; // count of stones in the current segment
            for (int r = 0; r < n; r++) { // iterate over each column in the row
                if (box[i][r] == '#') // if current cell has a stone
                    stones++; // increment stone count
                if (box[i][r] == '*' || (r == n - 1 && stones > 0)) { // if current cell is an obstacle or end of row with stones
                    int sFall = (box[i][r] == '*') ? r - 1 : r; // position where stones will fall
                    while (stones > 0) { // place all stones in the segment
                        box[i][sFall] = '#'; // place stone
                        sFall--; // move left
                        stones--; // decrement stone count
                    }
                    for (int k = l; k <= sFall; k++) // fill the rest of the segment with empty spaces
                        box[i][k] = '.'; // place empty space
                    l = r + 1; // update left boundary for the next segment
                }
            }
        }
        char rotatedBox[][] = new char[n][m]; // create a new box for the rotated result
        for (int i = 0; i < m; i++) // iterate over each row
            for (int j = 0; j < n; j++) // iterate over each column
                rotatedBox[j][m - i - 1] = box[i][j]; // rotate the box 90 degrees clockwise
        return rotatedBox;
    }
}