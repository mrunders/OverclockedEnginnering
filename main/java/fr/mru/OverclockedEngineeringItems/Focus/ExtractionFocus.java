package fr.mru.OverclockedEngineeringItems.Focus;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineering.Recipes.RecipesAlloy;
import fr.mru.OverclockedEngineering.Recipes.RecipesExtraction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ExtractionFocus extends AFocusManager {

	public ExtractionFocus() {
		super("extraction_focus");
	}
	
	@Override
	public RecipeRequest getRecipeResult(ItemStack... ingredients) {
		return RecipesExtraction.getRecipeResult(ingredients[0]);
	}

}
