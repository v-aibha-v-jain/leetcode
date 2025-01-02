import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        int[] result = solution.vowelStrings(words, queries);
        for (int res : result) {
            System.out.println(res);
        }
    }
}
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length; // number of queries
        int m = words.length; // number of words
        Set<Character> set = new HashSet<>(); // set to store vowels
        set.add('a'); // add 'a' to set
        set.add('e'); // add 'e' to set
        set.add('i'); // add 'i' to set
        set.add('o'); // add 'o' to set
        set.add('u'); // add 'u' to set
        int[] prefix = new int[m+1]; // prefix array to store counts of valid words
        for(int i=0;i<m;i++){ // iterate over words
            String w = words[i]; // current word
            char fs = w.charAt(0); // first character of word
            char ls = w.charAt(w.length()-1); // last character of word
            if(set.contains(fs) && set.contains(ls)){ // check if both first and last characters are vowels
            prefix[i+1] = prefix[i] + 1; // increment prefix count
            }else{
            prefix[i+1] = prefix[i]; // carry forward previous count
            }
        }
        int[] res = new int[n]; // result array to store answers for queries
        for(int i=0;i<n;i++){ // iterate over queries
            int left = queries[i][0]; // left index of query
            int right = queries[i][1]; // right index of query
            res[i] = prefix[right+1] - prefix[left]; // calculate result for current query
        }
        return res; // return result array
    }
}