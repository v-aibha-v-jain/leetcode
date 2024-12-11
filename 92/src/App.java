import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);    
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int left = 2, right = 4;
        ListNode result = solution.reverseBetween(head, left, right);
        while(result != null){
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head; // if left equals right, no need to reverse
        List<Integer> values = new ArrayList<>(); // create a list to store node values
        ListNode temp = head; // temporary node to traverse the list
        while(temp != null){
            values.add(temp.val); // add node value to the list
            temp = temp.next; // move to the next node
        }
        int size = right - left + 1; // size of the sublist to reverse
        int[] arr = new int[size]; // array to store reversed values
        int j = -1; // index for the array
        for(int i = right - 1; i >= left -1; i--){
            arr[++j] = values.get(i); // fill the array with reversed values
        }
        j = -1; // reset index for the array
        for(int i = left - 1; i <= right -1; i++){
            values.set(i,arr[++j]); // set the reversed values back to the list
        }
        temp = head; // reset temporary node to head
        j = -1; // reset index for the list
        while(temp != null){
            temp.val = values.get(++j); // update node values with reversed values
            temp = temp.next; // move to the next node
        }
        return head; // return the modified list
    }
}