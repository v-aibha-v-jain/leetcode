import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        for (List<String> list : result) {
            System.out.println(list);
        }
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>(); // create a hashmap to store sorted strings and their anagrams
        List<List<String>> ans = new ArrayList<>(); // create a list to store the final groups of anagrams
        for (String str : strs) { // iterate through each string in the input array
            char[] charr = str.toCharArray(); // convert the string to a character array
            Arrays.sort(charr); // sort the character array
            String sortedStr = new String(charr); // convert the sorted character array back to a string
            if (map.containsKey(sortedStr)) { // check if the sorted string is already a key in the hashmap
                List<String> list = map.get(sortedStr); // get the list of anagrams for the sorted string
                list.add(str); // add the original string to the list of anagrams
                map.put(sortedStr, list); // update the hashmap with the new list of anagrams
            } else { // if the sorted string is not a key in the hashmap
                List<String> list = new ArrayList<>(); // create a new list to store anagrams
                list.add(str); // add the original string to the new list
                map.put(sortedStr, list); // add the sorted string and the new list to the hashmap
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) { // iterate through each entry in the hashmap
            List<String> list = entry.getValue(); // get the list of anagrams for each sorted string
            ans.add(list); // add the list of anagrams to the final answer
        }
        return ans; // return the final list of groups of anagrams
    }
}