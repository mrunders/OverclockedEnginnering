package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class RecipesTreeFarm extends RecipeManager {
	
	private static final HashMap<ItemStack, ItemStack> treesLog = new HashMap<>();
	
	public static ItemStack getRecipeResult(ItemStack ingredient) {
		
	    //ItemStack result = treesLog.get(ingredient.getDisplayName().split(" ")[0]);
	    //return result == null ? RecipeRequest.nullStack : result;
		
		for ( ItemStack sapling : treesLog.keySet() ) 
			if ( ItemStackEquals(sapling, ingredient) ) 
				return treesLog.get(sapling);
		
		return RecipeRequest.nullStack;
	}
	
	public static boolean initialise() {
		
		treesLog.put(new ItemStack(Blocks.SAPLING, 1, 0), new ItemStack(Blocks.LOG, 5, 0));
		treesLog.put(new ItemStack(Blocks.SAPLING, 1, 1), new ItemStack(Blocks.LOG, 5, 1));
		treesLog.put(new ItemStack(Blocks.SAPLING, 1, 2), new ItemStack(Blocks.LOG, 5, 2));
		treesLog.put(new ItemStack(Blocks.SAPLING, 1, 3), new ItemStack(Blocks.LOG, 5, 3));
		treesLog.put(new ItemStack(Blocks.SAPLING, 1, 4), new ItemStack(Blocks.LOG2, 5, 0));
		treesLog.put(new ItemStack(Blocks.SAPLING, 1, 5), new ItemStack(Blocks.LOG2, 5, 1));
		
		return true;
	}
	
	public static HashMap<ItemStack, ItemStack> getRecipesMap() {
		
		return treesLog;
	}
	

}
