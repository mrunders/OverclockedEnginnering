package fr.mru.OverclockedEngineering.Recipes;

import java.util.List;
import java.util.Set;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class RecipesGear extends ARecipeManager {

	private static RecipeRequestMap map = new RecipeRequestMap();
	
	public static RecipeRequest getRecipeResult(ItemStack... ingredients) {
		return map.get(ingredients);
	}
	
	public static boolean initialise() {
		
		List<String> ingots = recipesOrdict.get("ingot");
		for (String gear : recipesOrdict.get("gear") ){
			
			if ( ingots.contains(gear) ) {
				map.puttCopyOreDict("gear"+gear, 1, "ingot"+gear, 4);
			}
			
		}
		
		return true;
	}
	
	public static Set<List<ItemStack>> getRecipesMap() {
		return map.keySet();
	}

	public static RecipeRequest getRecipeResultForInput(ItemStack... itemStack) {
		return getRecipeResult(itemStack);
	}
}
