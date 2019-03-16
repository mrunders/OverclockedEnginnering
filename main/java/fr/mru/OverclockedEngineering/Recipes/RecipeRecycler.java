package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import fr.mru.OverclockedengineeringBlocks.OverclockedEngineeringBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeRecycler extends ARecipeManager {

	private static RecipeRequestMap map = new RecipeRequestMap();
	
	public static RecipeRequest getRecipeResult(ItemStack[] ingredients) {
		return map.gett(ingredients);
	}

	public static boolean initialise() {
		
		/*
		Pickaxe, 3
		Shovel, 1
		Hoe, 2
		Sword, 2
		Axe, 3
		Bow, 3
		Shears, 2
		Sickle, 3
		Hammer, 5
		Shield, 6
		Armor, 4
		Boots, 4
		Leggings, 7
		Chestplate, 8
		Helmet, 5
		*/
		
		map.putCopy(new ItemStack(OverclokedEngineeringItems.INGOT_SHIP), 4, new ItemStack(OverclockedEngineeringBlocks.STRUCTURE_SHIP_BLOCK), 1);
		
		return true;
	}
	
	public static Set<List<ItemStack>> getRecipesList() {
		return map.keySet();
	}

}
