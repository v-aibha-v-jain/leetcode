import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int left = 10, right = 19;
        int[] result = solution.closestPrimes(left, right);
        System.out.println("The closest prime numbers to " + left + " and " + right + " are " + result[0] + " and " + result[1]);
    }
}

class Solution {
    private boolean[] sieve(int n) {
        boolean[] prime = new boolean[n + 1]; // create a boolean array to mark prime numbers
        Arrays.fill(prime, true); // assume all numbers are prime initially
        prime[0] = prime[1] = false; // 0 and 1 are not prime numbers
        for (int i = 2; i * i <= n; i++) // iterate from 2 to sqrt(n)
            if (prime[i]) // if i is a prime number
                for (int j = i * i; j <= n; j += i) // mark all multiples of i as non-prime
                    prime[j] = false;
        return prime; // return the array of prime markers
    }

    public int[] closestPrimes(int left, int right) {
        boolean prime[] = sieve(right); // get the prime markers up to 'right'
        int num1 = -1, num2 = -1; // initialize the closest prime pair
        int prev = -1; // previous prime number
        for (int i = left; i <= right; i++) { // iterate from 'left' to 'right'
            if (prime[i]) { // if i is a prime number
                if (prev == -1) prev = i; // if this is the first prime, set prev to i
                else {
                    if (num1 == -1 || i - prev < num2 - num1) { // if this pair is closer than the previous pair
                        num1 = prev; // update the closest pair
                        num2 = i;
                    }
                    prev = i; // update prev to the current prime
                }
            }
        }
        return (num1 == -1 || num2 == -1) ? new int[]{-1, -1} : new int[]{num1, num2}; // return the closest pair or [-1, -1] if no pair found
    }
}