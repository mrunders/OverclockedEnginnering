package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;

import cofh.thermalexpansion.ThermalExpansion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;

public class RecipesTransposer extends AMultiItemsRecipe {

	public static RecipeRequest getRecipeResult(ItemStack[] ingredients) {
		if ( ingredients[0].isEmpty() || ingredients[1].isEmpty()) 
			return RecipeRequest.NULL;
		
		if ( ingredients[2].isEmpty() )
			return getTwoIngotsRecipeResult(new ItemStack[] {ingredients[0],ingredients[1]});
		
	    return RecipeRequest.NULL;
	    
	}
	
	public static boolean initialise() {
		
		addTwoIngotSideRecipe(new ItemStack(Blocks.CLAY), new ItemStack(Items.BUCKET), new ItemStack(Items.WATER_BUCKET));
		addTwoIngotSideRecipe(new ItemStack(Blocks.MAGMA, 16), new ItemStack(Items.BUCKET), new ItemStack(Items.LAVA_BUCKET));

		
		return true;
	}
}
