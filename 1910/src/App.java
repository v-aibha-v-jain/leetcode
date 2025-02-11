public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String s = "daabcbaabcbc", part = "abc";
        System.out.println(solution.removeOccurrences(s, part));
    }
}
class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder str = new StringBuilder(s); // Create a mutable string from the input string
        while (str.indexOf(part) != -1) { // Loop while the part is found in the string
            int index = str.indexOf(part); // Find the index of the part in the string
            str.delete(index, index + part.length()); // Delete the part from the string
        }
        return str.toString(); // Convert the mutable string back to an immutable string and return it
    }
}