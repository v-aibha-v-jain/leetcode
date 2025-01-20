import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String digits = "23";
        List<String> result = solution.letterCombinations(digits);
        System.out.println(result);
    }
}
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) { // if the input string is empty
            return Collections.emptyList(); // return an empty list
        } else {
            Map<Character, String> keysCombination = Map.of(
                '1', "", // mapping for digit '1'
                '2', "abc", // mapping for digit '2'
                '3', "def", // mapping for digit '3'
                '4', "ghi", // mapping for digit '4'
                '5', "jkl", // mapping for digit '5'
                '6', "mno", // mapping for digit '6'
                '7', "pqrs", // mapping for digit '7'
                '8', "tuv", // mapping for digit '8'
                '9', "wxyz" // mapping for digit '9'
            );
            List<String> result = new ArrayList<String>();
            result.add(""); // Initial empty list
            for (char c : digits.toCharArray()) { // iterate over each digit
                List<String> temp = new ArrayList<>();
                for (char letter : keysCombination.get(c).toCharArray()) { // iterate over each letter mapped to the digit
                    for (String str : result) { // iterate over each string in the result list
                        temp.add(str + letter); // append the letter to each string and add to temp list
                    }
                }
                result = temp; // update result with the new combinations
            }
            return result; // return the final list of combinations
        }
    }
}
