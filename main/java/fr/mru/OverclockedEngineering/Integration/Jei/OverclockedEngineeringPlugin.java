package fr.mru.OverclockedEngineering.Integration.Jei;

import cofh.thermalexpansion.plugins.jei.machine.refinery.RefineryRecipeCategoryPotion;
import fr.mru.OverclockedEngineering.Integration.Jei.TransposerModule.RecipeCategorieTransposerFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.TransposerModule.RecipeHanglerTransposerFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.TransposerModule.RecipeMakerTransposerFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.TreeFarmer.RecipeCategorieTreeFarmer;
import fr.mru.OverclockedEngineering.Integration.Jei.TreeFarmer.RecipeHandlerTreeFarmer;
import fr.mru.OverclockedEngineering.Integration.Jei.TreeFarmer.RecipeMakerTreeFarmer;
import fr.mru.OverclockedEngineering.Tiles.Machine.ContainerOverclockedFurnace;
import fr.mru.OverclockedEngineering.Tiles.TreeFarmer.ContainerTreeFarmer;
import fr.mru.OverclockedEngineering.Tiles.TreeFarmer.GuiTreeFarmer;
import fr.mru.OverclockedEngineering.Tiles.TreeFarmer.TreeFarmer;
import fr.mru.OverclockedEngineeringItems.OverclockedEngineeringItemsBase;
import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import fr.mru.OverclockedEngineeringItems.Focus.TransposerFocus;
import fr.mru.OverclockedengineeringBlocks.OverclockedEngineeringBlocks;
import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class OverclockedEngineeringPlugin extends BlankModPlugin {

	@Override
	public void register(IModRegistry registry) {
		
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerTreeFarmer.class, RecipeCategorieTreeFarmer.ID, 0, 3, 8, 36);
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerOverclockedFurnace.class, RecipeCategorieTransposerFocus.ID, 0,3,8,36);
		
		registry.addRecipeClickArea(GuiTreeFarmer.class, 88, 32, 28, 23, RecipeCategorieTreeFarmer.ID);
		
		registry.addRecipeCategories(new RecipeCategorieTreeFarmer(registry.getJeiHelpers().getGuiHelper()));
		registry.addRecipeCategories(new RecipeCategorieTransposerFocus(registry.getJeiHelpers().getGuiHelper()));
		
		registry.addRecipeHandlers(new RecipeHandlerTreeFarmer());
		registry.addRecipeHandlers(new RecipeHanglerTransposerFocus());
		
		registry.addRecipes(RecipeMakerTreeFarmer.getRecipes());
		registry.addRecipes(RecipeMakerTransposerFocus.getRecipes());

		registry.addRecipeCategoryCraftingItem(new ItemStack(OverclockedEngineeringBlocks.STACK_FURNACE), VanillaRecipeCategoryUid.SMELTING);
		registry.addRecipeCategoryCraftingItem(new ItemStack(OverclockedEngineeringBlocks.MACHINE_BLOCK), VanillaRecipeCategoryUid.SMELTING);
		registry.addRecipeCategoryCraftingItem(new ItemStack(OverclockedEngineeringBlocks.TREE_FARMER), RecipeCategorieTreeFarmer.ID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(TransposerFocus.FOCUS_TRANSPOSER), RecipeCategorieTransposerFocus.ID);
		
		registry.addDescription(new ItemStack(OverclockedEngineeringBlocks.UNCRAFTING_TABLE), TreeFarmer.DESCRIPTION);

	}
}
