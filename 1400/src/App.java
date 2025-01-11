public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String s = "annabelle";
        int k = 2;
        System.out.println(obj.canConstruct(s, k));
    }
}
class Solution {
    public boolean canConstruct(String s, int k) {
        if(k > s.length()) return false; // If k is greater than the length of the string, it's impossible to construct k palindromes
        else if(k == s.length()) return true; // If k is equal to the length of the string, each character can be a palindrome
        int oddPairsCount = 0; // Initialize a counter for characters with odd frequencies
        int[] frequency = new int[26]; // Array to store the frequency of each character
        for(char ch : s.toCharArray()){ 
            frequency[ch-'a']++; // Increment the frequency of the character
        }
        for(int freq : frequency){
            if(freq % 2 != 0){
                oddPairsCount++; // Count characters with odd frequencies
            }
        }
        if(oddPairsCount > k) return false; // If the number of odd frequency characters is greater than k, return false
        else return true; // Otherwise, return true
    }
}