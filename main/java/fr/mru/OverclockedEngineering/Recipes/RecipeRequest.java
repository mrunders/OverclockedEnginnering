package fr.mru.OverclockedEngineering.Recipes;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;

public class RecipeRequest {

	private ItemStack result;
	private ItemStack[] used = new ItemStack[3]; 
	
	public RecipeRequest(@Nonnull ItemStack result, @Nonnull ItemStack... used ) {
		
		this.result = result;
		for (int i = 0; i < used.length; ++i) this.used[i] = used[i];
		
	}
	
	public ItemStack getResult() {
		return result;
	}
	
	public ItemStack getRequiredItem(int index) {
		return used[index];
	}
	
	public ItemStack[] getRequiredList() {
		return used;
	}
}
