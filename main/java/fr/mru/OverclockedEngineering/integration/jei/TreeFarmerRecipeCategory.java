package fr.mru.OverclockedEngineering.integration.jei;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.resources.I18n;

public class TreeFarmerRecipeCategory extends BlankRecipeCategory {
	
	private static final String ID = "overclockedEngineering.tree_farmer";
	private static final String title = I18n.format("gui.oe.treeFarmer.name");
	private static final IDrawable background = null;
	
	public TreeFarmerRecipeCategory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IDrawable getBackground() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getModName() {
		return OverclockedEngineering.MODID;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getUid() {
		return ID;
	}

	@Override
	public void setRecipe(IRecipeLayout arg0, IRecipeWrapper arg1, IIngredients arg2) {
		// TODO Auto-generated method stub
		
	}



}
