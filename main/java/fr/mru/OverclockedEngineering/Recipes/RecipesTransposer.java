package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipesTransposer extends ARecipeManager {
	
	private static RecipeRequestMap map = new RecipeRequestMap();
	
	public static RecipeRequest getRecipeResult(ItemStack... ingredients) {
		return map.get(ingredients);
	    
	}
	
	public static boolean initialise() {
		
		map.putt(new ItemStack(Items.WATER_BUCKET), new ItemStack(Blocks.CLAY), new ItemStack(Items.BUCKET));
		map.putt(new ItemStack(Items.LAVA_BUCKET), new ItemStack(Blocks.MAGMA, 16), new ItemStack(Items.BUCKET));
		
		return true;
	}
	
	public static Set<List<ItemStack>> getRecipesList(){
		return map.keySet();
	}

}
