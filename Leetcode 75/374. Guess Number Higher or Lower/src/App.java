public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int n = 10;
        int result = solution.guessNumber(n);
        System.out.println("The guessed number is: " + result);
    }
}

// Define the GuessGame class with a guess method
class GuessGame {
    // Mock implementation of the guess method
    // Returns 0 if the guess is correct, -1 if the guess is too high, and 1 if the guess is too low
    public int guess(int num) {
        int pickedNumber = 6; // Example picked number
        if (num == pickedNumber) return 0;
        else if (num > pickedNumber) return -1;
        else return 1;
    }
}

class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1; // set the lower bound to 1
        int high = n; // set the upper bound to n
        while (low <= high) { // continue until the range is valid
            int mid = low + (high - low) / 2; // calculate the middle point to avoid overflow
            int result = guess(mid); // call the guess API with the middle point
            if (result == 0) return mid; // if the guess is correct, return the number
            else if (result < 0) high = mid - 1; // if the guess is too high, adjust the upper bound
            else low = mid + 1; // if the guess is too low, adjust the lower bound
        }
        return -1; // return -1 if no number is found (shouldn't happen in this problem)
    }
}