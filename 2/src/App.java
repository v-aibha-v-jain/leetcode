public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode res = solution.addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(); // Create a dummy node to form the result list
        ListNode res = dummy; // Pointer to the result list
        int total = 0; // Initialize total to 0
        int carry = 0; // Initialize carry to 0
        while (l1 != null || l2 != null || carry != 0) { // Loop until both lists are exhausted and no carry is left
            total = carry; // Start with carry from the previous iteration
            if (l1 != null) { // If l1 is not null
                total += l1.val; // Add l1's value to total
                l1 = l1.next; // Move to the next node in l1
            }
            if (l2 != null) { // If l2 is not null
                total += l2.val; // Add l2's value to total
                l2 = l2.next; // Move to the next node in l2
            }
            int num = total % 10; // Get the last digit of total
            carry = total / 10; // Update carry for the next iteration
            dummy.next = new ListNode(num); // Create a new node with the last digit and attach to the result list
            dummy = dummy.next; // Move to the next node in the result list
        }
        return res.next; // Return the result list, skipping the dummy node
    }
}