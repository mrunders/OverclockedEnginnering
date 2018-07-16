package fr.mru.OverclockedEngineeringItems.Gears;

import java.util.ArrayList;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import net.minecraft.item.Item;

public class GearManager extends Item {

	public static final Item GEAR_WITHER = new GearWither(),
			 GEAR_WYVERN = new GearWyvern(),
			 GEAR_AWAKENED = new GearAwakened(),
			 GEAR_CHAOTIC = new GearChaotic();
	
	public static ArrayList<Item> itemsList = new ArrayList<>();

	static {
		itemsList.add(GEAR_WITHER);	
		itemsList.add(GEAR_WYVERN);
		itemsList.add(GEAR_AWAKENED);
		itemsList.add(GEAR_CHAOTIC);
	}
	
	public GearManager(String NAME) {
		super();
		
		OverclokedEngineeringItems.setItemName(this, NAME);
		setCreativeTab(OverclockedEngineering.overclockedTab);
	}
	
}
