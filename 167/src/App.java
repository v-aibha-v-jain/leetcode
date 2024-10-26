public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] res = obj.twoSum(numbers, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] pos = new int[2]; // to store the positions of the two numbers
        int n = numbers.length; 
        int rem = target; // to store the second number
        for(int i = 0; i<n-1;i++){
            rem = target - numbers[i]; // to find the second number
            pos[0] = i+1; // to store the position of the first number
            for(int j=i+1; j<n; j++){
                if(numbers[j] == rem){ // if the second number is found
                    pos[1] = j+1; // store the position of the second number
                    return pos;
                }
            }
        }
        return pos;
    }
}