public class App {
    public static void main(String[] args) throws Exception {
        Solution obj=new Solution();
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        obj.merge(nums1,3,nums2,3);
        for(int i=0;i<nums1.length;i++){
            System.out.print(nums1[i]+" ");
        }
    }
}
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(j>=0){
            if(i>=0 && nums1[i]>nums2[j]){
                nums1[k]=nums1[i];
                k--;
                i--;
            }
            else{
               nums1[k]=nums2[j];
               k--;
               j--;
            }
        }
    }
}