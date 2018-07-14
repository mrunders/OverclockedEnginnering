package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;

public class RecipesSmelter extends RecipeManager {
	
	public static final HashMap <ItemStack[], ItemStack>recipes = new HashMap<ItemStack[], ItemStack>();
	
	static {

	}
	
	public static RecipeRequest getRecipeResult(ItemStack[] ingredients) {
	    ItemStack res = FurnaceRecipes.instance().getSmeltingResult(ingredients[0]);
	    if (res == null || res.getItem().equals(Items.AIR))
	    	return RecipeRequest.NULL;
	    return new RecipeRequest(res, ingredients[0]);
	    
	}
	
}
