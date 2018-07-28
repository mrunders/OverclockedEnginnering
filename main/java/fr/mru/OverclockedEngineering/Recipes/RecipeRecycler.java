package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeRecycler extends ARecipeManager {

	private static RecipeRequestMap map = new RecipeRequestMap();
	private static final HashMap<String, Integer>toolsTab = new HashMap<>();
	
	public static RecipeRequest getRecipeResult(ItemStack[] ingredients) {
		if ( ingredients[0].isEmpty()) return RecipeRequest.NULL;

		return new RecipeRequest(getRecipeResult(ingredients[0]), ingredients[0]);
	    
	}
	
	private static ItemStack getRecipeResult(ItemStack itemStack) {
		
		String material, tool, splited[];
		splited = itemStack.getDisplayName().split(" ");
		
		if ( splited.length < 2) return null;
		
		material = splited[0];
		tool = splited[splited.length-1];
		
		if ( OreDictionary.doesOreNameExist("ingot" + material) && toolsTab.containsKey(tool)) {
			ItemStack result = OreDictionary.getOres("ingot"+material).get(0).copy();
			result.setCount(toolsTab.get(tool));
			return result;
		}
		
		return null;
	}

	public static boolean initialise() {
		
		toolsTab.put("Pickaxe", 3);
		toolsTab.put("Shovel", 1);
		toolsTab.put("Hoe", 2);
		toolsTab.put("Sword", 2);
		toolsTab.put("Axe", 3);
		toolsTab.put("Bow", 3);
		toolsTab.put("Shears", 2);
		toolsTab.put("Sickle", 3);
		toolsTab.put("Hammer", 5);
		toolsTab.put("Shield", 6);
		toolsTab.put("Armor", 4);
		toolsTab.put("Boots", 4);
		toolsTab.put("Leggings", 7);
		toolsTab.put("Chestplate", 8);
		toolsTab.put("Helmet", 5);
		return true;
	}

}
