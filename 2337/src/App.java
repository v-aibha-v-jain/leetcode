public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String start = "_L__R__R_";
        String target = "L______RR";
        boolean answer = solution.canChange(start, target);
        System.out.println(answer);
    }
}
class Solution {
    public boolean canChange(String start, String target) {
        if (start.equals(target)) return true; // if start equals target, return true
        int waitL = 0; // counter for 'L' in target
        int waitR = 0; // counter for 'R' in start
        for (int i = 0; i < start.length(); i++) {
            char curr = start.charAt(i); // current character in start
            char goal = target.charAt(i); // corresponding character in target
            if (curr == 'R') {
                if (waitL > 0) return false; // if there are unmatched 'L's, return false
                waitR++; // increment waitR for 'R' in start
            }
            if (goal == 'L') {
                if (waitR > 0) return false; // if there are unmatched 'R's, return false
                waitL++; // increment waitL for 'L' in target
            }
            if (goal == 'R') {
                if (waitR == 0) return false; // if no unmatched 'R's, return false
                waitR--; // decrement waitR for matched 'R'
            }
            if (curr == 'L') {
                if (waitL == 0) return false; // if no unmatched 'L's, return false
                waitL--; // decrement waitL for matched 'L'
            }
        }
        return waitL == 0 && waitR == 0; // return true if all 'L' and 'R' are matched
    }
}