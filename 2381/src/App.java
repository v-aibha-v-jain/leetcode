public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String s = "abc";
        int[][] shifts = {{0,1,0},{1,2,1},{0,2,1}};
        System.out.println(solution.shiftingLetters(s, shifts));
    }
}
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] arr = s.toCharArray(); // Convert the string to a character array
        int n = s.length(); // Get the length of the string
        int[] mov = new int[n+1]; // Create an array to store the net shifts
        int index, dir; // Initialize variables for index and direction
        for(int[] shift : shifts) { // Iterate through each shift operation
            dir = shift[2] == 0 ? -1 : 1; // Determine the direction of the shift
            mov[shift[0]] += dir; // Apply the shift to the start index
            mov[shift[1] + 1] -= dir; // Apply the reverse shift to the end index + 1
        }
        for(int i = 1; i < mov.length; i++) // Calculate the prefix sum to get net shifts
            mov[i] += mov[i-1];
        for(int i = 0; i < arr.length; i++) { // Apply the net shifts to each character
            index = (arr[i] - 'a' + mov[i] % 26 + 26) % 26; // Calculate the new character index
            arr[i] = (char)('a' + index); // Update the character in the array
        }
        return new String(arr); // Convert the character array back to a string and return it
    }
}