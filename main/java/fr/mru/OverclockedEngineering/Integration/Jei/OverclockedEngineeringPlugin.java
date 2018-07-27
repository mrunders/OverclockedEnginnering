package fr.mru.OverclockedEngineering.Integration.Jei;

import fr.mru.OverclockedEngineering.Integration.Jei.AgingGun.RecipeCategorieAgingGun;
import fr.mru.OverclockedEngineering.Integration.Jei.AgingGun.RecipeMakerAgingGun;
import fr.mru.OverclockedEngineering.Integration.Jei.AgingGun.RecipeWrapperAgingGun;
import fr.mru.OverclockedEngineering.Integration.Jei.AlloyModule.RecipeCategorieAlloyFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.AlloyModule.RecipeMakerAlloyFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.AlloyModule.RecipeWrapperAlloyFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.CompresionModule.RecipeCategorieCompresionFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.CompresionModule.RecipeMakerCompresionFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.CompresionModule.RecipeWrapperCompresionFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.DecompresionModule.RecipeCategorieDecompresionFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.DecompresionModule.RecipeMakerDecompresionModule;
import fr.mru.OverclockedEngineering.Integration.Jei.DecompresionModule.RecipeWrapperDecompresionFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.GearModule.RecipeCategorieGearFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.GearModule.RecipeMakerGearFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.GearModule.RecipeWrapperGearFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.GrinderModule.RecipeCategorieGrinderFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.GrinderModule.RecipeMakerGrinderFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.GrinderModule.RecipeWrapperGrinderFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.PlateModule.RecipeCategoriePlateFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.PlateModule.RecipeMakerPlateFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.PlateModule.RecipeWrapperPlateFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.TransposerModule.RecipeCategorieTransposerFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.TransposerModule.RecipeMakerTransposerFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.TransposerModule.RecipeWrapperTransposerFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.TreeFarmer.RecipeCategorieTreeFarmer;
import fr.mru.OverclockedEngineering.Integration.Jei.TreeFarmer.RecipeMakerTreeFarmer;
import fr.mru.OverclockedEngineering.Integration.Jei.TreeFarmer.RecipeWrapperTreeFarmer;
import fr.mru.OverclockedEngineering.Tiles.Machine.ContainerOverclockedFurnace;
import fr.mru.OverclockedEngineering.Tiles.TreeFarmer.ContainerTreeFarmer;
import fr.mru.OverclockedEngineering.Tiles.TreeFarmer.TreeFarmer;
import fr.mru.OverclockedEngineeringItems.Circuit;
import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import fr.mru.OverclockedEngineeringItems.AgingGun.AgingGunManager;
import fr.mru.OverclockedEngineeringItems.Focus.FocusManager;
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
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerOverclockedFurnace.class, RecipeCategorieGrinderFocus.ID, 0,3,8,36);
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerOverclockedFurnace.class, RecipeCategorieAlloyFocus.ID, 0,3,8,36);
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerOverclockedFurnace.class, RecipeCategorieTransposerFocus.ID, 0,3,8,36);
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerOverclockedFurnace.class, RecipeCategorieCompresionFocus.ID, 0,3,8,36);
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerOverclockedFurnace.class, RecipeCategorieDecompresionFocus.ID, 0,3,8,36);
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerOverclockedFurnace.class, RecipeCategorieGearFocus.ID, 0,3,8,36);
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerOverclockedFurnace.class, RecipeCategoriePlateFocus.ID, 0,3,8,36);
		
		registry.addRecipeCategories(new RecipeCategorieTreeFarmer(registry.getJeiHelpers().getGuiHelper()));
		registry.addRecipeCategories(new RecipeCategorieGrinderFocus(registry.getJeiHelpers().getGuiHelper()));
		registry.addRecipeCategories(new RecipeCategorieAlloyFocus(registry.getJeiHelpers().getGuiHelper()));
		registry.addRecipeCategories(new RecipeCategorieAgingGun(registry.getJeiHelpers().getGuiHelper()));
		registry.addRecipeCategories(new RecipeCategorieTransposerFocus(registry.getJeiHelpers().getGuiHelper()));
		registry.addRecipeCategories(new RecipeCategorieCompresionFocus(registry.getJeiHelpers().getGuiHelper()));
		registry.addRecipeCategories(new RecipeCategorieDecompresionFocus(registry.getJeiHelpers().getGuiHelper()));
		registry.addRecipeCategories(new RecipeCategorieGearFocus(registry.getJeiHelpers().getGuiHelper()));
		registry.addRecipeCategories(new RecipeCategoriePlateFocus(registry.getJeiHelpers().getGuiHelper()));
		
		registry.addRecipeHandlers(new RecipeHandlerGeneric<RecipeWrapperTreeFarmer>(RecipeWrapperTreeFarmer.class, RecipeCategorieTreeFarmer.ID));
		registry.addRecipeHandlers(new RecipeHandlerGeneric<RecipeWrapperGrinderFocus>(RecipeWrapperGrinderFocus.class, RecipeCategorieGrinderFocus.ID));
		registry.addRecipeHandlers(new RecipeHandlerGeneric<RecipeWrapperAlloyFocus>(RecipeWrapperAlloyFocus.class, RecipeCategorieAlloyFocus.ID));
		registry.addRecipeHandlers(new RecipeHandlerGeneric<RecipeWrapperAgingGun>(RecipeWrapperAgingGun.class, RecipeCategorieAgingGun.ID));
		registry.addRecipeHandlers(new RecipeHandlerGeneric<RecipeWrapperTransposerFocus>(RecipeWrapperTransposerFocus.class, RecipeCategorieTransposerFocus.ID));
		registry.addRecipeHandlers(new RecipeHandlerGeneric<RecipeWrapperCompresionFocus>(RecipeWrapperCompresionFocus.class, RecipeCategorieCompresionFocus.ID));
		registry.addRecipeHandlers(new RecipeHandlerGeneric<RecipeWrapperDecompresionFocus>(RecipeWrapperDecompresionFocus.class, RecipeCategorieDecompresionFocus.ID));
		registry.addRecipeHandlers(new RecipeHandlerGeneric<RecipeWrapperGearFocus>(RecipeWrapperGearFocus.class, RecipeCategorieGearFocus.ID));
		registry.addRecipeHandlers(new RecipeHandlerGeneric<RecipeWrapperPlateFocus>(RecipeWrapperPlateFocus.class, RecipeCategoriePlateFocus.ID));
		
		registry.addRecipes(RecipeMakerTreeFarmer.getRecipes());
		registry.addRecipes(RecipeMakerGrinderFocus.getRecipes());
		registry.addRecipes(RecipeMakerAlloyFocus.getRecipes());
		registry.addRecipes(RecipeMakerAgingGun.getRecipes());
		registry.addRecipes(RecipeMakerTransposerFocus.getRecipes());
		registry.addRecipes(RecipeMakerCompresionFocus.getRecipes());
		registry.addRecipes(RecipeMakerDecompresionModule.getRecipes());
		registry.addRecipes(RecipeMakerGearFocus.getRecipes());
		registry.addRecipes(RecipeMakerPlateFocus.getRecipes());

		registry.addRecipeCategoryCraftingItem(new ItemStack(OverclockedEngineeringBlocks.STACK_FURNACE), VanillaRecipeCategoryUid.SMELTING);
		registry.addRecipeCategoryCraftingItem(new ItemStack(OverclockedEngineeringBlocks.TREE_FARMER), RecipeCategorieTreeFarmer.ID);
		
		registry.addRecipeCategoryCraftingItem(new ItemStack(FocusManager.FOCUS_TRANSPOSER), RecipeCategorieTransposerFocus.ID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(FocusManager.FOCUS_SMELTER), VanillaRecipeCategoryUid.SMELTING);
		registry.addRecipeCategoryCraftingItem(new ItemStack(FocusManager.FOCUS_GRINDER), RecipeCategorieGrinderFocus.ID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(FocusManager.FOCUS_ALLOY),   RecipeCategorieAlloyFocus.ID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(FocusManager.FOCUS_COMPRESION),   RecipeCategorieCompresionFocus.ID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(FocusManager.FOCUS_DECOMPRESION),   RecipeCategorieDecompresionFocus.ID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(FocusManager.FOCUS_GEAR),   RecipeCategorieGearFocus.ID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(FocusManager.FOCUS_PLATE),   RecipeCategoriePlateFocus.ID);
		
		registry.addRecipeCategoryCraftingItem(new ItemStack(OverclokedEngineeringItems.AGING_GUN_INCR), RecipeCategorieAgingGun.ID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(OverclokedEngineeringItems.AGING_GUN_DECR), RecipeCategorieAgingGun.ID);
		
		registry.addDescription(new ItemStack(OverclockedEngineeringBlocks.UNCRAFTING_TABLE), TreeFarmer.DESCRIPTION);
		registry.addDescription(new ItemStack(OverclokedEngineeringItems.AGING_GUN_INCR), AgingGunManager.DESCRIPTION);
		registry.addDescription(new ItemStack(OverclokedEngineeringItems.AGING_GUN_DECR), AgingGunManager.DESCRIPTION);
		registry.addDescription(new ItemStack(OverclokedEngineeringItems.CIRCUIT), Circuit.DESCRIPTION);

	}
	
}
