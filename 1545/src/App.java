public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        System.out.println(obj.findKthBit(3, 1));
    }
}
class Solution {
    public char findKthBit(int n, int k) { 
        String s = "0";
        while(--n > 0) {
            s = s + "1" + rev_inv(s); // append 1 and inverted reverse of s
        }
        return s.charAt(k - 1);
    }
    private String rev_inv(String str) {
        char[] arr = str.toCharArray(); // convert string to char array
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == '0') ? '1' : '0'; // invert
        }
        for(int i = 0; i <= arr.length / 2; i++) {  // reverse
            char temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return new String(arr);
    }
}