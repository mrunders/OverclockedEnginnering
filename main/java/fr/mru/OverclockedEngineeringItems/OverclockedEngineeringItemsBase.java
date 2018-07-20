package fr.mru.OverclockedEngineeringItems;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import net.minecraft.item.Item;

public class OverclockedEngineeringItemsBase extends Item {

	public OverclockedEngineeringItemsBase(String name) {
		
		super();
		
		OverclokedEngineeringItems.setItemName(this, name);
		setCreativeTab(OverclockedEngineering.overclockedTab);
	}
}
