import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String[] words = {"mass","as","hero","superhero"};
        List<String> res = solution.stringMatching(words);
        for(String s : res){
            System.out.println(s);
        }
    }
}
class Solution {
    public List<String> stringMatching(String[] words) {
        String str = String.join(" ", words); // Join all words into a single string separated by spaces
        List<String> res = new ArrayList<>(); // Initialize the result list
        for(int i = 0; i < words.length; i++){ // Iterate through each word
            if(str.indexOf(words[i]) != str.lastIndexOf(words[i])){ // Check if the word appears more than once
            res.add(words[i]); // Add the word to the result list if it appears more than once
            }
        }
        return res; // Return the result list
    }
}