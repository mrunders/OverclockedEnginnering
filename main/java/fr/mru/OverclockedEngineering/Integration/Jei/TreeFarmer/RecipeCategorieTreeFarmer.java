package fr.mru.OverclockedEngineering.Integration.Jei.TreeFarmer;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RecipeCategorieTreeFarmer extends BlankRecipeCategory<RecipeWrapperTreeFarmer>{
	
	public static final String ID = "overclockedengineering.treefarmer";
	public static final String TITLE = I18n.format("Tree Farmer");
	
	private IDrawable background = null;
	
	public RecipeCategorieTreeFarmer(IGuiHelper helper) {

		background = helper.createDrawable(new ResourceLocation(OverclockedEngineering.MODID,"textures/gui/container/tree_farmer.png"), 30, 10, 120, 60);
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public String getModName() {
		return OverclockedEngineering.MODID;
	}

	@Override
	public String getTitle() {
		return TITLE;
	}

	@Override
	public String getUid() {
		return ID;
	}

	@Override
	public void setRecipe(IRecipeLayout arg0, RecipeWrapperTreeFarmer arg1, IIngredients arg2) {
		
		IGuiItemStackGroup group = arg0.getItemStacks();
		
		group.init(0, true, 4, 4);
		group.init(1, true, 4, 39);
		group.init(2, false, 69, 21);
		
		group.set(0, arg2.getInputs(ItemStack.class).get(0));
		group.set(1, new ItemStack(Items.BONE, 2));
		
		group.set(2, arg2.getOutputs(ItemStack.class).get(0));
		
	}

}
