public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String word = "aaabbbccc";
        System.out.println(obj.compressedString(word));
    }
}
class Solution {
    public String compressedString(String word) {
        char c = word.charAt(0); // Start with the first character
        StringBuilder comp = new StringBuilder() ;
        int count = 0; // Count the number of times the character is repeated
        int n = word.length();
        for(int i =0;i<n; i++) {
            if(word.charAt(i) == c && count!=9) // If the character is repeated less than 9 times
                count ++; // Increment the count
            else{
                comp.append(String.valueOf(count)); // Append the count to the compressed string
                comp.append(c); // Append the character to the compressed string
                c = word.charAt(i); // Update the character
                count = 1; // Reset the count
            } 
        }
        comp.append(String.valueOf(count)); // Append the count of the last character
        comp.append(c); // Append the last character
        return comp.toString() ;
    }   
}