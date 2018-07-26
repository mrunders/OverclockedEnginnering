package fr.mru.OverclockedEngineering.Integration.Jei.DecompresionModule;

import fr.mru.OverclockedEngineering.Integration.Jei.GrinderModule.RecipeCategorieGrinderFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.GrinderModule.RecipeWrapperGrinderFocus;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class RecipeHandlerDecompresionModule implements IRecipeHandler<RecipeWrapperDecompresionFocus> {


	@Override
	public Class<RecipeWrapperDecompresionFocus> getRecipeClass() {
		return RecipeWrapperDecompresionFocus.class;
	}

	@Override
	public String getRecipeCategoryUid(RecipeWrapperDecompresionFocus arg0) {
		return RecipeCategorieDecompresionFocus.ID;
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(RecipeWrapperDecompresionFocus arg0) {
		return arg0;
	}

	@Override
	public boolean isRecipeValid(RecipeWrapperDecompresionFocus arg0) {
		return true;
	}

}
