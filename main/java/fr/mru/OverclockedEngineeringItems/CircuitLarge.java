package fr.mru.OverclockedEngineeringItems;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import net.minecraft.item.Item;

public class CircuitLarge extends Item {

	public CircuitLarge() {
		super();
		
		OverclokedEngineeringItems.setItemName(this, "circuit_large");
		setCreativeTab(OverclockedEngineering.overclockedTab);
	}
}
