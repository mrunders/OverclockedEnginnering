package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.annotation.Nonnull;

import com.brandon3055.draconicevolution.client.model.tool.ToolOverrideList;

import codechicken.lib.util.ArrayUtils;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public abstract class RecipeManager implements IRecipesManager {
		
	protected static void addRecipe(HashMap <ItemStack[], ItemStack> recipes, Item ingredient1, Item ingredient2, Item resultat1) {
	    addRecipe(recipes, new ItemStack(ingredient1), new ItemStack(ingredient2), new ItemStack(resultat1));
	}
	
	protected static void addRecipe(HashMap <ItemStack[], ItemStack> recipes, Item ingredient1, Item resultat1) {
	    addRecipe(recipes, new ItemStack(ingredient1), new ItemStack(resultat1));
	}
	
	protected static void addRecipe(HashMap <ItemStack[], ItemStack> recipes, Block ingredient1, Block ingredient2, Block resultat1) {
	    addRecipe(recipes, new ItemStack(ingredient1), new ItemStack(ingredient2), new ItemStack(resultat1));
	}
	
	protected static void addRecipe(HashMap <ItemStack[], ItemStack> recipes, Block ingredient1, Block resultat1) {
	    addRecipe(recipes, new ItemStack(ingredient1), new ItemStack(resultat1));
	}
	
	

	protected static void addRecipe(HashMap <ItemStack[], ItemStack> recipes, ItemStack ingredient1, ItemStack ingredient2, ItemStack resultat1) {
	    recipes.put(new ItemStack[]{ingredient1, ingredient2}, resultat1);
	}
	
	protected static void addRecipe(HashMap <ItemStack[], ItemStack> recipes, ItemStack ingredient1, ItemStack resultat1) {
	    recipes.put(new ItemStack[]{ingredient1}, resultat1);
	}
	
	protected static boolean ItemStackEquals(ItemStack recipe, ItemStack ingredient) {
		
		return !recipe.isEmpty() && !ingredient.isEmpty() && recipe.getItem() == ingredient.getItem() && recipe.getCount() <= ingredient.getCount();
	}
	
	private static boolean containsOreDict(ItemStack[] recipe, ItemStack item, int i) {
		
		int index = 0;
		while (index < recipe.length) 
			if (item.getUnlocalizedName().equals(recipe[index].getUnlocalizedName())) break; 
			else index++; 
		
		return index < recipe.length && recipe[index].getCount() <= item.getCount();
	}
	
	private static boolean areKeysEqual(ItemStack[] recipe, ItemStack[] ingredients) {
	    if(recipe.length != ingredients.length) return false;

	    for(int i = 0; i < ingredients.length; i++) {
	        if (!containsOreDict(recipe, ingredients[i], i)) return false;
	        
	    }

	    return true;
	}
	
	public static ItemStack getRecipeResult(HashMap <ItemStack[], ItemStack> recipes, ItemStack[] ingredients) {
		

	    Iterator<Entry<ItemStack[], ItemStack>> it = recipes.entrySet().iterator();
	    while(it.hasNext()) {
	        Entry <ItemStack[], ItemStack>entry = it.next();
	        if(areKeysEqual(entry.getKey(), ingredients)) {
	            return entry.getValue();
	        }
	    }
	    return null;
	}
}
