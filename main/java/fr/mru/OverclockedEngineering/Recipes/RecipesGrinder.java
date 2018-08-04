package fr.mru.OverclockedEngineering.Recipes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

public class RecipesGrinder extends ARecipeManager {
	
	private static RecipeRequestMap map = new RecipeRequestMap();

	public static RecipeRequest getRecipeResult(ItemStack... ingredient) {
		return map.get(ingredient);
	    
	}
	
	public static boolean initialise() {
		
		List<String> dustsstr = recipesOrdict.get("dust");
		
		for ( String ore : recipesOrdict.get("ore") ) {
			if ( dustsstr.contains(ore) ) 
				map.putCopyOredict("dust"+ore, 2, "ore"+ore, 1);
			
		}
		
		for ( String ingot : recipesOrdict.get("ingot") ) {
			if ( dustsstr.contains(ingot))
				map.putCopyOredict("dust"+ingot, 1, "ingot"+ingot, 1);
		}
		
		map.put(new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.COBBLESTONE));
		map.put(new ItemStack(Blocks.SAND), new ItemStack(Blocks.GRAVEL));
		map.put(new ItemStack(Items.REDSTONE,6), new ItemStack(Blocks.REDSTONE_ORE));
		map.put(new ItemStack(Items.COAL, 3), new ItemStack(Blocks.COAL_ORE));
		map.put(new ItemStack(Items.DYE, 8, 4), new ItemStack(Blocks.LAPIS_ORE));
		map.put(new ItemStack(Items.DIAMOND, 2), new ItemStack(Blocks.DIAMOND_ORE));
		map.put(new ItemStack(Items.EMERALD, 2),  new ItemStack(Blocks.EMERALD_ORE));
		map.put(new ItemStack(Items.QUARTZ, 4), new ItemStack(Blocks.QUARTZ_ORE));

		return true;
	}

	public static Set<List<ItemStack>> getRecipesList() {
		return map.keySet();
	}
}
