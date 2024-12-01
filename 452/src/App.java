import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(obj.findMinArrowShots(points));
    }
}
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1])); // sort points by the end coordinate
        int shot = 1; // initialize the number of shots to 1
        int aimPoint = points[0][1]; // set the initial aim point to the end of the first balloon
        for(int i=1; i<points.length; i++){ // iterate through the points
            if(points[i][0] > aimPoint){ // if the start of the current balloon is greater than the aim point
                shot++; // increment the number of shots
                aimPoint = points[i][1]; // update the aim point to the end of the current balloon
            }
        }
        return shot; // return the total number of shots needed
    }
}