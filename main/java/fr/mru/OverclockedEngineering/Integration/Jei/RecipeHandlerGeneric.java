package fr.mru.OverclockedEngineering.Integration.Jei;

import fr.mru.OverclockedEngineering.Integration.Jei.AlloyModule.RecipeCategorieAlloyFocus;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class RecipeHandlerGeneric<T extends IRecipeWrapper> implements IRecipeHandler<T> {

	private Class<T> recipeClass = null;
	private String id;
	
	public RecipeHandlerGeneric(Class<T> recipeClass, String recipeCategorieID){
		this.recipeClass = recipeClass;
		this.id = recipeCategorieID;
	}

	@Override
	public Class<T> getRecipeClass() {
		return recipeClass;
	}

	@Override
	public String getRecipeCategoryUid(T arg0) {
		return id;
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(T arg0) {
		return arg0;
	}

	@Override
	public boolean isRecipeValid(T arg0) {
		return true;
	}

}
