import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        String[] words = {"e","a","b"};
        int[] groups = {0,0,1};
        List<String> result = sol.getLongestSubsequence(words, groups);
        System.out.println(result);
    }
}
class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>(); // list to store the result subsequence
        int lastgrp = -1; // keeps track of the last group used
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] != lastgrp) { // if current group is different from last
                lastgrp = groups[i]; // update last group
                ans.add(words[i]); // add current word to answer
            }
        }
        return ans; // return the result subsequence
    }
}