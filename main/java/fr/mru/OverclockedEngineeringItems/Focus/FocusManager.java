package fr.mru.OverclockedEngineeringItems.Focus;

import java.util.ArrayList;

import fr.mru.OverclockedEngineering.Recipes.IRecipeManager;
import fr.mru.OverclockedEngineering.Recipes.RecipeSmelter;
import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class FocusManager extends Item {
	
	public static Item FOCUS_SMELTER = new SmelterFocus();
	
	public static ArrayList<Item> itemsList = new ArrayList<>();
	
	static {
		
		itemsList.add(FOCUS_SMELTER);
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
		
		return null;
	}

	public static boolean itemIsFocus(Item item) {
		
		return item instanceof FocusManager;
	}
}
