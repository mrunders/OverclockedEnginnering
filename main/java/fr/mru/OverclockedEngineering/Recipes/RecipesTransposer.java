package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipesTransposer extends RecipeManager {

	private static final HashMap <ItemStack, HashMap<ItemStack, RecipeRequest>>recipes = new HashMap<>();
	
	static {
		
	}
	
	private static RecipeRequest getResult(ItemStack[] ingredients) {
		
		HashMap<ItemStack, RecipeRequest> map2;
		for ( ItemStack in1 : recipes.keySet()) {
			if ( ItemStackEquals(in1, ingredients[0])) {
				map2 = recipes.get(in1);
				for ( ItemStack in2 : map2.keySet()) {
					if ( ItemStackEquals(in2, ingredients[1])) {
						return map2.get(in2);
					}
				}
			}
		}
		
		return null;
	}
	
	private static void addRecipe(ItemStack in1, ItemStack in2, ItemStack output) {
		
		HashMap<ItemStack, RecipeRequest> map2;
		if ( !recipes.containsKey(in1) ) recipes.put(in1, new HashMap<>());
		map2 = recipes.get(in1);
		map2.put(in2, new RecipeRequest(output, in1, in2));
	}
	
	public static RecipeRequest getRecipeResult(ItemStack[] ingredients) {
		if ( ingredients[0].isEmpty() || ingredients[1].isEmpty()) return null;
		if ( ingredients[2].isEmpty() )  return getResult(new ItemStack[] {ingredients[0],ingredients[1]});
	    return null;
	    
	}
	
	public static boolean initialise() {
		
		addRecipe(new ItemStack(Blocks.CLAY, 4), new ItemStack(Items.BUCKET), new ItemStack(Items.WATER_BUCKET));
		addRecipe(new ItemStack(Items.BUCKET), new ItemStack(Blocks.CLAY, 4), new ItemStack(Items.WATER_BUCKET));
		addRecipe(new ItemStack(Blocks.MAGMA, 4), new ItemStack(Items.BUCKET), new ItemStack(Items.LAVA_BUCKET));
		addRecipe(new ItemStack(Items.BUCKET), new ItemStack(Blocks.MAGMA, 4), new ItemStack(Items.LAVA_BUCKET));	
		
		return true;
	}
}
