public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] ratings = {1,0,2};
        System.out.println(obj.candy(ratings));
    }
}
class Solution {
    public int candy(int[] ratings) {
        // int pos=0;
        // int val = ratings[0];
        // int n = ratings.length;
        // for(int i=1; i<n;i++){
        //     if(ratings[i]<ratings[i-1]){
        //         pos = i;
        //         val = ratings[i];
        //     }
        // }
        // int candy = 1;
        // int candy_count = 1;
        // for(int i = pos-1; i>=0; i--){
        //     if(ratings[i]>ratings[i+1]){
        //         candy++;
        //         candy_count += candy;
        //     }else{
        //         candy_count++;
        //         candy = 1;
        //     }
        // }
        // candy = 1;
        // for(int i = pos+1; i<n; i++){
        //     if(ratings[i]>ratings[i-1]){
        //         candy++;
        //         candy_count += candy;
        //     }else{
        //         candy_count++;
        //         candy = 1;
        //     }
        // }
        int n = ratings.length;
        int[] candy = new int[n];
        for(int i=0;i<n;i++){
            candy[i] = 1;
        }
        for(int i=1; i<n;i++){
            if(ratings[i] > ratings[i-1]){
                candy[i] = candy[i-1] + 1;
            }
        }
        for(int i = n-2; i>=0; i--){
            if(ratings[i]> ratings[i+1]){
                candy[i] = Math.max(candy[i], candy[i+1] +1);
            }
        }
        int total = 0;
        for(int candy_count : candy){
            total += candy_count;
        }
        return total;
    }
}