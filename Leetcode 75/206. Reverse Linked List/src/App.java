public class App {
    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversedHead = s.reverseList(head);
        while (reversedHead != null) {
            System.out.print(reversedHead.val + " ");
            reversedHead = reversedHead.next;
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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // Initialize previous node as null
        ListNode curr = head; // Start with the head of the list
        while (curr != null) { // Traverse the list until the end
            ListNode temp = curr.next; // Store the next node
            curr.next = prev; // Reverse the current node's pointer
            prev = curr; // Move the previous pointer to the current node
            curr = temp; // Move to the next node in the list
        }
        return prev; // Return the new head of the reversed list
    }
}