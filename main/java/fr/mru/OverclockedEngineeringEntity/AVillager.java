package fr.mru.OverclockedEngineeringEntity;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import fr.mru.OverclockedEngineeringItems.OverclockedEngineeringItemsBase;
import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import fr.mru.OverclockedengineeringBlocks.OverclockedEngineeringBlocks;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerCareer;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;

public class AVillager {

	public static VillagerProfession alien_passive;
	
	public static void init() {
		
		alien_passive = new VillagerProfession(
				OverclockedEngineering.MODID + ":alien_passive", 
				OverclockedEngineering.MODID + ":textures/entity/alien_passive/villager.png",
				OverclockedEngineering.MODID + ":textures/entity/alien_passive/zombie.png");
		
		VillagerCareer alien_passive_carrer = new VillagerCareer(alien_passive, OverclockedEngineering.MODID + ".strange_stuff");
		
		alien_passive_carrer.addTrade(1, new EntityVillager.EmeraldForItems(OverclokedEngineeringItems.ALIEN_ROCK_FRAGMENT, new EntityVillager.PriceInfo(1, 5)));
		alien_passive_carrer.addTrade(2, new EntityVillager.ListItemForEmeralds(OverclokedEngineeringItems.INGOT_STEEL, new EntityVillager.PriceInfo(-4, -8)));
		alien_passive_carrer.addTrade(3, new EntityVillager.ItemAndEmeraldToItem(OverclokedEngineeringItems.ALIEN_ROCK_FRAGMENT, new EntityVillager.PriceInfo(5, 10), 
																				OverclokedEngineeringItems.CATALYSER, new EntityVillager.PriceInfo(1, 1)));
	}
	
	

	

}
