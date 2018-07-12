package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class RecipeManager implements IRecipeManager {
	
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
	
	private static boolean areKeysEqual(ItemStack[] key1, ItemStack[] key2) {
	    if(key1.length != key2.length) return false;

	    for(int i = 0; i < key1.length; i++) {
	        ItemStack s1 = key1[0];
	        ItemStack s2 = key2[0];
	        if(s1.isEmpty() && !s2.isEmpty()) return false;
	        if(!s1.isEmpty() && s2.isEmpty()) return false;
	        if(s1.getItem() != s2.getItem()) return false;
	        if(s1.getItemDamage() != s2.getItemDamage()) return false;
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
