import java.util.Map;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String s = "MCMXCIV";
        System.out.println(obj.romanToInt(s));
    }
}
class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>(); // store all the values of characters
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int ans=0;
        char curr,next;
        for(int i=0;i<s.length()-1;i++){
            curr =s.charAt(i); // current character
            next = s.charAt(i+1); // next character
            if(map.get(next)>map.get(curr)) // If value of char is less then the next char
                 ans -= map.get(curr); // then subtract that value
            else 
                 ans += map.get(curr); // else increase ans with that value
        }
        return ans+map.get(s.charAt(s.length()-1)); // Add the value of last character to ans and return
    }
}