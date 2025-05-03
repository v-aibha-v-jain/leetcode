public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] tops = {2, 1, 2, 4, 2, 2};
        int[] bottoms = {5, 2, 6, 2, 3, 2};
        int result = solution.minDominoRotations(tops, bottoms);
        System.out.println(result);
    }
}
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length; // length of the domino arrays
        int res = check(tops, bottoms, tops[0], n); // check rotations for the first value in tops
        if (res != -1 || tops[0] == bottoms[0]) return res; // return result if valid or both rows start with the same value
        return check(tops, bottoms, bottoms[0], n); // otherwise, check rotations for the first value in bottoms
    }
    public int check(int[] tops, int[] bottoms, int target, int n) {
        int top = 0, bot = 0; // counters for rotations needed in tops and bottoms
        for (int i = 0; i < n; i++) {
            if (target != tops[i] && target != bottoms[i]) return -1; // if target is not in either row, return -1
            else if (target != tops[i]) top++; // increment top counter if target is not in tops
            else if (target != bottoms[i]) bot++; // increment bottom counter if target is not in bottoms
        }
        return Math.min(top, bot); // return the minimum rotations needed
    }
}