public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++)
			for (int j = i+1; j < nums.length; j++)
				if (nums[i] + nums[j] == target)
					return new int[]{i ,j};
        return new int[] {};
    }
}