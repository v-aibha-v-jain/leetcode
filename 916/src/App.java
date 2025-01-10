import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String words1[] = {"amazon","apple","facebook","google","leetcode"};
        String words2[] = {"e","o"};
        List<String> li = obj.wordSubsets(words1, words2);
        for (String s : li)
            System.out.println(s);
    }
}
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> li = new ArrayList<>(); // List to store the result
        int check[] = new int[26]; // Array to store the maximum frequency of each character in words2
        int n = words2.length; // Length of words2 array
        for (int i = 0; i < n; i++) {
            String s = words2[i]; // Current word from words2
            int arr[] = new int[26]; // Frequency array for the current word
            int len = s.length(); // Length of the current word
            for (int j = 0; j < len; j++)
            arr[s.charAt(j) - 'a']++; // Increment the frequency of the character
            for (int p = 0; p < 26; p++)
            check[p] = Math.max(arr[p], check[p]); // Update the maximum frequency
        }
        n = words1.length; // Length of words1 array
        for (int i = 0; i < n; i++) {
            int arr[] = new int[26]; // Frequency array for the current word
            String s = words1[i]; // Current word from words1
            int len = s.length(); // Length of the current word
            for (int j = 0; j < len; j++)
            arr[s.charAt(j) - 'a']++; // Increment the frequency of the character
            boolean flag = true; // Flag to check if the word is a subset
            for (int p = 0; p < 26; p++)
            if (arr[p] < check[p]) { // If the frequency of any character is less than required
                flag = false; // Set flag to false
                break; // Break the loop
            }
            if (flag)
            li.add(s); // Add the word to the result list
        }
        return li; // Return the result list
    }
}