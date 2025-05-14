import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String s = "abcyy";
        int t = 2;
        List<Integer> nums = List.of(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2);
        int result = solution.lengthAfterTransformations(s, t, nums);
        System.out.println(result);
    }
}
class Solution {
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        final int MOD = 1_000_000_007; // modulo for large numbers
        long transformations = t; // number of transformations
        long[][] transformMatrix = new long[26][26]; // transformation matrix for 26 letters
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < nums.get(i); j++) {
                int nextChar = (i + j + 1) % 26; // calculate next character index
                transformMatrix[i][nextChar]++; // increment transformation count
            }
        }
        long[][] resultMatrix = matrixPower(transformMatrix, transformations, MOD); // raise matrix to t-th power
        long totalLength = 0; // total length after transformations
        for (char c : s.toCharArray()) {
            int charIndex = c - 'a'; // get index of character
            long charContribution = 0; // contribution of this character
            for (int i = 0; i < 26; i++) {
                charContribution = (charContribution + resultMatrix[charIndex][i]) % MOD; // sum all possible transformations
            }   
            totalLength = (totalLength + charContribution) % MOD; // add to total length
        }
        return (int) totalLength; // return final answer
    }
    private long[][] multiplyMatrix(long[][] A, long[][] B, int MOD) {
        int n = A.length; // size of matrix
        long[][] result = new long[n][n]; // result matrix
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] = (result[i][j] + A[i][k] * B[k][j]) % MOD; // matrix multiplication with modulo
                }
            }
        }
        return result; // return multiplied matrix
    }
    private long[][] matrixPower(long[][] matrix, long power, int MOD) {
        int n = matrix.length; // size of matrix
        long[][] result = new long[n][n]; // identity matrix
        for (int i = 0; i < n; i++) {
            result[i][i] = 1; // set diagonal to 1
        }
        while (power > 0) {
            if (power % 2 == 1) {
                result = multiplyMatrix(result, matrix, MOD); // multiply if power is odd
            }
            matrix = multiplyMatrix(matrix, matrix, MOD); // square the matrix
            power /= 2; // divide power by 2
        }
        return result; // return matrix raised to power
    }
}