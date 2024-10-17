public class App {

    public int maximumSwap(int num) {
        char[] nums = Integer.toString(num).toCharArray(); // convert to char array
        for (int i = 0; i < nums.length; i++) {
            int ind = i;
            for (int j = nums.length - 1; j > i; j--) { // find the largest digit
                if (nums[ind] < nums[j]) {
                    ind = j; // store the index of the largest digit
                }
            }
            if (ind != i && nums[i] < nums[ind]) { // if the largest digit is not the current digit
                char temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                return Integer.parseInt(new String(nums)); // convert back to int
            }
        }
        return num;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        System.out.println(app.maximumSwap(50095649));
    }
}
