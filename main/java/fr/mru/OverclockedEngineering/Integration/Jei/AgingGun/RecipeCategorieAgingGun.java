package fr.mru.OverclockedEngineering.Integration.Jei.AgingGun;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
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

public class RecipeCategorieAgingGun extends BlankRecipeCategory<RecipeWrapperAgingGun>{
	
	public static final String ID = "overclockedengineering.aginggun";
	public static final String TITLE = I18n.format("Aging Gun");
	
	private IDrawable background = null;
	
	public RecipeCategorieAgingGun(IGuiHelper helper) {

		background = helper.createDrawable(new ResourceLocation(OverclockedEngineering.MODID,"textures/gui/container/aginggun.png"), 30, 7, 110, 60);
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
	public void setRecipe(IRecipeLayout arg0, RecipeWrapperAgingGun arg1, IIngredients arg2) {
		
		IGuiItemStackGroup group = arg0.getItemStacks();
		
		group.init(0, true, 4, 20);
		group.init(1, true, 86, 20);
		group.init(2, false, 44, 4);
		group.init(3, false, 44, 36);
		
		group.set(0, arg2.getInputs(ItemStack.class).get(0));
		group.set(1, arg2.getOutputs(ItemStack.class).get(0));
		group.set(2, new ItemStack(OverclokedEngineeringItems.AGING_GUN_INCR));
		group.set(3, new ItemStack(OverclokedEngineeringItems.AGING_GUN_DECR));
		
	}

}
