public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String str1 = "abc";
        String str2 = "ahbgdc";
        boolean result = solution.canMakeSubsequence(str1, str2);
        System.out.println(result);
    }
}
class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {       
        //get length once
        final int len1 =  str1.length(); // length of str1
        final int len2 =  str2.length(); // length of str2

        if (len1 < len2) { // if str1 is shorter than str2
            return false; // cannot make subsequence
        }

        int ptr1 = -1; // pointer for str1
        int ptr2 = -1; // pointer for str2
        final int base = (int)'a'; // base ASCII value for 'a'
        char next; // next character in sequence
        char current; // current character in str2
        char matching; // matching character in str1
        while (ptr1 < len1 && ptr2 < len2) { // while pointers are within bounds
            ptr1++; // increment pointer for str1
            ptr2++; // increment pointer for str2
            while (ptr1 < len1 && ptr2 < len2) { // while pointers are within bounds
            matching = str1.charAt(ptr1); // get character from str1
            current = str2.charAt(ptr2); // get character from str2
            next = (char)((matching - 'a' + 1) % 26 + base); // calculate next character in sequence
            if (current == matching || current == next) { // if characters match or are in sequence
                break; // break inner loop
            }
            ptr1++; // increment pointer for str1
            }
        }

        if (ptr1 == len1 && ptr2 < len2) { // if end of str1 is reached but not end of str2
            return false; // cannot make subsequence
        }

        return true; // subsequence can be made
    }
}