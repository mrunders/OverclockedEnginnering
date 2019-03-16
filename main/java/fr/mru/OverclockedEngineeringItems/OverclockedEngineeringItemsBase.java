package fr.mru.OverclockedEngineeringItems;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import net.minecraft.item.Item;

public class OverclockedEngineeringItemsBase extends Item {
	
	public static final String CIRCUIT_DESCRIPTION = "drop a mass anvil on iron block (iron block must be placed above obsidian)";

	public OverclockedEngineeringItemsBase(String name) {
		
		super();
		
		OverclokedEngineeringItems.setItemName(this, name);
		setCreativeTab(OverclockedEngineering.overclockedTab);
	}
}
