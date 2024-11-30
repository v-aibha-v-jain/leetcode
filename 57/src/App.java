import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        int[][] result = obj.insert(intervals, newInterval);
        for(int i=0;i<result.length;i++){
            System.out.print("["+result[i][0]+","+result[i][1]+"] ");
        }
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(); // create a list to store the merged intervals
        int start = newInterval[0]; // start of the new interval
        int end = newInterval[1]; // end of the new interval
        boolean inserted = false; // flag to check if the new interval is inserted
        for(int i=0; i<intervals.length;i++){ // iterate through each interval
            if(intervals[i][1] < newInterval[0]){ // if the current interval ends before the new interval starts
                list.add(intervals[i]); // add the current interval to the list
                continue; // continue to the next interval
            }
            if(intervals[i][0] > newInterval[1]){ // if the current interval starts after the new interval ends
                if(!inserted){ // if the new interval is not inserted yet
                    inserted = true; // set the inserted flag to true
                    list.add(new int[]{start,end}); // add the new interval to the list
                }
                list.add(intervals[i]); // add the current interval to the list
                continue; // continue to the next interval
            }
            if(intervals[i][0] <= newInterval[0]) // if the current interval starts before or at the same time as the new interval
                start = intervals[i][0]; // update the start of the new interval
            if(intervals[i][1] >= newInterval[1]) // if the current interval ends after or at the same time as the new interval
                end = intervals[i][1]; // update the end of the new interval
        }
        if(!inserted) // if the new interval is not inserted yet
            list.add(new int[]{start,end}); // add the new interval to the list
        return list.toArray(new int[0][]); // convert the list to an array and return it
    }
}