public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        System.out.println(obj.isIsomorphic("egg", "add")); // true
        System.out.println(obj.isIsomorphic("foo", "bar")); // false
    }
}
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length(); // get the length of the strings
        int[] slist = new int[256]; // create an array to store mappings for s
        int[] tlist = new int[256]; // create an array to store mappings for t
        for(int i = 0; i < n; i++) { // iterate through each character in the strings
            char sChar = s.charAt(i); // get the current character from s
            char tChar = t.charAt(i); // get the current character from t
            if(slist[sChar] == 0 && tlist[tChar] == 0) { // if both characters are not mapped yet
                slist[sChar] = tChar; // map sChar to tChar
                tlist[tChar] = sChar; // map tChar to sChar
            } else if(slist[sChar] != tChar || tlist[tChar] != sChar) // if the current mapping does not match
                return false; // return false as the strings are not isomorphic
        }
        return true;
    }
}
