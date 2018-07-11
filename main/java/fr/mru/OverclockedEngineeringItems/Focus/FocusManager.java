package fr.mru.OverclockedEngineeringItems.Focus;

import java.util.ArrayList;

import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

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

	public static boolean itemIsFocus(Item item) {
		
		return item instanceof FocusManager;
	}
}
