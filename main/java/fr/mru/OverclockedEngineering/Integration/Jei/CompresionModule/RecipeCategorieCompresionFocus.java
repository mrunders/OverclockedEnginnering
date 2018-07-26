package fr.mru.OverclockedEngineering.Integration.Jei.CompresionModule;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RecipeCategorieCompresionFocus extends BlankRecipeCategory<RecipeWrapperCompresionFocus>{
	
	public static final String ID = "overclockedengineering.compresionfocus";
	public static final String TITLE = I18n.format("Compresion Focus");
	
	private IDrawable background = null;
	
	public RecipeCategorieCompresionFocus(IGuiHelper helper) {

		background = helper.createDrawable(new ResourceLocation(OverclockedEngineering.MODID,"textures/gui/container/overclocked_furnace.png"), 25, 5, 120, 70);
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
	public void setRecipe(IRecipeLayout arg0, RecipeWrapperCompresionFocus arg1, IIngredients arg2) {
		
		IGuiItemStackGroup group = arg0.getItemStacks();
		
		group.init(0, true, 7, 1);
		group.init(1, false, 90, 11);
		
		group.set(0, arg2.getInputs(ItemStack.class).get(0));
		group.set(1, arg2.getOutputs(ItemStack.class).get(0));
		
	}

}
