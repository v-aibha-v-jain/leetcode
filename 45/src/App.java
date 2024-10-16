public class App {

    public int jump(int[] nums) {
        int n = nums.length - 1;
        int l = 0;
        int r = 0;
        int jumps = 0;

        while (r < n) { // while we haven't reached the end
            int jr = r; // jump right
            for (int i = l; i <= r; i++) {
                jr = Math.max(jr, i + nums[i]); // find the farthest we can jump
            }
            l = r + 1;
            r = jr;
            jumps++;
        }

        return jumps;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        System.out.println(app.jump(new int[] {2, 3, 1, 1, 4}));
    }
}
