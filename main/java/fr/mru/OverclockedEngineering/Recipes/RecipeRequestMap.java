package fr.mru.OverclockedEngineering.Recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeRequestMap extends HashMap<List<ItemStack>, RecipeRequest> {
	
	public void puttCopyOreDict(String value, int count0, String input1, int count1, String input2, int count2) {
		
		if ( OreDictionary.doesOreNameExist(value) && !OreDictionary.getOres(value).isEmpty() ) {
			ItemStack output = OreDictionary.getOres(value).get(0);
			for (ItemStack in1 : OreDictionary.getOres(input1)) {
				for (ItemStack in2 : OreDictionary.getOres(input2)) {
					puttCopy(output, count0, in1, count1, in2, count2);
					puttCopy(output, count0, in2, count2, in1, count1);
				}
			}
		} else
			System.out.println("== Object " + value + " as no valide output !!!!!!!!");
	}
	
	public void puttCopyOreDict(String value, int count0, String input1, int count1) {
		
		if ( OreDictionary.doesOreNameExist(value) && !OreDictionary.getOres(value).isEmpty() ) {
			ItemStack output = OreDictionary.getOres(value).get(0);
			for (ItemStack in1 : OreDictionary.getOres(input1)) {
				puttCopy(output, count0, in1, count1);
			}
		} else
			System.out.println("== Object " + value + " as no valide output !!!!!!!!");
	}
	
	public RecipeRequest puttCopy(ItemStack value, int count0, ItemStack input1, int count1, ItemStack input2, int count2) {
		return putt(copycount(value, count0), copycount(input1, count1), copycount(input2, count2));
	}
	
	public RecipeRequest puttCopy(ItemStack value, int count0, ItemStack input1, int count1) {
		return putt(copycount(value, count0), copycount(input1, count1));
	}
	
	public RecipeRequest putt(ItemStack value, ItemStack... keys) {
		return this.put(value, keys);
	}

	public RecipeRequest put(ItemStack value, ItemStack[] keys) {
		
		List<ItemStack> list = new ArrayList<>();
		for ( ItemStack i : keys ) {
			list.add(i);
		}
		
		return super.put(list, new RecipeRequest(value, keys));
		
	}

	public RecipeRequest gett(ItemStack... ingredients ) {
		return this.get(ingredients);

	}
	
	public RecipeRequest get(ItemStack[] ingredients) {
		
		for (List<ItemStack> recipe : super.keySet()) {
			if ( recipeAlloed(recipe, ingredients) ) return super.get(recipe);
		}
		
		return RecipeRequest.NULL;
	}
	
	private ItemStack copycount(ItemStack constt, int count) {
		
		ItemStack c = constt.copy();
		c.setCount(count);
		return c;
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
			if ( r.getItem() == i.getItem() && 
				 r.getCount() <= i.getCount() && 
				 r.getMetadata() == i.getMetadata() ) return true;
		}
		
		return false;
	}

}
