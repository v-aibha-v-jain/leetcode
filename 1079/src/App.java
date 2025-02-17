import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String tiles = "AAB";
        System.out.println(obj.numTilePossibilities(tiles));
    }
}
class Solution {
    public int numTilePossibilities(String tiles) {
        HashMap<Character, Integer> mp = new HashMap<>(); // Create a map to store the frequency of each character
        int len = tiles.length(); // Get the length of the input string
        for(int i = 0; i < len; i++) // Iterate over each character in the string
            mp.put(tiles.charAt(i), mp.getOrDefault(tiles.charAt(i), 0) + 1); // Update the frequency of the character in the map
        return countTiles(tiles, mp); // Call the recursive function to count the possibilities
    }

    int countTiles(String tiles, HashMap<Character, Integer> mp){
        int count = 0; // Initialize the count of possibilities
        for(Character ch : mp.keySet()){ // Iterate over each unique character in the map
            HashMap<Character, Integer> tempMap = new HashMap<>(mp); // Create a copy of the map
            if(tempMap.get(ch) == 1) tempMap.remove(ch); // If the character frequency is 1, remove it from the map
            else tempMap.put(ch, tempMap.get(ch) - 1); // Otherwise, decrease the frequency by 1
            int temp = 1 + countTiles(tiles, tempMap); // Recursively count the possibilities with the updated map
            count += temp; // Add the count to the total
        }
        return count; // Return the total count
    }
}