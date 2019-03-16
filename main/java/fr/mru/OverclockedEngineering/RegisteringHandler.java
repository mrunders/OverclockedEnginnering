package fr.mru.OverclockedEngineering;

import fr.mru.OverclockedEngineeringEntity.AlienVillagers;
import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import fr.mru.OverclockedengineeringBlocks.OverclockedEngineeringBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
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
	

}