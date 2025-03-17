public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(solution.compress(chars));
    }
}
class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder(); // to build the compressed string
        int count = 0; // to count occurrences of a character
        char a = chars[0]; // initialize with the first character
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == a) count++; // when current char equals 'a', increase count
            else {
                if (count > 1) sb.append(a + "" + count); // append char and count if count > 1
                else sb.append(a); // append only the char if count is 1
                a = chars[i]; // update 'a' to the current char
                count = 1; // reset count to 1
            }
        }
        if (count > 1) sb.append(a + "" + count); // handle the last group if count > 1
        else sb.append(a); // handle the last group if count is 1
        String r = sb.toString(); // convert StringBuilder to string
        for (int i = 0; i < r.length(); i++) {
            chars[i] = r.charAt(i); // update the original array with compressed string
        }
        return r.length(); // return the length of the compressed string
    }
}