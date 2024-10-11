import java.util.Arrays;
import java.util.PriorityQueue;

public class test {

    public static void main(String[] args) throws Exception {
        // Call the function and print out the result
        System.out.println(smallestChair(new int[][]{{1, 4}, {2, 3}, {4, 6}}, 1));
    }

    public static int smallestChair(int[][] times, int targetFriend) {
        // Find the arrival time of the target friend
        int target = times[targetFriend][0];

        // Sort the times array by arrival time
        // Note : remenber to import Arrays
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        // Create a priority queue to store the available chairs
        // Note : remenber to import PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            pq.offer(i);
        }

        // Create a priority queue to store the occupied chairs and their departure times + providing a function like a comparator property
        PriorityQueue<int[]> pqc = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < times.length; i++) {
            // Release occupied chairs whose departure time is before the current arrival time
            while (!pqc.isEmpty() && pqc.peek()[0] <= times[i][0]) {
                pq.offer(pqc.poll()[1]);
            }

            // If the current arrival time is the target friend's arrival time, return the smallest available chair
            if (times[i][0] == target) {
                break;
            }

            // Occupy the smallest available chair and add it to the occupied chairs queue
            pqc.offer(new int[] { times[i][1], pq.poll() });
        }

        // Return the smallest available chair
        return pq.peek();
    }

}