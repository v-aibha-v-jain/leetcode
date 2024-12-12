public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 2;
        ListNode result = obj.reverseKGroup(head, k);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode endN = head; // Initialize endN to head
        int count = 0; // Initialize count to 0
        while (endN != null) { // Traverse the list to count the number of nodes
            endN = endN.next; // Move to the next node
            count++; // Increment count
        }
        ListNode p = null; // Initialize p to null
        ListNode cur = head; // Initialize cur to head
        ListNode n = null; // Initialize n to null
        ListNode E = null; // Initialize E to null
        boolean first = true; // Initialize first to true
        for (int i = 0; i < (count / k); i++) { // Loop through the list in groups of k
            ListNode lastone = cur; // Save the current node as lastone
            int temp = 0; // Initialize temp to 0
            p = null; // Reset p to null
            while (temp < k) { // Reverse k nodes
            n = cur.next; // Save the next node
            cur.next = p; // Reverse the link
            p = cur; // Move p to the current node
            cur = n; // Move cur to the next node
            temp++; // Increment temp
            }
            if (first) { // If this is the first group
            head = p; // Set head to p
            first = false; // Set first to false
            } else {
            E.next = p; // Link the previous group to the current group
            }
            E = lastone; // Update E to the last node of the current group
        }
        E.next = cur; // Link the remaining nodes
        return head; // Return the new head
    }
}