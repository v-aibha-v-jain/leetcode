public class App {

    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int maxOR = 0, maxBORCnt = 0; // maxOR = max Bitwise OR, maxBORCnt = count of max Bitwise OR
        int ss = (1 << n) - 1; // ss = subset size
        for(int i = 1; i <= ss ; i++){
            int currOR = 0; 
            for(int indx = 0; indx < n; indx++){
                if(((1 << indx) & i) != 0){ // check if the bit is set
                   currOR |= nums[indx]; // bitwise OR
                }
            }
            if(currOR == maxOR){ // if the current OR is equal to the max OR, increment the count
                maxBORCnt++;
            }else if(currOR > maxOR){ // if the current OR is greater than the max OR, update the max OR and reset the count
                maxOR = currOR;
                maxBORCnt = 1;
            }
        }
        return maxBORCnt;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        int[] nums = {3,2,1,5};
        System.out.println(app.countMaxOrSubsets(nums));
    }
}
