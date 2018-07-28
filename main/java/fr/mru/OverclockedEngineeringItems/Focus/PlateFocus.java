package fr.mru.OverclockedEngineeringItems.Focus;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineering.Recipes.RecipesPlate;
import net.minecraft.item.ItemStack;

public class PlateFocus extends AFocusManager {

	public PlateFocus() {
		super("plate_focus");
	}
	
	@Override
	public RecipeRequest getRecipeResult(ItemStack... ingredients) {
		return RecipesPlate.getRecipeResult(ingredients[0]);
	}

}
