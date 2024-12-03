public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String s = "icodeinpython";
        int[] spaces = {1,5,7,9};
        String result = solution.addSpaces(s, spaces);
        System.out.println(result);
    }
}
class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n = s.length(); // get the length of the string
        int m = spaces.length; // get the length of the spaces array
        int j = 0; // initialize the index for spaces array
        StringBuilder sb = new StringBuilder(); // create a StringBuilder to build the result string
        for (int i = 0; i < n; i++) { // iterate over each character in the string
            if (j < m && i == spaces[j]) { // check if the current index matches the space index
                sb.append(" "); // add a space to the result string
                j++; // move to the next space index
            }
            sb.append(s.charAt(i)); // add the current character to the result string
        }
        return sb.toString(); // return the result string with spaces added
    }
}