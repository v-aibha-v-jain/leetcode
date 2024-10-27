public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(obj.maxArea(height));
    }
}
// class Solution {
//     public int maxArea(int[] height) {
//         int max = 0;
//         for(int i=0; i<height.length; i++){
//             for(int j=i+1; j<height.length; j++){
//                 if(max < ( (j-i) * (Math.min(height[i], height[j])) ) ){
//                     max = ( (j-i) * (Math.min(height[i], height[j])) );
//                 }
//             }
//         }
//         return max;
//     }
// }
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right])); // Calculate the area and update the max
            if (height[left] < height[right]) { // Move the pointer which has the smaller height
                left++;
            } else {
                right--;
            }
        }
        return max;        
    }
}