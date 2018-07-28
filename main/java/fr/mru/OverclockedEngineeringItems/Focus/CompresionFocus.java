package fr.mru.OverclockedEngineeringItems.Focus;

import fr.mru.OverclockedEngineering.Recipes.RecipeCompresion;
import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineering.Recipes.RecipesAlloy;
import net.minecraft.item.ItemStack;

public class CompresionFocus extends AFocusManager {

	public CompresionFocus() {
		super("compresion_focus");
	}
	
	@Override
	public RecipeRequest getRecipeResult(ItemStack... ingredients) {
		return RecipeCompresion.getRecipeResult(ingredients[0]);
	}

}
