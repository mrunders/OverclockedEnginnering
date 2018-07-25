package fr.mru.OverclockedEngineering.Integration.Jei.TransposerModule;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import fr.mru.OverclockedEngineeringItems.Focus.TransposerFocus;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RecipeCategorieTransposerFocus extends BlankRecipeCategory<RecipeWrapperTransposerFocus>{
	
	public static final String ID = "overclockedengineering.transposerfocus";
	public static final String TITLE = I18n.format("Transposer Focus");
	
	private IDrawable background = null;
	
	public RecipeCategorieTransposerFocus(IGuiHelper helper) {

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
	public void setRecipe(IRecipeLayout arg0, RecipeWrapperTransposerFocus arg1, IIngredients arg2) {
		
		IGuiItemStackGroup group = arg0.getItemStacks();
		
		group.init(0, true, 7, 1);
		group.init(1, true, 25, 1);
		group.init(2, false, 90, 11);
		
		group.set(0, arg2.getInputs(ItemStack.class).get(0).get(0));
		group.set(1, arg2.getInputs(ItemStack.class).get(0).get(1));
		group.set(2, arg2.getOutputs(ItemStack.class).get(0));
		
	}

}
