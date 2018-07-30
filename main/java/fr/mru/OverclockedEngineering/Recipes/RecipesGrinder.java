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
				map.puttCopyOreDict("dust"+ore, 2, "ore"+ore, 1);
			
		}
		
		for ( String ingot : recipesOrdict.get("ingot") ) {
			if ( dustsstr.contains(ingot))
				map.puttCopyOreDict("dust"+ingot, 1, "ingot"+ingot, 1);
		}
		
		map.putt(new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.COBBLESTONE));
		map.putt(new ItemStack(Blocks.SAND), new ItemStack(Blocks.GRAVEL));
		map.putt(new ItemStack(Items.REDSTONE,6), new ItemStack(Blocks.REDSTONE_ORE));
		map.putt(new ItemStack(Items.COAL, 3), new ItemStack(Blocks.COAL_ORE));
		map.putt(new ItemStack(Items.DYE, 8, 4), new ItemStack(Blocks.LAPIS_ORE));
		map.putt(new ItemStack(Items.DIAMOND, 2), new ItemStack(Blocks.DIAMOND_ORE));
		map.putt(new ItemStack(Items.EMERALD, 2),  new ItemStack(Blocks.EMERALD_ORE));
		map.putt(new ItemStack(Items.QUARTZ, 4), new ItemStack(Blocks.QUARTZ_ORE));

		return true;
	}

	public static Set<List<ItemStack>> getRecipesList() {
		return map.keySet();
	}
}
