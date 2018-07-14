package fr.mru.OverclockedEngineering.Recipes;

import javax.annotation.Nonnull;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeRequest {
	
	public static ItemStack nullStack = new ItemStack(Items.AIR, 0);
	public static RecipeRequest NULL = new RecipeRequest(nullStack);

	private ItemStack result;
	private ItemStack[] used = new ItemStack[3]; 
	private int realUsed;
	
	public RecipeRequest(ItemStack result, ItemStack... used ) {
		
		int i;
		this.result = result;
		for (i = 0; i < used.length; ++i) this.used[i] = used[i];
		realUsed = i;
		for ( ; i < used.length; ++i) this.used[i] = nullStack;
		
	}
	
	public ItemStack getResult() {
		return result;
	}
	
	public int getRequiredItemCount(int index) {
		return used[index] == null? 0 : used[index].getCount();
	}
	
	public ItemStack[] getRequiredList() {
		return used;
	}
	
	public int getUsedCount() {
		return used.length;
	}
	
	public int getRealUsedCount() {
		return realUsed;
	}
}
