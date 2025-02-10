import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int k = 2;
        int w = 0;
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};
        System.out.println(solution.findMaximizedCapital(k, w, profits, capital));
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for(int i = 0; i < n; i++){
            projects[i] = new int[]{capital[i], profits[i]}; // create project array with capital and profit
        }
        Arrays.sort(projects, (a,b) -> Integer.compare(a[0], b[0])); // sort projects by capital required
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder()); // max heap for profits
        int i = 0;
        for(int j = 0; j < k; j++){
            while(i < n && projects[i][0] <= w){
                heap.add(projects[i][1]); // add project profit to heap if capital requirement is met
                i++;
            }
            if(heap.isEmpty()) break; // break if no projects can be funded
            w += heap.remove(); // add the highest profit project to available capital
        }
        return w; // return the maximized capital
    }
}