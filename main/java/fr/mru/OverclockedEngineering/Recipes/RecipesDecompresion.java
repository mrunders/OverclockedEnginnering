package fr.mru.OverclockedEngineering.Recipes;

import net.minecraft.item.ItemStack;

public class RecipesDecompresion extends ARecipeManager {

	public static RecipeRequest getRecipeResult(ItemStack... ingredients) {
		return RecipeCompresion.getReversedRecipeResult(ingredients);
	}
}
