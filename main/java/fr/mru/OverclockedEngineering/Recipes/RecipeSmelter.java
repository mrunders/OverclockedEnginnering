package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipeSmelter extends RecipeManager {
	
	public static final HashMap <ItemStack[], ItemStack>recipes = new HashMap<ItemStack[], ItemStack>();
	
	static {
	    addRecipe(recipes, Items.APPLE, Items.ARROW, Items.BAKED_POTATO);
	}
	
	public static ItemStack getRecipeResult(ItemStack[] ingredients) {
	    return getRecipeResult(recipes, ingredients);
	}
	
}
