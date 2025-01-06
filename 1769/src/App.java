import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String boxes = "110";
        int[] ans = obj.minOperations(boxes);
        for(int i : ans) {
            System.out.print(i + " ");
        }
    }
}
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length(); // get the length of the string
        int[] ans = new int[n]; // initialize the answer array
        HashSet<Integer> idx = new HashSet<>(); // create a set to store indices of '1's
        for(int i = 0; i < n; i++) {
            if(boxes.charAt(i) == '1') {
                idx.add(i); // add index to set if character is '1'
            }
        }
        for(int i = 0; i < n; i++) {
            int op = 0; // initialize operations count for current index
            for(int j : idx) {
                if(i != j) {
                    op += Math.abs(i - j); // calculate distance and add to operations count
                }
            }
            ans[i] = op; // store the operations count in the answer array
        }
        return ans; // return the answer array
    }
}