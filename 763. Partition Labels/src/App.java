import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String s = "ababcbacadefegdehijhklij";
        List<Integer> result = solution.partitionLabels(s);
        System.out.println(result);
    }
}
class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        Map<Character, Integer> lastIndex = new HashMap<>();
        // Store the last occurrence of each character in the string
        for (int i = 0; i < n; i++) {
            lastIndex.put(s.charAt(i), i);
        }

        List<Integer> result = new ArrayList<>();
        int i = 0;

        while (i < n) {
            char ch = s.charAt(i); // Get the current character
            int last = lastIndex.get(ch); // Get the last occurrence of the current character
            int maxLast = last; // Initialize maxLast with the last occurrence of the current character
            // Expand the partition to include all characters within the current range
            for (int j = i + 1; j < maxLast; j++) {
                maxLast = Math.max(lastIndex.get(s.charAt(j)), maxLast); // Update maxLast if needed
            }
            result.add(maxLast - i + 1); // Add the size of the partition to the result
            i = maxLast + 1; // Move to the next partition
        }
        return result; // Return the list of partition sizes
    }
}