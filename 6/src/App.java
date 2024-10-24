public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String result = solution.convert("PAYPALISHIRING", 3);
        System.out.println(result);
    }
}
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) { // if numRows is 1, return the string
            return s;
        }
        StringBuilder answer = new StringBuilder();
        int n = s.length();
        int diff = 2 * (numRows - 1);
        int diagonalDiff = diff; // difference between the two characters in the diagonal
        int secondIndex; // index of the second character in the diagonal
        int index; // index of the character in the string
        for (int i = 0; i < numRows; i++) {
            index = i;
            while (index < n) {
                answer.append(s.charAt(index));
                if (i != 0 && i != numRows - 1) {
                    diagonalDiff = diff-2*i; // update the diagonal difference
                    secondIndex = index + diagonalDiff; // calculate the index of the second character in the diagonal
                    if (secondIndex < n) { // if the second index is within the string then append the character to the answer
                        answer.append(s.charAt(secondIndex));
                    }
                }
                index += diff; // move to the next character in the column
            }
        }
        return answer.toString();
    }
}