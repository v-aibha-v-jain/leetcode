public class App {
    public static void main(String[] args) throws Exception {
        int[] nums = {1,2,3,4};
        Solution obj = new Solution();
        int[] result = obj.productExceptSelf(nums);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = 1; // initialize answer array with 1
        }
        int left = 1;
        for (int i = 0; i < nums.length; i++) { // calculate left product
            answer[i] *= left;
            left *= nums[i];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) { // calculate right product
            answer[i] *= right;
            right *= nums[i];
        }
        return answer;
    }
}
// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int[] answer = new int[nums.length];
//         for(int i=0; i<nums.length; i++){
//             answer[i] = 1;
//             for(int j=0; j<nums.length; j++){
//                 if(i!=j){
//                     answer[i] *= nums[j];
//                 }
//             }
//         }
//         return answer;
//     }
// }