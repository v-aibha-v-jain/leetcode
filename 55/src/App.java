public class App {

    public boolean canJump(int[] nums) {
        int lastindex = nums.length - 1; // Storing the index that has to be reached
        for (int i = nums.length - 2; i >= 0; i--) {
            if (lastindex <= i + nums[i]) { // Check if the current index can reach the last index
                lastindex = i;
            }
        }
        return lastindex == 0;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(app.canJump(nums));
    }
}
