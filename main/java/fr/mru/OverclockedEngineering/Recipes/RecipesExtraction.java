package fr.mru.OverclockedEngineering.Recipes;

import java.util.List;
import java.util.Set;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class RecipesExtraction extends ARecipeManager {

	private static RecipeRequestMap map = new RecipeRequestMap();
	
	public static RecipeRequest getRecipeResult(ItemStack... ingredients) {
		return map.get(ingredients);
	}
	
	public static boolean initialise() {
		
		List<String> blocks = recipesOrdict.get("block");
		for (String ore : recipesOrdict.get("ore") ){
			
			if ( blocks.contains(ore) ) {
				map.puttCopyOreDict("block"+ore, 1, "ore"+ore, 3);
			}
			
		}
		
		map.remove(new ItemStack(Blocks.QUARTZ_ORE), 3);
		map.puttCopyOreDict("blockQuartz", 1, "oreQuartz", 1);
		
		return true;
	}
	
	public static Set<List<ItemStack>> getRecipesMap() {
		return map.keySet();
	}

	public static RecipeRequest getRecipeResultForInput(ItemStack... itemStack) {
		return getRecipeResult(itemStack);
	}
}
