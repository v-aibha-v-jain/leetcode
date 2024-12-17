import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String s = "aaabbc";
        int repeatLimit = 2;
        String result = solution.repeatLimitedString(s, repeatLimit);
        System.out.println(result);
    }
}
class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26]; // frequency array for characters
        for (char c : s.toCharArray()) {
            freq[c - 'a']++; // count frequency of each character
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> b - a); // max heap to store characters by frequency
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
            maxHeap.add((char) (i + 'a')); // add characters to max heap
            }
        }
        StringBuilder result = new StringBuilder(); // result string
        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll(); // get character with highest frequency
            int count = Math.min(freq[current - 'a'], repeatLimit); // determine how many times to repeat the character
            for (int i = 0; i < count; i++) {
            result.append(current); // append character to result
            }
            freq[current - 'a'] -= count; // decrease frequency of the character
            if (freq[current - 'a'] > 0) {
            if (maxHeap.isEmpty()) {
                break; // if heap is empty, break
            }
            char next = maxHeap.poll(); // get next character with highest frequency
            result.append(next); // append next character to result
            freq[next - 'a']--; // decrease frequency of the next character
            if (freq[next - 'a'] > 0) {
                maxHeap.add(next); // add next character back to heap if it still has frequency left
            }
            maxHeap.add(current); // add current character back to heap
            }
        }
        return result.toString(); // return the result string
    }
}