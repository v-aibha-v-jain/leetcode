public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] arr = {10,2,5,3};
        System.out.println(obj.checkIfExist(arr));
    }
}
class Solution {
    public boolean checkIfExist(int[] arr) {
        boolean ans = false;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(i==j) continue;
                if(arr[i] == 2*arr[j]) ans = true;
            }
       }
       return ans; 
    }
}