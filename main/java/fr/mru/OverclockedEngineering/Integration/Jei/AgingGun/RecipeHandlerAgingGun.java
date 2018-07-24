package fr.mru.OverclockedEngineering.Integration.Jei.AgingGun;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class RecipeHandlerAgingGun implements IRecipeHandler<RecipeWrapperAgingGun> {


	@Override
	public Class<RecipeWrapperAgingGun> getRecipeClass() {
		return RecipeWrapperAgingGun.class;
	}

	@Override
	public String getRecipeCategoryUid(RecipeWrapperAgingGun arg0) {
		return RecipeCategorieAgingGun.ID;
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(RecipeWrapperAgingGun arg0) {
		return arg0;
	}

	@Override
	public boolean isRecipeValid(RecipeWrapperAgingGun arg0) {
		return true;
	}

}
