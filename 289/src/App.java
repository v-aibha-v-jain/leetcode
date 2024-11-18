public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[][] arr = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        obj.gameOfLife(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }
}
class Solution {
    public void gameOfLife(int[][] arr) {
        int m = arr.length; // number of rows
        int n = arr[0].length; // number of columns
        int[][] sol = new int[m][n]; // solution array
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int dies=0; // count of dead neighbors
                int live = 0; // count of live neighbors
                if(i-1>=0){
                    if(arr[i-1][j]==0) dies++; // top neighbor is dead
                    else live++; // top neighbor is alive
                }
                if(j-1>=0){
                    if(arr[i][j-1]==0) dies++; // left neighbor is dead
                    else live++; // left neighbor is alive
                }
                if(i+1<m){
                    if(arr[i+1][j]==0) dies++; // bottom neighbor is dead
                    else live++; // bottom neighbor is alive
                }
                if(j+1<n){
                    if(arr[i][j+1]==0) dies++; // right neighbor is dead
                    else live++; // right neighbor is alive
                }
                if(i-1>=0 && j-1>=0){
                    if(arr[i-1][j-1]==0)dies++; // top-left neighbor is dead
                    else live++; // top-left neighbor is alive
                }
                if(i+1<m && j+1<n){
                    if(arr[i+1][j+1]==0) dies++; // bottom-right neighbor is dead
                    else live++; // bottom-right neighbor is alive
                }
                if(i-1>=0 && j+1<n){
                    if(arr[i-1][j+1]==0) dies++; // top-right neighbor is dead
                    else live++; // top-right neighbor is alive
                }
                if(i+1<m && j-1>=0){
                    if(arr[i+1][j-1]==0) dies++; // bottom-left neighbor is dead
                    else live++; // bottom-left neighbor is alive
                }
                if(arr[i][j]==1 &&  live<2) sol[i][j]=0; // live cell dies due to underpopulation
                else if(arr[i][j]==0 && live==3) sol[i][j]=1; // dead cell becomes live due to reproduction
                else if(arr[i][j]==1 && (live==2 || live==3)) sol[i][j]=1; // live cell stays alive
                else if(arr[i][j]==1 && live>3) sol[i][j]=0; // live cell dies due to overpopulation
            }
        }
        for(int i=0;i<sol.length;i++)
            for(int j=0;j<sol[0].length;j++)
                arr[i][j]=sol[i][j]; // update the original array with the solution
    }
}