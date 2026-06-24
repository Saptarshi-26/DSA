import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Find_All_Possible_Recipes_From_Given_Supply {

    public boolean possibleRecipe(HashSet<String> current_supply, List<String> required_ingredient) {
        for (String ingredient : required_ingredient) {
            if (!current_supply.contains(ingredient)) return false;
        }
        return true;

    }

    public List<String> allRecipe(String[] recipes, HashSet<Integer> index, HashSet<String> current_supply, List<List<String>> ingredients) {

        if (index.isEmpty()) return new ArrayList<>();

        List<String> ans = new ArrayList<>();
        List<Integer> added = new ArrayList<>();

        for (int x : index) {
            if (possibleRecipe(current_supply, ingredients.get(x))) {
                added.add(x);
                ans.add(recipes[x]);
                current_supply.add(recipes[x]);
            }
        }

        if (added.isEmpty()) return ans;

        added.forEach(index::remove);

        ans.addAll(allRecipe(recipes, index, current_supply, ingredients));

        return ans;

    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        HashSet<String> current_supply = (HashSet<String>) Arrays.stream(supplies).collect(Collectors.toSet());

        HashSet<Integer> index = (HashSet<Integer>) Stream.iterate(0, x -> x + 1).limit(recipes.length).collect(Collectors.toSet());

        return allRecipe(recipes, index, current_supply, ingredients);


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of recipes ");
        int n = sc.nextInt();
        String[] recipes = new String[n];
        for (int i = 0; i < n; i++) {
            recipes[i] = sc.next();
        }
        List<List<String>> ingredients = new ArrayList<>();
        System.out.println("enter the ingredients for ith recipe ");
        for (int i = 0; i < n; i++) {
            System.out.println("enter the number of recipe ");
            int m = sc.nextInt();
            System.out.println("enter the ingredients ");
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                temp.add(sc.next());
            }
            ingredients.add(temp);
        }
        System.out.println("enter the no supplies present ");
        n = sc.nextInt();
        System.out.println("enter the supplies ");
        String[] supplies = new String[n];
        for (int i = 0; i < n; i++) {
            supplies[i] = sc.next();
        }

        Find_All_Possible_Recipes_From_Given_Supply supply =
                new Find_All_Possible_Recipes_From_Given_Supply();

        System.out.println(supply.findAllRecipes(recipes, ingredients, supplies));
    }
}
