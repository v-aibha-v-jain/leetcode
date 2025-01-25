import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        List<String> res = solution.generateParenthesis(3);
        for(String s: res){
            System.out.println(s);
        }
    }
}
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>(); // Initialize the result list
        solve(n, n, "", res); // Start the recursive function
        return res; // Return the result list
    }
    public void solve(int open, int closed, String output, List<String> res){
        if(open==0 && closed==0){ // If no more parentheses to add
            res.add(output); // Add the current output to the result list
            return;
        }
        if(open<0 || closed<0){ // If the count of open or closed parentheses is negative
            return; // Invalid state, return
        }
        if(open == closed){ // If the number of open and closed parentheses are the same
            solve(open-1, closed, output+"(", res); // Add an open parenthesis
        }else{
            solve(open-1, closed, output+"(", res); // Add an open parenthesis
            solve(open, closed-1, output+")", res); // Add a closed parenthesis
        }
    }
}