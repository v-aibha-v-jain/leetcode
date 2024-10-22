public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        System.out.println(obj.intToRoman(3749));
    }
}
class Solution {
    public String intToRoman(int num) {
        // 0th index is empty string
        // Storing all the possible values of particular digit in arrays
        String ones[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String hunds[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String ths[]= {"", "M", "MM", "MMM"}; // since num >= 3999, no need to include 4000
        // Dividing the number into 4 parts and getting the respective values from the arrays
        return ths[num/1000] + hunds[(num%1000)/100] + tens[(num%100)/10] + ones[num%10];
    }
}