package fr.mru.OverclockedEngineeringItems;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Circuit extends Item {

	public Circuit() {
		super();
		
		OverclokedEngineeringItems.setItemName(this, "circuit");
		setCreativeTab(OverclockedEngineering.overclockedTab);
	}
}
