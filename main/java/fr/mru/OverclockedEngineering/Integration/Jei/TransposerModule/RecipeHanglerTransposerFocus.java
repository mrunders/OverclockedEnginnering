package fr.mru.OverclockedEngineering.Integration.Jei.TransposerModule;

import fr.mru.OverclockedEngineering.Integration.Jei.TreeFarmer.RecipeCategorieTreeFarmer;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class RecipeHanglerTransposerFocus implements IRecipeHandler<RecipeWrapperTransposerFocus> {


	@Override
	public Class<RecipeWrapperTransposerFocus> getRecipeClass() {
		return RecipeWrapperTransposerFocus.class;
	}

	@Override
	public String getRecipeCategoryUid(RecipeWrapperTransposerFocus arg0) {
		return RecipeCategorieTransposerFocus.ID;
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(RecipeWrapperTransposerFocus arg0) {
		return arg0;
	}

	@Override
	public boolean isRecipeValid(RecipeWrapperTransposerFocus arg0) {
		return true;
	}

}
