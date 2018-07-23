package fr.mru.OverclockedEngineering.Recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipeRequestMap extends HashMap<List<ItemStack>, ItemStack> {
	
	public ItemStack putt(ItemStack value, ItemStack... keys) {
		return this.put(value, keys);
	}

	public ItemStack put(ItemStack value, ItemStack[] keys) {
		
		List<ItemStack> list = new ArrayList<>();
		for ( ItemStack i : keys ) {
			list.add(i);
		}
		
		return super.put(list, value);
		
	}
	
	public ItemStack gett(ItemStack... ingredients ) {
		return this.get(ingredients);

	}
	
	public ItemStack get(ItemStack[] ingredients) {
		
		for (List<ItemStack> recipe : super.keySet()) {
			if ( recipeAlloed(recipe, ingredients) ) return super.get(recipe);
		}
		
		return RecipeRequest.nullStack;
	}

	private boolean recipeAlloed(List<ItemStack> recipe, ItemStack[] ingredients) {
		
		if ( recipe.size() != ingredients.length ) return false;
		
		for ( ItemStack i : ingredients ) {
			if ( !containsStack( recipe, i) ) return false;
		}
		
		return true;
	}

	private boolean containsStack(List<ItemStack> recipe, ItemStack i) {
		
		for ( ItemStack r : recipe ) {
			if ( r.getItem().equals(i.getItem()) && r.getCount() <= i.getCount() ) return true;
		}
		
		return false;
	}

}
