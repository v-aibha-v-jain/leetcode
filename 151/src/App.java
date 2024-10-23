public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String s = "  hello world  ";
        String result = solution.reverseWords(s);
        System.out.println(result);
    }
}
class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+"); // Split the string by whitespace
        StringBuilder rev = new StringBuilder(); // Create a StringBuilder object
        for(int i = words.length - 1; i >= 0; i--){ // Iterate over the words in reverse order and append them to the StringBuilder
            rev.append(words[i]);
            if(i != 0){
                rev.append(" ");
            }
        }
        return rev.toString(); // Convert StringBuilder to string and return
    }
}
