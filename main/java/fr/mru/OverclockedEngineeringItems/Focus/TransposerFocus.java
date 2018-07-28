package fr.mru.OverclockedEngineeringItems.Focus;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineering.Recipes.RecipesAlloy;
import fr.mru.OverclockedEngineering.Recipes.RecipesTransposer;
import net.minecraft.item.ItemStack;

public class TransposerFocus extends AFocusManager {

	public TransposerFocus() {
		super("transposer_focus");
	}
	
	@Override
	public RecipeRequest getRecipeResult(ItemStack... ingredients) {
		
		if ( ingredients.length == 2) return RecipesTransposer.getRecipeResult(ingredients[0], ingredients[1]);
		return RecipesTransposer.getRecipeResult(ingredients);
	}

}
