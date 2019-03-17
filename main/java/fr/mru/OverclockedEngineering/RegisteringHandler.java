package fr.mru.OverclockedEngineering;

import fr.mru.OverclockedEngineeringEntity.AlienVillagers;
import fr.mru.OverclockedEngineeringEntity.EntityMadVillager;
import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import fr.mru.OverclockedengineeringBlocks.OverclockedEngineeringBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;

public class RegisteringHandler
{
	
    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
    	
    	for (Block block : OverclockedEngineeringBlocks.blockList)
    		event.getRegistry().register(block);
    	
    }
	
	
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
    	
    	for (Item item : OverclokedEngineeringItems.itemsList)
    		event.getRegistry().register(item);
    }
    
    @SubscribeEvent
    public void registerVillagers(RegistryEvent.Register<VillagerProfession> event) {

		AlienVillagers.init();
		
		for (VillagerProfession v : AlienVillagers.getVillagers())
			event.getRegistry().register(v);
    	
    }
    
    @SubscribeEvent
    public void registerEntitys(RegistryEvent.Register<EntityEntry> event) {
    	
    	EntityEntry entry = EntityEntryBuilder.create()
    		    .entity(EntityMadVillager.class)
    		    .id(new ResourceLocation("madvillager"), EntityMadVillager.getId())
    		    .name("Mad Villager")
    		    .egg(0xFFFFFF, 0xAAAAAA)
    		    .tracker(64, 20, false)
    		    .build();
    	
    	event.getRegistry().register(entry);
    }
	

}