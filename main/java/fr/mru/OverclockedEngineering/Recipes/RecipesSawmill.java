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
		
		map.putt(new ItemStack(Blocks.PLANKS, 6, 0), new ItemStack(Blocks.LOG, 1, 0));
		map.putt(new ItemStack(Blocks.PLANKS, 6, 1), new ItemStack(Blocks.LOG, 1, 1));
		map.putt(new ItemStack(Blocks.PLANKS, 6, 2), new ItemStack(Blocks.LOG, 1, 2));
		map.putt(new ItemStack(Blocks.PLANKS, 6, 3), new ItemStack(Blocks.LOG, 1, 3));
		map.putt(new ItemStack(Blocks.PLANKS, 6, 4), new ItemStack(Blocks.LOG2, 1, 0));
		map.putt(new ItemStack(Blocks.PLANKS, 6, 5), new ItemStack(Blocks.LOG2, 1, 1));
		
		map.putt(new ItemStack(Items.STICK, 2), new ItemStack(Blocks.SAPLING, 1, 0));
		map.putt(new ItemStack(Items.STICK, 2), new ItemStack(Blocks.SAPLING, 1, 1));
		map.putt(new ItemStack(Items.STICK, 2), new ItemStack(Blocks.SAPLING, 1, 2));
		map.putt(new ItemStack(Items.STICK, 2), new ItemStack(Blocks.SAPLING, 1, 3));
		map.putt(new ItemStack(Items.STICK, 2), new ItemStack(Blocks.SAPLING, 1, 4));
		map.putt(new ItemStack(Items.STICK, 2), new ItemStack(Blocks.SAPLING, 1, 5));
		
		map.putt(new ItemStack(Blocks.PLANKS, 4, 0), new ItemStack(Blocks.CRAFTING_TABLE));
		map.putt(new ItemStack(Blocks.PLANKS, 8, 0), new ItemStack(Blocks.CHEST));	

		return true;
	}
	
	public static Set<List<ItemStack>> getRecipesMap() {
		return map.keySet();
	}
}
