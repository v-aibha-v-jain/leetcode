public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(obj.trap(height));
    }
}
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) { // if height is null or empty
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) { // if left height is less than right height
                if (height[left] >= leftMax) // if there is any bar greater than leftMax
                    leftMax = height[left]; // then set that bar as leftMax
                else
                    trappedWater += leftMax - height[left]; // else add the difference between leftMax and current height to trappedWater
                left++;
            } else { // if right height is less than left height
                if (height[right] >= rightMax) // if there is any bar greater than rightMax
                    rightMax = height[right]; // then set that bar as rightMax
                else
                    trappedWater += rightMax - height[right]; // else add the difference between rightMax and current height to trappedWater
                right--;
            }
        }
        return trappedWater;
    }
}
