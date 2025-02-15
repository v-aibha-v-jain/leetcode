import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int n = 10;
        System.out.println(obj.punishmentNumber(n));
    }
}
class Solution {
    public int punishmentNumber(int n) {
        ArrayList<Integer> num = new ArrayList<>(Arrays.asList(1, 9, 10, 36, 45, 55, 82, 91, 99, 100, 235, 297, 369, 370, 379, 414, 657, 675, 703, 756, 792, 909, 918, 945, 964, 990, 991, 999, 1000)); // list of specific numbers
        int res = 0; // initialize result to 0
        for (int i = 0; i < num.size() && num.get(i) <= n; i++) { // iterate through the list while the number is less than or equal to n
            res += num.get(i) * num.get(i); // add the square of the number to the result
        }
        return res; // return the result
    }
}