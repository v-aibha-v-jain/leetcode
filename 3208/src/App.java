public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] colors = {0,1,0,1,0};
        int k = 3;
        int result = solution.numberOfAlternatingGroups(colors, k);
        System.out.println(result);
    }
}
class Solution {
    public int numberOfAlternatingGroups(int[] col, int k) {
        int n = col.length; // length of the colors array
        int left = 0; // left boundary of the current group
        int count = 0; // count of alternating groups
        for(int i = 0; i < n + k - 1; i++) { // iterate through the array with wrap-around
            if(i > 0 && col[i % n] == col[(i - 1) % n]) left = i; // reset left if current color matches previous
            if(i - left + 1 >= k) count++; // if the current group length is at least k, increment count
        }
        return count; // return the total count of alternating groups
    }
}