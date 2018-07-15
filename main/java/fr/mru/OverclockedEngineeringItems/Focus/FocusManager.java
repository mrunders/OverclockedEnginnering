package fr.mru.OverclockedEngineeringItems.Focus;

import java.util.ArrayList;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineering.Recipes.RecipesAlloy;
import fr.mru.OverclockedEngineering.Recipes.RecipesGrinder;
import fr.mru.OverclockedEngineering.Recipes.RecipesSmelter;
import fr.mru.OverclockedEngineering.Recipes.RecipesTransposer;
import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class FocusManager extends Item {
	
	public static Item FOCUS_SMELTER = new SmelterFocus(),
					   FOCUS_GRINDER = new GrinderFocus(),
					   FOCUS_ALLOY   = new AlloyFocus(),
					   FOCUS_TRANSPOSER = new TransposerFocus();
	
	public static ArrayList<Item> itemsList = new ArrayList<>();
	
	static {
		
		itemsList.add(FOCUS_SMELTER);
		itemsList.add(FOCUS_GRINDER);
		itemsList.add(FOCUS_ALLOY);
		itemsList.add(FOCUS_TRANSPOSER);
		
	}

	public FocusManager(String NAME) {
		super();
		
		setCreativeTab(CreativeTabs.MISC);
		setMaxStackSize(1);
		OverclokedEngineeringItems.setItemName(this, NAME);
	}
	
	public static RecipeRequest getRecipeResult(Item focus, ItemStack[] ingredients) {
		
		if (focus instanceof SmelterFocus)
			return RecipesSmelter.getRecipeResult(ingredients);
		if (focus instanceof GrinderFocus)
			return RecipesGrinder.getRecipeResult(ingredients);
		if (focus instanceof AlloyFocus) 
			return RecipesAlloy.getRecipeResult(ingredients);
		if (focus instanceof TransposerFocus)
			return RecipesTransposer.getRecipeResult(ingredients);
		
		return RecipeRequest.NULL;
	}

	public static boolean itemIsFocus(Item item) {
		
		return item instanceof FocusManager;
	}
}
