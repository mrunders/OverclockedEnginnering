package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipesTreeFarm extends ARecipeManager {
	
	private static RecipeRequestMap map = new RecipeRequestMap();
	
	public static RecipeRequest getRecipeResult(ItemStack ingredient) {
		
		return map.gett(ingredient);
	}
	
	public static boolean initialise() {

		map.put(new ItemStack(Blocks.LOG, 5, 0), new ItemStack(Blocks.SAPLING, 1, 0));
		map.put(new ItemStack(Blocks.LOG, 5, 1), new ItemStack(Blocks.SAPLING, 1, 1));
		map.put(new ItemStack(Blocks.LOG, 5, 2), new ItemStack(Blocks.SAPLING, 1, 2));
		map.put(new ItemStack(Blocks.LOG, 5, 3), new ItemStack(Blocks.SAPLING, 1, 3));
		map.put(new ItemStack(Blocks.LOG2, 5, 0), new ItemStack(Blocks.SAPLING, 1, 4));
		map.put(new ItemStack(Blocks.LOG2, 5, 1), new ItemStack(Blocks.SAPLING, 1, 5));

		map.put(new ItemStack(Items.WHEAT, 4), new ItemStack(Items.WHEAT_SEEDS));
		map.put(new ItemStack(Items.MELON, 8), new ItemStack(Items.MELON_SEEDS));
		map.put(new ItemStack(Blocks.PUMPKIN, 1), new ItemStack(Items.PUMPKIN_SEEDS));
		map.put(new ItemStack(Items.BEETROOT, 4), new ItemStack(Items.BEETROOT_SEEDS));
		map.put(new ItemStack(Items.POTATO, 4), new ItemStack(Items.POTATO));
		map.put(new ItemStack(Items.REEDS, 4), new ItemStack(Items.REEDS));
		map.put(new ItemStack(Blocks.CACTUS, 6), new ItemStack(Blocks.CACTUS));
		
		return true;
	}
	
	public static Set<List<ItemStack>> getRecipesMap() {
		return map.keySet();
	}
	

}
