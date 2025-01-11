import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        List<List<String>> equations = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("b", "c")
        );
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
            Arrays.asList("a", "c"),
            Arrays.asList("b", "a"),
            Arrays.asList("a", "e"),
            Arrays.asList("a", "a"),
            Arrays.asList("x", "x")
        );
        double[] results = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(results));
    }
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> database = new ConcurrentHashMap<>(); // stores the equations and their values
        Map<String, Set<String>> visited = new HashMap<>(); // keeps track of visited nodes
        for (int i = 0; i < equations.size(); i++) {
            List<String> operands = equations.get(i); // get the operands for the current equation
            dfs(database, operands.get(0), operands.get(1), values[i], visited); // perform depth-first search to populate the database
        }
        double[] result = new double[queries.size()]; // array to store the results of the queries
        int r = 0;
        for (List<String> query: queries) {
            if (database.containsKey(query.get(0)) && database.get(query.get(0)).containsKey(query.get(1))) {
                result[r] = database.get(query.get(0)).get(query.get(1)); // if the query exists in the database, get the value
            } else {
                result[r] = -1; // if the query does not exist, return -1
            }
            r++;
        }
        return result;
        }

        private void dfs(Map<String, Map<String, Double>> database, String operand1, String operand2, double value, Map<String, Set<String>> visited) {
        visited.computeIfAbsent(operand1, VOID -> new HashSet()).add(operand2); // mark operand2 as visited from operand1
        visited.computeIfAbsent(operand2, VOID -> new HashSet()).add(operand1); // mark operand1 as visited from operand2
        database.computeIfAbsent(operand1, VOID -> new HashMap()).put(operand2, value); // store the value of operand1 / operand2
        database.computeIfAbsent(operand2, VOID -> new HashMap()).put(operand1, 1 / value); // store the value of operand2 / operand1
        Set<String> newSet = new HashSet<>(database.get(operand1).keySet()); // get all connected nodes to operand1
        for (String operand3: newSet) {
            if (!visited.get(operand2).contains(operand3)) { 
                dfs(database, operand2, operand3, database.get(operand1).get(operand3) / value, visited); // recursively visit connected nodes
            }
        }
        newSet = new HashSet<>(database.get(operand2).keySet()); // get all connected nodes to operand2
        for (String operand4: newSet) {
            if (!visited.get(operand1).contains(operand4)) { 
                dfs(database, operand1, operand4, value * database.get(operand2).get(operand4), visited); // recursively visit connected nodes
            }
        }
    }
}