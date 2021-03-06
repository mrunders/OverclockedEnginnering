package fr.mru.OverclockedEngineeringItems.Focus;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineering.Recipes.RecipesAlloy;
import fr.mru.OverclockedEngineering.Recipes.RecipesGrinder;
import net.minecraft.item.ItemStack;

public class GrinderFocus extends AFocusManager {

	public GrinderFocus() {
		super("grinder_focus");
	}
	
	@Override
	public RecipeRequest getRecipeResult(ItemStack... ingredients) {
		return RecipesGrinder.getRecipeResult(ingredients[0]);
	}
}
