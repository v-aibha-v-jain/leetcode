public class App {
    public static void main(String[] args) throws Exception {
        Solution obj=new Solution();
        int ar[]={1,2,3};
        int k=2;
        System.out.println(obj.minimumSubarrayLength(ar,k));
    }
}
class Solution {
    public int minimumSubarrayLength(int[] ar, int k) {
        int pa = 0; // start pointer
        int pb = 0; // end pointer
        int ans = Integer.MAX_VALUE; // to store the minimum length
        int or = 0; // to store the OR result of the subarray
        int n = ar.length; // length of the array
        int bitsArray[] = new int[100000]; // to count the bits in the subarray
        if (k == 0)
            return 1; // if k is 0, return 1

        while (pb >= pa) {
            int a = 0;
            if (or >= k) { // if OR result is greater than or equal to k
                ans = Math.min(ans, pb - pa); // update the minimum length
                a = ar[pa]; // get the element at start pointer
                for (int i = 0; i <= 31; i++) { // iterate through each bit
                    int bit = (a & (1 << i)) == 0 ? 0 : 1; // get the bit value
                    if (bit == 1) {
                        bitsArray[i]--; // decrement the bit count
                        if (bitsArray[i] == 0)
                            or = or ^ (1 << i); // update the OR result
                    }
                }
                pa++; // move the start pointer
            } else {
                if (pb == n)
                    break; // if end pointer reaches the end of array, break
                a = ar[pb]; // get the element at end pointer
                or = or | a; // update the OR result
                for (int i = 0; i <= 31; i++) { // iterate through each bit
                    int bit = (a & (1 << i)) == 0 ? 0 : 1; // get the bit value
                    if (bit == 1)
                        bitsArray[i]++; // increment the bit count
                }
                pb++; // move the end pointer
            }
        }
        if (ans == Integer.MAX_VALUE)
            return -1; // if no valid subarray found, return -1
        return ans; // return the minimum length
    }
}