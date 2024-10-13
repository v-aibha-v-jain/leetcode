import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class App {

    public int[] smallestRange(List<List<Integer>> nums) {
        // Keep index of every element using a TreeMap for sorted keys
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int n : nums.get(i)) {
                map.computeIfAbsent(n, k -> new ArrayList<>()).add(i);
            }
        }

        // Create a sorted list of all unique elements
        List<Integer> list = new ArrayList<>(map.keySet());

        // Sliding window approach
        int l = 0, r = 0;
        int[] ans = new int[]{list.get(0), list.get(list.size() - 1)};
        int[] cnt = new int[nums.size()];
        while (l < list.size()) {
            // Move the right pointer until all elements are included
            while (r < list.size() && !allIn(cnt)) {
                for (int m : map.get(list.get(r))) {
                    cnt[m]++;
                }
                r++;
            }

            // If all elements are included and the current range is smaller, update the answer
            if (allIn(cnt) && (list.get(r - 1) - list.get(l)) < (ans[1] - ans[0])) {
                ans = new int[]{list.get(l), list.get(r - 1)};
            }

            // Move the left pointer until the current element is no longer needed
            for (int m : map.get(list.get(l))) {
                cnt[m]--;
            }
            l++;
        }

        return ans;
    }

    private boolean allIn(int[] cnt) {
        for (int c : cnt) {
            if (c == 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) throws Exception {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));

        App solution = new App();
        int[] smallestRange = solution.smallestRange(nums);
        System.out.println("Smallest range: [" + smallestRange[0] + ", " + smallestRange[1] + "]");
    }
}
