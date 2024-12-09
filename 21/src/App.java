public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode result = obj.mergeTwoLists(l1, l2);
        while(result != null){
            System.out.println(result.val);
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) // if both lists are null, return null
            return null;
        ListNode head= new ListNode(0); // create a dummy node to form the new list
        ListNode curr= head; // current node starts at the dummy node
        while(list1 != null && list2 != null){ // iterate while both lists are not null
            if(list1.val <= list2.val){ // if value in list1 is less than or equal to value in list2
            curr.next=list1; // point current node's next to list1
            list1=list1.next; // move to the next node in list1
            }else{
            curr.next=list2; // point current node's next to list2
            list2=list2.next; // move to the next node in list2
            }
            curr=curr.next; // move to the next node in the merged list
        }
        curr.next=(list1 == null)? list2:list1; // append the remaining nodes of list1 or list2
        return head.next; // return the merged list, skipping the dummy node
    }
}