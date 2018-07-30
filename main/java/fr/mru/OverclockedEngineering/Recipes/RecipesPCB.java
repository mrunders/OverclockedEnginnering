package fr.mru.OverclockedEngineering.Recipes;

import java.util.List;
import java.util.Set;

import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipesPCB extends ARecipeManager {
	
	private static RecipeRequestMap map = new RecipeRequestMap();
	
	public static RecipeRequest getRecipeResult(ItemStack... ingredients) {
		return map.get(ingredients);
	}
	
	public static boolean initialise() {

		map.puttCopy(new ItemStack(OverclokedEngineeringItems.CIRCUIT), 1, new ItemStack(Items.IRON_INGOT), 1);
		map.puttCopy(new ItemStack(OverclokedEngineeringItems.CIRCUIT_LARGE), 1, new ItemStack(Blocks.IRON_BLOCK), 1);
		
		return true;
	}
	
	public static Set<List<ItemStack>> getRecipesMap() {
		return map.keySet();
	}

}
