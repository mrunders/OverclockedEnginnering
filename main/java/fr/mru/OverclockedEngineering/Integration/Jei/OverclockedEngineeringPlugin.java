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
import fr.mru.OverclockedEngineering.Integration.Jei.ExtractionModule.RecipeCategorieExtractionFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.ExtractionModule.RecipeMakerExtractionFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.ExtractionModule.RecipeWrapperExtractionFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.GearModule.RecipeCategorieGearFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.GearModule.RecipeMakerGearFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.GearModule.RecipeWrapperGearFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.GrinderModule.RecipeCategorieGrinderFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.GrinderModule.RecipeMakerGrinderFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.GrinderModule.RecipeWrapperGrinderFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.PCBFocus.RecipeCategoriePCBFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.PCBFocus.RecipeMakerPCBFocus;
import fr.mru.OverclockedEngineering.Integration.Jei.PCBFocus.RecipeWrapperPCBFocus;
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
import fr.mru.OverclockedEngineeringItems.Focus.AFocusManager;
import fr.mru.OverclockedengineeringBlocks.OverclockedEngineeringBlocks;
import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class OverclockedEngineeringPlugin extends BlankModPlugin {

	@Override
	public void register(IModRegistry registry) {
		
		IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();
		
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerTreeFarmer.class, RecipeCategorieTreeFarmer.ID, 0, 3, 8, 36);
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerOverclockedFurnace.class, RecipeCategorieGrinderFocus.ID, 0,3,8,36);
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerOverclockedFurnace.class, RecipeCategorieAlloyFocus.ID, 0,3,8,36);
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerOverclockedFurnace.class, RecipeCategorieTransposerFocus.ID, 0,3,8,36);
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerOverclockedFurnace.class, RecipeCategorieCompresionFocus.ID, 0,3,8,36);
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerOverclockedFurnace.class, RecipeCategorieDecompresionFocus.ID, 0,3,8,36);
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerOverclockedFurnace.class, RecipeCategorieGearFocus.ID, 0,3,8,36);
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerOverclockedFurnace.class, RecipeCategoriePlateFocus.ID, 0,3,8,36);
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerOverclockedFurnace.class, RecipeCategorieExtractionFocus.ID, 0,3,8,36);
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerOverclockedFurnace.class, RecipeCategoriePCBFocus.ID, 0,3,8,36);
		
		registry.addRecipeCategories(new RecipeCategorieTreeFarmer(guiHelper),
									 new RecipeCategorieGrinderFocus(guiHelper),
									 new RecipeCategorieAlloyFocus(guiHelper),
									 new RecipeCategorieAgingGun(guiHelper),
									 new RecipeCategorieTransposerFocus(guiHelper),
									 new RecipeCategorieCompresionFocus(guiHelper),
									 new RecipeCategorieDecompresionFocus(guiHelper),
									 new RecipeCategorieGearFocus(guiHelper),
									 new RecipeCategoriePlateFocus(guiHelper),
									 new RecipeCategorieExtractionFocus(guiHelper),
									 new RecipeCategoriePCBFocus(guiHelper)
		);
		
		registry.addRecipeHandlers(  new RecipeHandlerGeneric<RecipeWrapperTreeFarmer>(RecipeWrapperTreeFarmer.class, RecipeCategorieTreeFarmer.ID),
				                     new RecipeHandlerGeneric<RecipeWrapperGrinderFocus>(RecipeWrapperGrinderFocus.class, RecipeCategorieGrinderFocus.ID),
									 new RecipeHandlerGeneric<RecipeWrapperAlloyFocus>(RecipeWrapperAlloyFocus.class, RecipeCategorieAlloyFocus.ID),
									 new RecipeHandlerGeneric<RecipeWrapperAgingGun>(RecipeWrapperAgingGun.class, RecipeCategorieAgingGun.ID),
									 new RecipeHandlerGeneric<RecipeWrapperTransposerFocus>(RecipeWrapperTransposerFocus.class, RecipeCategorieTransposerFocus.ID),
									 new RecipeHandlerGeneric<RecipeWrapperCompresionFocus>(RecipeWrapperCompresionFocus.class, RecipeCategorieCompresionFocus.ID),
									 new RecipeHandlerGeneric<RecipeWrapperDecompresionFocus>(RecipeWrapperDecompresionFocus.class, RecipeCategorieDecompresionFocus.ID),
									 new RecipeHandlerGeneric<RecipeWrapperGearFocus>(RecipeWrapperGearFocus.class, RecipeCategorieGearFocus.ID),
									 new RecipeHandlerGeneric<RecipeWrapperPlateFocus>(RecipeWrapperPlateFocus.class, RecipeCategoriePlateFocus.ID),
									 new RecipeHandlerGeneric<RecipeWrapperExtractionFocus>(RecipeWrapperExtractionFocus.class, RecipeCategorieExtractionFocus.ID),
									 new RecipeHandlerGeneric<RecipeWrapperPCBFocus>(RecipeWrapperPCBFocus.class, RecipeCategoriePCBFocus.ID)
		);
		

		ItemStack[] items = {new ItemStack(OverclockedEngineeringBlocks.STACK_FURNACE),
							 new ItemStack(OverclockedEngineeringBlocks.TREE_FARMER),
							 new ItemStack(OverclokedEngineeringItems.AGING_GUN_INCR),
							 new ItemStack(OverclokedEngineeringItems.AGING_GUN_DECR),
							 new ItemStack(AFocusManager.FOCUS_TRANSPOSER),
							 new ItemStack(AFocusManager.FOCUS_SMELTER),
							 new ItemStack(AFocusManager.FOCUS_GRINDER),
							 new ItemStack(AFocusManager.FOCUS_ALLOY),
							 new ItemStack(AFocusManager.FOCUS_COMPRESION),
							 new ItemStack(AFocusManager.FOCUS_DECOMPRESION),
							 new ItemStack(AFocusManager.FOCUS_GEAR),
							 new ItemStack(AFocusManager.FOCUS_PLATE),
							 new ItemStack(AFocusManager.FOCUS_EXTRACTION),
							 new ItemStack(AFocusManager.FOCUS_PCB),
		};
		
		String[] id = {
				VanillaRecipeCategoryUid.SMELTING,
				RecipeCategorieTreeFarmer.ID,
				RecipeCategorieAgingGun.ID,
				RecipeCategorieAgingGun.ID,
				RecipeCategorieTransposerFocus.ID,
				VanillaRecipeCategoryUid.SMELTING,
				RecipeCategorieGrinderFocus.ID,
				RecipeCategorieAlloyFocus.ID,
				RecipeCategorieCompresionFocus.ID,
				RecipeCategorieDecompresionFocus.ID,
				RecipeCategorieGearFocus.ID,
				RecipeCategoriePlateFocus.ID,
				RecipeCategorieExtractionFocus.ID,
				RecipeCategoriePCBFocus.ID,
		};
		
		for ( int i = 0; i < id.length; ++i )
			registry.addRecipeCategoryCraftingItem(items[i], id[i]);
		
		
		registry.addRecipes(RecipeMakerTreeFarmer.getRecipes());
		registry.addRecipes(RecipeMakerGrinderFocus.getRecipes());
		registry.addRecipes(RecipeMakerAlloyFocus.getRecipes());
		registry.addRecipes(RecipeMakerAgingGun.getRecipes());
		registry.addRecipes(RecipeMakerTransposerFocus.getRecipes());
		registry.addRecipes(RecipeMakerCompresionFocus.getRecipes());
		registry.addRecipes(RecipeMakerDecompresionModule.getRecipes());
		registry.addRecipes(RecipeMakerGearFocus.getRecipes());
		registry.addRecipes(RecipeMakerPlateFocus.getRecipes());
		registry.addRecipes(RecipeMakerExtractionFocus.getRecipes());
		registry.addRecipes(RecipeMakerPCBFocus.getRecipes());
		
		registry.addDescription(new ItemStack(OverclockedEngineeringBlocks.UNCRAFTING_TABLE), TreeFarmer.DESCRIPTION);
		registry.addDescription(new ItemStack(OverclokedEngineeringItems.AGING_GUN_INCR), AgingGunManager.DESCRIPTION);
		registry.addDescription(new ItemStack(OverclokedEngineeringItems.AGING_GUN_DECR), AgingGunManager.DESCRIPTION);
		registry.addDescription(new ItemStack(OverclokedEngineeringItems.CIRCUIT), Circuit.DESCRIPTION);

	}
	
}
