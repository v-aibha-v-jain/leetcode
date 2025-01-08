public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String[] a = {"a","aba","ababa","aa"};
        int result = solution.countPrefixSuffixPairs(a);
        System.out.println(result);
    }
}
class Solution {
    public int countPrefixSuffixPairs(String[] a) {
        int count = 0; // Initialize count to 0
        int n = a.length; // Get the length of the array
        for(int i = 0; i < n; i++) { // Loop through each element in the array
            for(int j = i + 1; j < n; j++) { // Loop through each element after the current element
                if(isprefixandsuffix(a[i], a[j])) // Check if a[i] is a prefix and suffix of a[j]
                    count++; // Increment count if condition is true
            }
        }
        return count; // Return the final count
    }

    public boolean isprefixandsuffix(String str1, String str2) {
        return str2.startsWith(str1) && str2.endsWith(str1); // Check if str2 starts and ends with str1
    }
}