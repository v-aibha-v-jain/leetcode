import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        List<List<String>> result = solution.suggestedProducts(products, searchWord);
        for (List<String> list : result) {
            System.out.println(list);
        }
    }
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // Sort the products array lexicographically
        List<List<String>> ans = new ArrayList<List<String>>(); // Initialize the result list
        for (int i = 1; i <= searchWord.length(); i++) { // Iterate through each prefix length
            String prefix = searchWord.substring(0, i); // Get the current prefix
            List<String> matches = new ArrayList<>(); // Initialize the list of matches for the current prefix
            for (String product : products) { // Iterate through each product
                if (product.startsWith(prefix)) { // Check if the product starts with the prefix
                    matches.add(product); // Add the product to the matches list
                    if (matches.size() == 3) break; // Stop if we already have 3 matches
                }
            }
            ans.add(matches); // Add the matches list to the result
        }
        return ans; // Return the final list of suggestions
    }
}