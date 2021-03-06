package fr.mru.OverclockedEngineeringItems.Focus;

import java.util.ArrayList;

import fr.mru.OverclockedEngineering.Recipes.ARecipeManager;
import fr.mru.OverclockedEngineering.Recipes.RecipeCompresion;
import fr.mru.OverclockedEngineering.Recipes.RecipeRecycler;
import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineering.Recipes.RecipesAlloy;
import fr.mru.OverclockedEngineering.Recipes.RecipesExtraction;
import fr.mru.OverclockedEngineering.Recipes.RecipesGear;
import fr.mru.OverclockedEngineering.Recipes.RecipesGrinder;
import fr.mru.OverclockedEngineering.Recipes.RecipesPlate;
import fr.mru.OverclockedEngineering.Recipes.RecipesSmelter;
import fr.mru.OverclockedEngineering.Recipes.RecipesTransposer;
import fr.mru.OverclockedEngineeringItems.EngineManager;
import fr.mru.OverclockedEngineeringItems.OverclockedEngineeringItemsBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class AFocusManager extends OverclockedEngineeringItemsBase {
	
	public abstract RecipeRequest getRecipeResult(ItemStack... ingredients);
	
	public static Item FOCUS_SMELTER = new SmelterFocus(),
					   FOCUS_GRINDER = new GrinderFocus(),
					   FOCUS_ALLOY   = new AlloyFocus(),
					   FOCUS_TRANSPOSER = new TransposerFocus(),
					   FOCUS_RECYCLER = new RecyclerFocus(),
					   FOCUS_COMPRESION = new CompresionFocus(),
					   FOCUS_DECOMPRESION = new DecompresionFocus(),
					   FOCUS_GEAR = new GearFocus(),
					   FOCUS_PLATE = new PlateFocus(),
					   FOCUS_EXTRACTION = new ExtractionFocus(),
					   FOCUS_PCB = new PCBFocus(),
					   FOCUS_SAWMILL = new SawMillFocus();
	
	public static ArrayList<Item> itemsList = new ArrayList<>();
	
	static {
		
		itemsList.add(FOCUS_SMELTER);
		itemsList.add(FOCUS_GRINDER);
		itemsList.add(FOCUS_ALLOY);
		itemsList.add(FOCUS_TRANSPOSER);
		itemsList.add(FOCUS_RECYCLER);
		itemsList.add(FOCUS_COMPRESION);
		itemsList.add(FOCUS_DECOMPRESION);
		itemsList.add(FOCUS_GEAR);
		itemsList.add(FOCUS_PLATE);
		itemsList.add(FOCUS_EXTRACTION);
		itemsList.add(FOCUS_PCB);
		itemsList.add(FOCUS_SAWMILL);
	}

	public AFocusManager(String NAME) {
		super(NAME);
		setMaxStackSize(1);
	}
	
	public static RecipeRequest getRecipeResult(Item focus, ItemStack... ingredients) {
		return ( itemIsFocus(focus) )? ((AFocusManager)focus).getRecipeResult(ingredients) : RecipeRequest.NULL;

	}

	public static boolean itemIsFocus(Item item) {
		return item instanceof AFocusManager;
	}
}
