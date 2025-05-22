import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        int[] nums = {2,0,2};
        int[][] queries = {{0,2},{0,2},{1,1}};
        int result = sol.maxRemoval(nums, queries);
        System.out.println(result);
    }
}
class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length; // length of nums array
        int nq = queries.length; // number of queries
        Arrays.sort(queries, (a,b) -> a[0]-b[0]); // sort queries by start index
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder()); // max-heap for end indices
        int[] dif = new int[n+1]; // difference array for range updates
        int cur = 0; // current increment applied
        int j = 0; // pointer for queries
        for(int i = 0; i<n; i++){
            cur -= dif[i]; // remove expired increments
            while( j<nq && queries[j][0] <= i ){
            heap.offer(queries[j][1]); // add query end to heap if it starts at or before i
            j++;
            }
            while(cur<nums[i]){
            if(heap.isEmpty() || heap.peek()<i) return -1; // no valid query to use
            dif[heap.poll()+1]++; // schedule removal of increment after query end
            cur++; // apply increment
            }
        }
        return heap.size(); // return number of unused queries
    }
}