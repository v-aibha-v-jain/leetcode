import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        ListNode head = new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1)))); // Create a linked list: 5 -> 4 -> 2 -> 1
        int result = sol.pairSum(head); // Call the method to find the maximum twin sum
        System.out.println("Maximum Twin Sum: " + result); // Print the result
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public int pairSum(ListNode head) {
        int n = 0; // Initialize the size of the linked list
        int max = 0; // Initialize the maximum twin sum
        List<Integer> arrlist = new ArrayList<>(); // Create a list to store node values
        ListNode node = head; // Start from the head of the linked list
        while(node != null) {
            n++; // Increment the size of the linked list
            arrlist.add(node.val); // Add the current node's value to the list
            node = node.next; // Move to the next node
        }
        for(int i = 0; i < (n / 2); i++) { // Iterate through the first half of the list
            max = Math.max(max, arrlist.get(i) + arrlist.get(n - i - 1)); // Calculate twin sum and update max
        }
        return max; // Return the maximum twin sum
    }
}