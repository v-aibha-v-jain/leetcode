public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(obj.canCompleteCircuit(gas, cost));
    }
}
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumCost = 0;
        for (int c : cost) { // sum of all costs
            sumCost += c;
        }
        int sumGas = 0;
        for (int g : gas) { // sum of all gas
            sumGas += g;
        }
        if (sumCost > sumGas) { // if sum of all costs is greater than sum of all gas, return -1
            return -1;
        }
        int currentGas = 0;
        int startingIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i]; // calculate the current gas
            if (currentGas < 0) { // if current gas is less than 0, reset the current gas and update the starting index
                currentGas = 0;
                startingIndex = i + 1;
            }
        }
        return startingIndex;
    }
}