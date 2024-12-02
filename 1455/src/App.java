public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String sentence = "i love eating burger";
        String prefix = "burg";
        System.out.println(obj.isPrefixOfWord(sentence, prefix));
    }
}
class Solution {
    public int isPrefixOfWord(String sen, String ptr) {
        String str[] = sen.split(" "); // split the sentence into words
        int n = str.length; // get the number of words
        int m = ptr.length(); // get the length of the prefix
        for (int i = 0; i < n; i++) { // iterate through each word
            if (str[i].length() >= m && str[i].substring(0, m).equals(ptr)) { // check if the word starts with the prefix
            return i + 1; // return the 1-based index of the word
            }
        }
        return -1; // return -1 if no word starts with the prefix
    }
}