package fr.mru.OverclockedEngineeringItems;

import java.util.ArrayList;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import fr.mru.OverclockedEngineeringItems.AgingGun.AgingGunDecremantal;
import fr.mru.OverclockedEngineeringItems.AgingGun.AgingGunIncremental;
import fr.mru.OverclockedEngineeringItems.Focus.AFocusManager;
import fr.mru.OverclockedengineeringBlocks.EngineBlockManager;
import fr.mru.OverclockedengineeringBlocks.FocusBlockManager;
import fr.mru.OverclockedengineeringBlocks.OverclockedEngineeringBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@EventBusSubscriber(value = Side.CLIENT, modid = OverclockedEngineering.MODID)
public class OverclokedEngineeringItems {
	
	public static final Item CIRCUIT = new Circuit(),
							 CIRCUIT_LARGE = new CircuitLarge(),
							 INGOT_STEEL = new IngotSteel(),
							 //MINING_PICKAXE = new MiningPickaxe(),
							 AGING_GUN_INCR = new AgingGunIncremental(),
							 AGING_GUN_DECR = new AgingGunDecremantal(),
							 ALIEN_ROCK_FRAGMENT = new AlienRockFragment(),
							 DIMENSIONAL_HOLE = new DHoleItem(),
							 LOCATION_CARD = new LocationCard(),
							 ALIEN_ROCK_DUST = new AlienRockDust(),
							 RF_STORAGE_MODULE = new RfStorageModule();
	 
	
	public static ArrayList<Item> itemsList = new ArrayList<>();
	
	static {

		itemsList.addAll(EngineManager.itemsList);
		itemsList.addAll(AFocusManager.itemsList);
		
		itemsList.add(INGOT_STEEL);
		itemsList.add(CIRCUIT);
		itemsList.add(CIRCUIT_LARGE);
		//itemsList.add(MINING_PICKAXE);
		itemsList.add(AGING_GUN_INCR);
		itemsList.add(AGING_GUN_DECR);
		itemsList.add(DIMENSIONAL_HOLE);
		itemsList.add(ALIEN_ROCK_FRAGMENT);
		itemsList.add(LOCATION_CARD);
		itemsList.add(ALIEN_ROCK_DUST);
		itemsList.add(RF_STORAGE_MODULE);
		
		registerItemBlock(OverclockedEngineeringBlocks.TWO_MODULES_MACHINE,
				          OverclockedEngineeringBlocks.TREE_FARMER,
				          OverclockedEngineeringBlocks.STACK_FURNACE,
				          OverclockedEngineeringBlocks.MACHINE_BLOCK,
				          OverclockedEngineeringBlocks.DIMENSIONAL_HOLE,
				          OverclockedEngineeringBlocks.COBBLE_FORM,
				          OverclockedEngineeringBlocks.FILTER_CHEST,
				          OverclockedEngineeringBlocks.RF_BRIDGE,
				          OverclockedEngineeringBlocks.ALIEN_ROCK,
				          OverclockedEngineeringBlocks.MACHINE_CASING,
				          OverclockedEngineeringBlocks.MASS_ANVIL,
				          OverclockedEngineeringBlocks.UNCRAFTING_TABLE,
				          OverclockedEngineeringBlocks.TRANSPORTER_ITEMS,
				          OverclockedEngineeringBlocks.ALIEN_GRASS,
				          OverclockedEngineeringBlocks.RF_STORAGE_BLOCK,
				          OverclockedEngineeringBlocks.MAGIUS_BLOCK_SEED,
				          EngineBlockManager.HENGINE_BLOCK1, EngineBlockManager.HENGINE_BLOCK2,
				          EngineBlockManager.HENGINE_BLOCK3, EngineBlockManager.HENGINE_BLOCK4,
				          EngineBlockManager.HENGINE_BLOCK5,
				          OverclockedEngineeringBlocks.STRUCTURE_SHIP_BLOCK
				          );
		
		
	}
	
	public static void registerItemBlock(Block... block) {
		
		for (Block b : block)
			itemsList.add(new ItemBlock(b).setRegistryName(b.getRegistryName()));
	}

    public static void setItemName(Item item, String name) {
    	
    	item.setRegistryName(OverclockedEngineering.MODID, name).setUnlocalizedName(OverclockedEngineering.MODID + "." + name);
    }


	@SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerItemModels(ModelRegistryEvent event) {

    	for (Item i : itemsList) registerModel(i, 0);
    }

    @SideOnly(Side.CLIENT)
    public static void registerModel(Item item, int metadata) {
        if (metadata < 0) metadata = 0;
        String resourceName = item.getUnlocalizedName().substring(5).replace('.', ':');
        if (metadata > 0) resourceName += "_m" + String.valueOf(metadata);

        ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(resourceName, "inventory"));
    }
}