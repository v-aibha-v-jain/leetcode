public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        int x = 3;
        ListNode result = solution.partition(head, x);

        // Print the result list
        ListNode current = result;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
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
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return head; // if the head is null, return null
        }
        ListNode leftTail = new ListNode(-1); // dummy node for the left partition
        ListNode rightTail = new ListNode(-1); // dummy node for the right partition
        ListNode leftHead = leftTail; // head of the left partition
        ListNode rightHead = rightTail; // head of the right partition
        ListNode p = head; // pointer to traverse the list
        while(p != null){
            if(p.val < x){
            leftTail.next = p; // add node to the left partition
            leftTail = leftTail.next; // move the left partition tail
            } else{
            rightTail.next = p; // add node to the right partition
            rightTail = rightTail.next; // move the right partition tail
            }
            p = p.next; // move to the next node
        }
        leftTail.next = rightHead.next; // connect the left partition with the right partition
        rightTail.next = null; // end the list
        return leftHead.next; // return the head of the new partitioned list
    }
}