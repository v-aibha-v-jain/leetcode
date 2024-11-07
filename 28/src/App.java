public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String haystack = "sadbutsad", needle = "sad";
        System.out.println(obj.strStr(haystack, needle));
    }
}
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++)
            if (haystack.substring(i, i + needle.length()).equals(needle)) 
                return i;
        return -1;
    }
}