public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int num1 = 3, num2 = 5;
        System.out.println(obj.minimizeXor(num1, num2));    
    }
}
class Solution {
    boolean isset(int x, int i) {
        return (x & (1 << i)) != 0; // check if the ith bit is set
    }

    int set(int x, int i) {
        return x | (1 << i); // set the ith bit
    }

    int unset(int x, int i) {
        return x & (~(1 << i)); // unset the ith bit
    }

    public int minimizeXor(int num1, int num2) {
        int req = 0;
        while (num2 > 0) {
            num2 = num2 & (num2 - 1); // count the number of set bits in num2
            req++;
        }

        int x = num1;
        int curr = 0;
        while (num1 > 0) {
            num1 = num1 & (num1 - 1); // count the number of set bits in num1
            curr++;
        }

        int idx = 0;
        if (curr < req) {
            while (curr < req) {
                if (!isset(x, idx)) {
                    x = set(x, idx); // set bits in x until it has the same number of set bits as num2
                    curr++;
                }
                idx++;
            }
        } else if (curr > req) {
            while (curr > req) {
                if (isset(x, idx)) {
                    x = unset(x, idx); // unset bits in x until it has the same number of set bits as num2
                    curr--;
                }
                idx++;
            }
        }
        return x; // return the modified number
    }
}