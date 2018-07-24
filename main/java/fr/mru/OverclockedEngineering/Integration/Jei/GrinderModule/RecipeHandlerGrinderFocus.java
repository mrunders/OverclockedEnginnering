package fr.mru.OverclockedEngineering.Integration.Jei.GrinderModule;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class RecipeHandlerGrinderFocus implements IRecipeHandler<RecipeWrapperGrinderFocus> {


	@Override
	public Class<RecipeWrapperGrinderFocus> getRecipeClass() {
		return RecipeWrapperGrinderFocus.class;
	}

	@Override
	public String getRecipeCategoryUid(RecipeWrapperGrinderFocus arg0) {
		return RecipeCategorieGrinderFocus.ID;
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(RecipeWrapperGrinderFocus arg0) {
		return arg0;
	}

	@Override
	public boolean isRecipeValid(RecipeWrapperGrinderFocus arg0) {
		return true;
	}

}
