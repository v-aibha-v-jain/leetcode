import java.util.HashMap;
import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String s = "aeioqq";
        int k = 1;
        long result = obj.countOfSubstrings(s, k);
        System.out.println(result);
    }
}
class Solution {
    HashSet<Character> set = new HashSet<>();
    
    public long countOfSubstrings(String s, int k) {
        set.add('a'); // add vowel 'a' to set
        set.add('e'); // add vowel 'e' to set
        set.add('i'); // add vowel 'i' to set
        set.add('o'); // add vowel 'o' to set
        set.add('u'); // add vowel 'u' to set
        long a = get(s, k); // get count of substrings with k vowels
        long b = get(s, k + 1); // get count of substrings with k+1 vowels
        return a - b; // return the difference
    }

    public long get(String s, int k) {
        int i = 0;
        int j = 0;
        long ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int c = 0;
        while (i < s.length()) {
            char chi = s.charAt(i);
            if (set.contains(chi)) map.put(chi, map.getOrDefault(chi, 0) + 1); // add vowel to map
            else c++; // increment consonant count
            while (map.size() == 5 && c >= k) { // check if all vowels are present and consonant count is sufficient
                ans += (long) (s.length() - i); // add to answer
                char chj = s.charAt(j);
                if (set.contains(chj)) {
                    if (map.get(chj) == 1) map.remove(chj); // remove vowel from map
                    else map.put(chj, map.get(chj) - 1); // decrement vowel count in map
                } else c--; // decrement consonant count
                j++; // move start of window
            }
            i++; // move end of window
        }
        return ans; // return the count of valid substrings
    }
}