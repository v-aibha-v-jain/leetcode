import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String[] recipes = {"bread"};
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(List.of("yeast", "flour"));
        String[] supplies = {"yeast", "flour", "corn"};
        List<String> result = solution.findAllRecipes(recipes, ingredients, supplies);
        System.out.println(result);
    }
}
class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> initial = new HashSet<>(); // Set to store available supplies and recipes
        for (String str : supplies) // Add all initial supplies to the set
            initial.add(str);
        List<String> lst = new ArrayList<>(); // List to store the recipes that can be made
        int count = recipes.length; // Number of recipes to process
        while (count-- > 0) { // Loop until all recipes are processed
            for (int i = 0; i < recipes.length; i++) { // Iterate through each recipe
                if (lst.contains(recipes[i])) // Skip if the recipe is already added
                    continue;
                boolean allAvail = true; // Flag to check if all ingredients are available
                for (int j = 0; j < ingredients.get(i).size(); j++) { // Check each ingredient of the recipe
                    if (!initial.contains(ingredients.get(i).get(j))) { // If ingredient is not available
                        allAvail = false; // Mark as not all available
                        break; // Exit the loop
                    }
                }
                if (allAvail) { // If all ingredients are available
                    initial.add(recipes[i]); // Add the recipe to the set of available items
                    lst.add(recipes[i]); // Add the recipe to the result list
                }
            }
        }
        return lst; // Return the list of recipes that can be made
    }
}