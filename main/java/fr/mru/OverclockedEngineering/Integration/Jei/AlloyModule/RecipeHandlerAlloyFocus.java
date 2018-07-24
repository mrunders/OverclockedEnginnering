package fr.mru.OverclockedEngineering.Integration.Jei.AlloyModule;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class RecipeHandlerAlloyFocus implements IRecipeHandler<RecipeWrapperAlloyFocus> {


	@Override
	public Class<RecipeWrapperAlloyFocus> getRecipeClass() {
		return RecipeWrapperAlloyFocus.class;
	}

	@Override
	public String getRecipeCategoryUid(RecipeWrapperAlloyFocus arg0) {
		return RecipeCategorieAlloyFocus.ID;
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(RecipeWrapperAlloyFocus arg0) {
		return arg0;
	}

	@Override
	public boolean isRecipeValid(RecipeWrapperAlloyFocus arg0) {
		return true;
	}

}
