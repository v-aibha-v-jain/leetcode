import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String s = "ababccc";
        System.out.println(obj.maxUniqueSplit(s));
    }
}
class Solution {
    int maxCount;
    public int maxUniqueSplit(String s) {
        maxCount = 0;
        HashSet<String>set = new HashSet<>(); // to store the unique strings
        backtrack(s, set,0); // backtracking function
        return maxCount;
    }
    public void backtrack(String s, HashSet<String>set, int index){
        int n=s.length();
        if(index==n){ // if we reach the end of the string
            maxCount =Math.max(maxCount, set.size()); // update the maxCount
            return;
        }
        for(int i=index; i<n; i++){ 
            String sub = s.substring(index, i+1); // get the substring
            if(!set.contains(sub)){ // if the substring is not present in the set
                set.add(sub); // add the substring to the set
                backtrack(s,set,i+1); // recursive call
                set.remove(sub); // remove the substring from the set
            }
        }
    }
}