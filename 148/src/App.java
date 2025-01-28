public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        ListNode resHead = solution.sortList(head);
        while (resHead != null) {
            System.out.print(resHead.val + " ");
            resHead = resHead.next;
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head; // base case for recursion
        ListNode newHead = Divide(head); // divide the list and sort
        return newHead;
    }

    ListNode Divide(ListNode head) {
        if (head == null || head.next == null) return head; // base case for recursion
        ListNode slow = head; // slow pointer
        ListNode fast = head; // fast pointer
        ListNode prev = null; // previous pointer to disconnect the list

        while (fast != null && fast.next != null) {
            fast = fast.next.next; // move fast pointer by 2 steps
            prev = slow; // store the previous node
            slow = slow.next; // move slow pointer by 1 step
        }

        prev.next = null; // disconnect the list into two halves
        ListNode head1 = Divide(head); // recursively divide the first half
        ListNode head2 = Divide(slow); // recursively divide the second half
        ListNode resHead = Conquer(head1, head2); // merge the two sorted halves
        return resHead;
    }

    ListNode Conquer(ListNode h1, ListNode h2) {
        ListNode resHead = null; // head of the merged list
        ListNode ite = null; // iterator for the merged list

        while (h1 != null && h2 != null) {
            int temp;
            if (h1.val < h2.val) {
                temp = h1.val; // take value from h1
                h1 = h1.next; // move h1 to next node
            } else {
                temp = h2.val; // take value from h2
                h2 = h2.next; // move h2 to next node
            }

            if (ite == null) {
                ite = new ListNode(temp); // initialize the merged list
                resHead = ite; // set the head of the merged list
            } else {
                ite.next = new ListNode(temp); // add new node to the merged list
                ite = ite.next; // move iterator to next node
            }
        }

        while (h1 != null) {
            ite.next = new ListNode(h1.val); // add remaining nodes from h1
            ite = ite.next; // move iterator to next node
            h1 = h1.next; // move h1 to next node
        }

        while (h2 != null) {
            ite.next = new ListNode(h2.val); // add remaining nodes from h2
            ite = ite.next; // move iterator to next node
            h2 = h2.next; // move h2 to next node
        }

        return resHead; // return the head of the merged list
    }
}