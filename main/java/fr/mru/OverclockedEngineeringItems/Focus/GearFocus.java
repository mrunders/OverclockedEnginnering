package fr.mru.OverclockedEngineeringItems.Focus;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineering.Recipes.RecipesGear;
import net.minecraft.item.ItemStack;

public class GearFocus extends AFocusManager {

	public GearFocus() {
		super("gear_focus");
	}
	
	@Override
	public RecipeRequest getRecipeResult(ItemStack... ingredients) {
		return RecipesGear.getRecipeResult(ingredients[0]);
	}

}
