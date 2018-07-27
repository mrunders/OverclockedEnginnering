package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipesTreeFarm extends ARecipeManager {
	
	private static RecipeRequestMap map = new RecipeRequestMap();
	
	public static RecipeRequest getRecipeResult(ItemStack ingredient) {
		
		return map.gett(ingredient);
	}
	
	public static boolean initialise() {

		map.putt(new ItemStack(Blocks.LOG, 5, 0), new ItemStack(Blocks.SAPLING, 1, 0));
		map.putt(new ItemStack(Blocks.LOG, 5, 1), new ItemStack(Blocks.SAPLING, 1, 1));
		map.putt(new ItemStack(Blocks.LOG, 5, 2), new ItemStack(Blocks.SAPLING, 1, 2));
		map.putt(new ItemStack(Blocks.LOG, 5, 3), new ItemStack(Blocks.SAPLING, 1, 3));
		map.putt(new ItemStack(Blocks.LOG2, 5, 0), new ItemStack(Blocks.SAPLING, 1, 4));
		map.putt(new ItemStack(Blocks.LOG2, 5, 1), new ItemStack(Blocks.SAPLING, 1, 5));
		
		return true;
	}
	
	public static Set<List<ItemStack>> getRecipesMap() {
		return map.keySet();
	}
	

}
