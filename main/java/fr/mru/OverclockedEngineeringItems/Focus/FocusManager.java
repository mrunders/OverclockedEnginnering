package fr.mru.OverclockedEngineeringItems.Focus;

import java.util.ArrayList;

import com.brandon3055.draconicevolution.blocks.machines.Grinder;

import fr.mru.OverclockedEngineering.Recipes.AlloyRecipes;
import fr.mru.OverclockedEngineering.Recipes.GrinderRecipes;
import fr.mru.OverclockedEngineering.Recipes.IRecipeManager;
import fr.mru.OverclockedEngineering.Recipes.RecipeSmelter;
import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class FocusManager extends Item {
	
	public static Item FOCUS_SMELTER = new SmelterFocus(),
					   FOCUS_GRINDER = new GrinderFocus(),
					   FOCUS_ALLOY   = new AlloyFocus();
	
	public static ArrayList<Item> itemsList = new ArrayList<>();
	
	static {
		
		itemsList.add(FOCUS_SMELTER);
		itemsList.add(FOCUS_GRINDER);
		itemsList.add(FOCUS_ALLOY);
		
	}

	public FocusManager(String NAME) {
		super();
		
		setCreativeTab(CreativeTabs.MISC);
		setMaxStackSize(1);
		OverclokedEngineeringItems.setItemName(this, NAME);
	}
	
	public static ItemStack getRecipeResult(Item focus, ItemStack[] ingredients) {
		
		if (focus instanceof SmelterFocus)
			return FurnaceRecipes.instance().getSmeltingResult(ingredients[0]);
		if (focus instanceof GrinderFocus)
			return GrinderRecipes.getRecipeResult(ingredients);
		if (focus instanceof AlloyFocus)
			return AlloyRecipes.getRecipeResult(ingredients);
		
		return null;
	}

	public static boolean itemIsFocus(Item item) {
		
		return item instanceof FocusManager;
	}
}
