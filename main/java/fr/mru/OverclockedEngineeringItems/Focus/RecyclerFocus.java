package fr.mru.OverclockedEngineeringItems.Focus;

import fr.mru.OverclockedEngineering.Recipes.RecipeRecycler;
import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import net.minecraft.item.ItemStack;

public class RecyclerFocus extends AFocusManager {

	public RecyclerFocus() {
		super("recycler_focus");
	}
	
	@Override
	public RecipeRequest getRecipeResult(ItemStack... ingredients) {
		return RecipeRecycler.getRecipeResult(ingredients);
	}

}
