package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipesTransposer extends RecipeManager {
	
	private static final RecipeRequestMap map = new RecipeRequestMap();

	public static RecipeRequest getRecipeResult(ItemStack[] ingredients) {
		return map.get(ingredients);
	    
	}
	
	public static boolean initialise() {
		
		map.putt(new ItemStack(Items.WATER_BUCKET), new ItemStack(Blocks.CLAY), new ItemStack(Items.BUCKET));
		map.putt(new ItemStack(Items.LAVA_BUCKET), new ItemStack(Blocks.MAGMA, 16), new ItemStack(Items.BUCKET));
		
		return true;
	}
	
	public static RecipeRequestMap getRecipesList(){
		
		return map;
	}

	public static RecipeRequest getRecipeResult(List<ItemStack> a) {
		return map.gett(a.get(0), a.get(1));
	}
}
