package fr.mru.OverclockedEngineeringItems.Focus;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineering.Recipes.RecipesDecompresion;
import net.minecraft.item.ItemStack;

public class DecompresionFocus extends AFocusManager {

	public DecompresionFocus() {
		super("decompresion_focus");
	}
	
	@Override
	public RecipeRequest getRecipeResult(ItemStack... ingredients) {
		return RecipesDecompresion.getRecipeResult(ingredients);
	}

}
