public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k =2;
        ListNode res = obj.rotateRight(head, k);
        while(res != null){
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head; // if the list is empty, return the head
        int len = 0; // initialize length of the list
        ListNode n = head; // initialize a pointer to traverse the list
        while(n != null){
            n = n.next; // move to the next node
            len++; // increment the length of the list
        }
        if(k == len || head == null) return head; // if k is equal to the length of the list or the list is empty, return the head
        if(k > len) k %= len; // if k is greater than the length of the list, take modulo to get the effective rotations
        ListNode s = head, f = head; // initialize two pointers, slow and fast
        for(int i = 1; i<len-k; i++) s = s.next; // move the slow pointer to the (len-k)th node
        for(int i = 1; i<len; i++) f = f.next; // move the fast pointer to the last node

        f.next = head; // link the last node to the head to form a circular list
        head = s.next; // update the head to the (len-k+1)th node
        s.next = null; // break the circular list to form the new list

        return head; // return the new head of the rotated list
    }
}