package fr.mru.OverclockedEngineering.Integration.Jei.TreeFarmer;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class RecipeHandlerTreeFarmer implements IRecipeHandler<RecipeWrapperTreeFarmer> {


	@Override
	public Class<RecipeWrapperTreeFarmer> getRecipeClass() {
		return RecipeWrapperTreeFarmer.class;
	}

	@Override
	public String getRecipeCategoryUid(RecipeWrapperTreeFarmer arg0) {
		return RecipeCategorieTreeFarmer.ID;
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(RecipeWrapperTreeFarmer arg0) {
		return arg0;
	}

	@Override
	public boolean isRecipeValid(RecipeWrapperTreeFarmer arg0) {
		return true;
	}

}
