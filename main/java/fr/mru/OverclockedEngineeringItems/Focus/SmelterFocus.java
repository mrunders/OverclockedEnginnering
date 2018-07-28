package fr.mru.OverclockedEngineeringItems.Focus;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineering.Recipes.RecipesAlloy;
import fr.mru.OverclockedEngineering.Recipes.RecipesSmelter;
import net.minecraft.item.ItemStack;

public class SmelterFocus extends AFocusManager {

	public SmelterFocus() {
		super("smelter_focus");
	}
	
	@Override
	public RecipeRequest getRecipeResult(ItemStack... ingredients) {
		return RecipesSmelter.getRecipeResult(ingredients[0]);
	}
}
