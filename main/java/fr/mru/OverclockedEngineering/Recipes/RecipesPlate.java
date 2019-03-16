package fr.mru.OverclockedEngineering.Recipes;

import java.util.List;
import java.util.Set;

import fr.mru.OverclockedengineeringBlocks.OverclockedEngineeringBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class RecipesPlate extends ARecipeManager {

	private static RecipeRequestMap map = new RecipeRequestMap();
	
	public static RecipeRequest getRecipeResult(ItemStack... ingredients) {
		return map.get(ingredients);
	}
	
	public static boolean initialise() {
		
		List<String> ingots = recipesOrdict.get("ingot");
		for (String plate : recipesOrdict.get("plate") ){
			
			if ( ingots.contains(plate) ) {
				map.putCopyOredict("plate"+plate, 1, "ingot"+plate, 1);
			}
			
		}
		
		return true;
	}
	
	public static Set<List<ItemStack>> getRecipesMap() {
		return map.keySet();
	}

}
