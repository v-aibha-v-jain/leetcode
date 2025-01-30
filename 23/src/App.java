import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] lists = {l1,l2,l3};
        ListNode ans = obj.mergeKLists(lists);
        while(ans!=null){
            System.out.print(ans.val+" ");
            ans = ans.next;
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }else if(lists.length==1){
            return lists[0];
        }
        PriorityQueue<ListNode> pq =new PriorityQueue<>((a,b)-> a.val-b.val);
        for(int i = 0;i<lists.length;i++){
            ListNode temphead = lists[i];
            while(temphead!=null){
                pq.add(temphead);
                temphead=temphead.next;
            }
        }    
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy ;
        while(pq.size()>0){
            ListNode node = pq.remove();
            dummy.next = node ;
            dummy = dummy.next;
        }
        dummy.next = null;
        return ans.next;
    }
}