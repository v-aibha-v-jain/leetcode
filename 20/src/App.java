public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        System.out.println(obj.isValid("()")); // true
        System.out.println(obj.isValid("()[]{}")); // true
        System.out.println(obj.isValid("(]")); // false
        System.out.println(obj.isValid("([)]")); // false
    }
}
class Solution {
    public boolean isValid(String s) {
        while(true){
            if(s.contains("()")){
                s = s.replace("()", ""); // remove all occurrences of ()
            }
            else if(s.contains("[]")){
                s = s.replace("[]", ""); // remove all occurrences of []
            }
            else if(s.contains("{}")){
                s = s.replace("{}", ""); // remove all occurrences of {}
            }
            else{
                return s.isEmpty(); // check if the string is empty
            }
        }
    }
}