public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        System.out.println(obj.checkPowersOfThree(12));
    }
}
class Solution {
    public boolean checkPowersOfThree(int n) {
        while(n > 0){
            if(n % 3 == 2) return false;
            n/=3;
        }
        return true;
    }
}