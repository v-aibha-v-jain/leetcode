public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String s = "IceCreAm";
        System.out.println(solution.reverseVowels(s));
    }
}
class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s); // Create a mutable string representation of the input
        int left = 0; // Pointer starting from the beginning of the string
        int right = sb.length() - 1; // Pointer starting from the end of the string
        String vowels = "AEIOUaeiou"; // String containing all vowels (both uppercase and lowercase)
        while (left < right) { // Loop until the two pointers meet
            while (left < right && vowels.indexOf(sb.charAt(left)) == -1) left++; // Move left pointer until a vowel is found
            while (left < right && vowels.indexOf(sb.charAt(right)) == -1) right--; // Move right pointer until a vowel is found
            if (left < right) { // If valid vowels are found at both pointers
                char temp = sb.charAt(left); // Temporarily store the left vowel
                sb.setCharAt(left++, sb.charAt(right)); // Swap the right vowel to the left position and increment left pointer
                sb.setCharAt(right--, temp); // Swap the stored left vowel to the right position and decrement right pointer
            }
        }
        return sb.toString(); // Return the string with reversed vowels
    }
}