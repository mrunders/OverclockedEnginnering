package fr.mru.OverclockedEngineering.Recipes;

import java.util.List;
import java.util.Set;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipesSawmill extends ARecipeManager {

	private static RecipeRequestMap map = new RecipeRequestMap();
	
	public static RecipeRequest getRecipeResult(ItemStack... ingredients) {
		return map.get(ingredients);
	}
	
	public static boolean initialise() {

		/*
		map.putCopyOredict("plankWood", 5, "logWood", 1);
		map.putCopyOredict("stickWood", 2, "treeSapling", 1);
		
		map.put(new ItemStack(Blocks.PLANKS, 4, 0), new ItemStack(Blocks.CRAFTING_TABLE));
		map.put(new ItemStack(Blocks.PLANKS, 8, 0), new ItemStack(Blocks.CHEST));	
		 */
		return true;
	}
	
	public static Set<List<ItemStack>> getRecipesMap() {
		return map.keySet();
	}
}
