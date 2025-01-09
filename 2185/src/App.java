public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String[] words = {"pay","attention","practice","attend"};
        String pref = "at";
        System.out.println(obj.prefixCount(words, pref));
    }
}
class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0; // Initialize count to 0
        for (String word : words) // Iterate through each word in the array
            if (word.startsWith(pref)) // Check if the word starts with the given prefix
                count++; // Increment count if the word starts with the prefix
        return count; // Return the final count
    }
}