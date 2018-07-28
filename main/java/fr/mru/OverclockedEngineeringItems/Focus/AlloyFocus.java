package fr.mru.OverclockedEngineeringItems.Focus;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineering.Recipes.RecipesAlloy;
import net.minecraft.item.ItemStack;

public class AlloyFocus extends AFocusManager {

	public AlloyFocus() {
		super("alloy_focus");

	}

	@Override
	public RecipeRequest getRecipeResult(ItemStack... ingredients) {
		
		if ( ingredients[1].isEmpty() ) return RecipeRequest.NULL;
		if ( ingredients[2].isEmpty() ) return RecipesAlloy.getRecipeResult(ingredients[0], ingredients[1]);
		return RecipesAlloy.getRecipeResult(ingredients);
	}

}
