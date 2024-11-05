public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String s = "0100";
        System.out.println(obj.minChanges(s));
    }
}
class Solution {
    public int minChanges(String s) {
        int count = 0;
        int i = 0;
        while(i<s.length()){
            if(s.charAt(i)!=s.charAt(i+1)){ // if the two characters are different
                count++; // increment the count
            }
            i += 2; // and then move to the next pair of characters
        }
        return count;
    }
}