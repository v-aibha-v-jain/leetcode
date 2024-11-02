public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.isCircularSentence("leetcode exercises sound delightful"));
    }
}
class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" "); // split the sentence into words
        for(int i = 0; i < words.length - 1; i++)
            // check if the last character of the current word is equal to the first character of the next word
            if(words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0))
                return false;
        // check if the last character of the last word is equal to the first character of the first word
        if(words[0].charAt(0) != words[words.length - 1].charAt(words[words.length - 1].length() - 1)) 
            return false;
        return true;
    }
}