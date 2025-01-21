import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        List<List<Integer>> res = obj.combine(4, 2);
        for(List<Integer> l : res){
            for(int i : l){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
class Solution {
    public void solve(List<List<Integer>> l1,List<Integer> l2,int ind ,int n,int k){
        if(ind == n || l2.size() == k) { // if index reaches n or l2 size equals k
            if(!(l2.size() < k)) // if l2 size is not less than k
            l1.add(new ArrayList<>(l2)); // add a new list to l1
            return; // return from the function
        }
        l2.add(ind + 1); // choose the current index (1-based)
        solve(l1, l2, ind + 1, n, k); // recursive call with next index
        l2.remove(l2.size() - 1); // backtrack by removing the last element
        solve(l1, l2, ind + 1, n, k); // recursive call without choosing the current index
        }
        public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> l1 = new ArrayList<>(); // list to store combinations
        List<Integer> l2 = new ArrayList<>(); // temporary list to store current combination
        solve(l1, l2, 0, n, k); // start solving from index 0
        return l1; // return the list of combinations
    }
}