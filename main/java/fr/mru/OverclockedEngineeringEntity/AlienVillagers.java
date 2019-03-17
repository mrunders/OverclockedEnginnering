package fr.mru.OverclockedEngineeringEntity;

import java.util.ArrayList;
import java.util.List;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerCareer;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;

public class AlienVillagers {
	
	public static VillagerProfession alien_passive,
									 alien_mad;
	
	private static List<VillagerProfession> villages = new ArrayList<>();
	
	public static void alien_passive() {
		
		alien_passive = new VillagerProfession(
				OverclockedEngineering.MODID + ":alien_passive", 
				OverclockedEngineering.MODID + ":textures/entity/alien_passive/villager.png",
				OverclockedEngineering.MODID + ":textures/entity/alien_passive/zombie.png");
		
		VillagerCareer alien_passive_carrer = new VillagerCareer(alien_passive, OverclockedEngineering.MODID + ".strange_stuff");
		
		alien_passive_carrer.addTrade(1, new EntityVillager.EmeraldForItems(OverclokedEngineeringItems.ALIEN_ROCK_FRAGMENT, new EntityVillager.PriceInfo(1, 5)));
		alien_passive_carrer.addTrade(2, new EntityVillager.ListItemForEmeralds(OverclokedEngineeringItems.INGOT_STEEL, new EntityVillager.PriceInfo(-8, -4)));
		alien_passive_carrer.addTrade(3, new EntityVillager.ItemAndEmeraldToItem(OverclokedEngineeringItems.ALIEN_ROCK_FRAGMENT, new EntityVillager.PriceInfo(5, 10), 
																				OverclokedEngineeringItems.CATALYSER, new EntityVillager.PriceInfo(1, 1)));
		
		villages.add(alien_passive);
		
	}
	
	public static void alien_mad() {
		
		alien_mad = new VillagerProfession(
				OverclockedEngineering.MODID + ":alien_mad", 
				OverclockedEngineering.MODID + ":textures/entity/alien_mad/villager.png",
				OverclockedEngineering.MODID + ":textures/entity/alien_mad/zombie.png");
		
		VillagerCareer alien_passive_carrer = new VillagerCareer(alien_mad, OverclockedEngineering.MODID + ".notting_to_trade");
		
		villages.add(alien_mad);
	}
	
	public static void init() {
		
		alien_passive();
		alien_mad();
		
	}
	
	public static List<VillagerProfession> getVillagers(){
		return villages;
	}
	
	

	

}
