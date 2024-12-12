import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] gifts = {25,64,9,4,100};
        int k = 4;
        long res = solution.pickGifts(gifts, k);
        System.out.println(res);
    }
}
class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a); // max-heap to store gifts
        for(int gift : gifts){
            pq.add(gift); // add each gift to the priority queue
        }
        for(int i=0; i<k; i++){
            int max = pq.poll(); // get the largest gift
            int remaining = (int) Math.floor(Math.sqrt(max)); // calculate remaining gift value
            pq.add(remaining); // add the remaining value back to the queue
        }
        long res = 0;
        while(!pq.isEmpty()){
            res += pq.poll(); // sum up all remaining gifts
        }
        return res; // return the total remaining value
    }
}