public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String dominoes = "RR.L";
        String result = solution.pushDominoes(dominoes);
        System.out.println(result);
    }
}
class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length(); // length of the dominoes string
        char[] arr = dominoes.toCharArray(); // convert string to character array
        int[] forces = new int[n]; // array to store net forces on each domino

        int force = 0; // initialize force to 0
        for (int i = 0; i < n; i++) { // traverse from left to right
            if (arr[i] == 'R') force = n; // apply maximum force for 'R'
            else if (arr[i] == 'L') force = 0; // reset force for 'L'
            else force = Math.max(force - 1, 0); // decrease force gradually
            forces[i] += force; // add force to the current domino
        }

        force = 0; // reset force for right-to-left traversal
        for (int i = n - 1; i >= 0; i--) { // traverse from right to left
            if (arr[i] == 'L') force = n; // apply maximum force for 'L'
            else if (arr[i] == 'R') force = 0; // reset force for 'R'
            else force = Math.max(force - 1, 0); // decrease force gradually
            forces[i] -= force; // subtract force from the current domino
        }

        StringBuilder result = new StringBuilder(); // to build the result string
        for (int f : forces) { // determine the final state of each domino
            if (f > 0) result.append('R'); // positive force means 'R'
            else if (f < 0) result.append('L'); // negative force means 'L'
            else result.append('.'); // zero force means '.'
        }

        return result.toString(); // return the final dominoes state
    }
}