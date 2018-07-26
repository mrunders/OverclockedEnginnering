package fr.mru.OverclockedEngineering.Integration.Jei.CompresionModule;

import fr.mru.OverclockedEngineering.Integration.Jei.GrinderModule.RecipeCategorieGrinderFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.GrinderModule.RecipeWrapperGrinderFocus;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class RecipeHandlerCompresionFocus implements IRecipeHandler<RecipeWrapperCompresionFocus> {


	@Override
	public Class<RecipeWrapperCompresionFocus> getRecipeClass() {
		return RecipeWrapperCompresionFocus.class;
	}

	@Override
	public String getRecipeCategoryUid(RecipeWrapperCompresionFocus arg0) {
		return RecipeCategorieCompresionFocus.ID;
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(RecipeWrapperCompresionFocus arg0) {
		return arg0;
	}

	@Override
	public boolean isRecipeValid(RecipeWrapperCompresionFocus arg0) {
		return true;
	}

}
