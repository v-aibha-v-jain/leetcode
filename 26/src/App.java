public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(obj.removeDuplicates(arr));
    }
}
class Solution {
    public int removeDuplicates(int[] arr) {
        int count=0;
        for(int i=1;i<arr.length;i++){
            if(arr[count]!=arr[i]){
                count++;
                arr[count]=arr[i];
            }
        }
        return count+1;   
    }
}