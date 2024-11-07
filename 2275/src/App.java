public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] candidates = {16,17,71,62,12,24,14};
        System.out.println(solution.largestCombination(candidates));
    }
}
class Solution {
    public int largestCombination(int[] candidates) {
        int max = 0;
        for(int i=0; i<=24; i++){
            int setBits = 0; // count the number of set bits at i-th position
            for(int c : candidates){
                setBits += (c>>i) & 1; // check if i-th bit is set
            }
            max = Math.max(setBits, max);
        }
        return max;
    }
}