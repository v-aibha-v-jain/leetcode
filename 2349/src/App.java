import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) throws Exception {
        NumberContainers obj = new NumberContainers();
        System.out.println(obj.find(10)); // Should print -1
        obj.change(2, 10);
        obj.change(1, 10);
        obj.change(3, 10);
        obj.change(5, 10);
        System.out.println(obj.find(10)); // Should print 1
        obj.change(1, 20);
        System.out.println(obj.find(10)); // Should print 2
    }
}
class NumberContainers {
    Map<Integer, Integer> indToNum; // Map to store index to number mapping
    Map<Integer, TreeSet<Integer>> cn; // Map to store number to indices mapping

    public NumberContainers() {
        indToNum = new HashMap<>(); // Initialize index to number map
        cn = new HashMap<>(); // Initialize number to indices map
    }

    public void change(int index, int number) {
        if (indToNum.containsKey(index)) { // Check if the index already exists
            int oldNum = indToNum.get(index); // Get the old number at the index
            if (oldNum != number) { // If the old number is different from the new number
                cn.get(oldNum).remove(index); // Remove the index from the old number's set
                if (cn.get(oldNum).isEmpty()) cn.remove(oldNum); // Remove the old number's entry if its set is empty
            }
        }
        if (cn.containsKey(number)) cn.get(number).add(index); // Add the index to the new number's set if it exists
        else {
            cn.put(number, new TreeSet<>()); // Create a new set for the new number
            cn.get(number).add(index); // Add the index to the new number's set
        }
        indToNum.put(index, number); // Update the index to number mapping
    }

    public int find(int number) {
        if (cn.containsKey(number)) return cn.get(number).first(); // Return the smallest index for the number if it exists
        return -1; // Return -1 if the number does not exist
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */