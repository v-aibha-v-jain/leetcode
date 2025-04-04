public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = solution.oddEvenList(head);
        while(result != null) {
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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head; // return if list is empty or has only one node
        ListNode odd = head, even = head.next, evenHead = even; // initialize odd, even pointers and store even head
        while(even != null && even.next != null) { // iterate until even or its next is null
            odd.next = even.next; // link odd node to the next odd node
            odd = odd.next; // move odd pointer forward
            even.next = even.next.next; // link even node to the next even node
            even = even.next; // move even pointer forward
        }
        odd.next = evenHead; // connect the end of odd list to the head of even list
        return head; // return the modified list
    }
}