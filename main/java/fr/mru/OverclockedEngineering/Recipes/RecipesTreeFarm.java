package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipesTreeFarm extends RecipeManager {
	
	private static final HashMap<String, ItemStack> treesLog = new HashMap<>();
	
	
	public static ItemStack getRecipeResult(ItemStack ingredient) {
		
	    ItemStack result = treesLog.get(ingredient.getDisplayName().split(" ")[0]);
	    return result == null ? RecipeRequest.nullStack : result;
	}
	
	public static boolean initialise() {
		
		treesLog.put("Oak", new ItemStack(Blocks.LOG, 5, 0));
		treesLog.put("Spruce", new ItemStack(Blocks.LOG, 5, 1));
		treesLog.put("Birch", new ItemStack(Blocks.LOG, 5, 2));
		treesLog.put("Jungle", new ItemStack(Blocks.LOG, 5, 3));
		treesLog.put("Acacia", new ItemStack(Blocks.LOG2, 5, 0));
		treesLog.put("Dark", new ItemStack(Blocks.LOG2, 5, 1));
		
		return true;
	}
}
