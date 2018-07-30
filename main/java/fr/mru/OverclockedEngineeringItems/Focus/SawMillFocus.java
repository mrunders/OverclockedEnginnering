package fr.mru.OverclockedEngineeringItems.Focus;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineering.Recipes.RecipesSawmill;
import net.minecraft.item.ItemStack;

public class SawMillFocus extends AFocusManager {

	public SawMillFocus() {
		super("sawmill_focus");
	}

	@Override
	public RecipeRequest getRecipeResult(ItemStack... ingredients) {
		return RecipesSawmill.getRecipeResult(ingredients[0]);
	}

}
