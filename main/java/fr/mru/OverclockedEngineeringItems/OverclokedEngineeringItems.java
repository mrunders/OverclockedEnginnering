package fr.mru.OverclockedEngineeringItems;

import java.util.ArrayList;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import fr.mru.OverclockedEngineeringItems.AgingGun.AgingGunDecremantal;
import fr.mru.OverclockedEngineeringItems.AgingGun.AgingGunIncremental;
import fr.mru.OverclockedEngineeringItems.Focus.AFocusManager;
import fr.mru.OverclockedengineeringBlocks.OverclockedEngineeringBlocks;
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
							 
							 MINING_PICKAXE = new MiningPickaxe(),
							 AGING_GUN_INCR = new AgingGunIncremental(),
							 AGING_GUN_DECR = new AgingGunDecremantal(),
							 
							 DIMENSIONAL_HOLE = new DHoleItem();
	
	public static final Item MACHINE_BLOCK_ITEM = new ItemBlock(OverclockedEngineeringBlocks.MACHINE_BLOCK).setRegistryName(OverclockedEngineeringBlocks.MACHINE_BLOCK.getRegistryName()),
							 STACK_FURNACE_ITEM = new ItemBlock(OverclockedEngineeringBlocks.STACK_FURNACE).setRegistryName(OverclockedEngineeringBlocks.STACK_FURNACE.getRegistryName()),
							 TREE_FARMER_ITEM   = new ItemBlock(OverclockedEngineeringBlocks.TREE_FARMER).setRegistryName(OverclockedEngineeringBlocks.TREE_FARMER.getRegistryName()),
							 UNCRAFTING_TABLE_ITEM = new ItemBlock(OverclockedEngineeringBlocks.UNCRAFTING_TABLE).setRegistryName(OverclockedEngineeringBlocks.UNCRAFTING_TABLE.getRegistryName()),
							 DIMENSIONAL_HOLE_ITEM = new ItemBlock(OverclockedEngineeringBlocks.DIMENSIONAL_HOLE).setRegistryName(OverclockedEngineeringBlocks.DIMENSIONAL_HOLE.getRegistryName()),
							 MACHINE_CASING_ITEM = new ItemBlock(OverclockedEngineeringBlocks.MACHINE_CASING).setRegistryName(OverclockedEngineeringBlocks.MACHINE_CASING.getRegistryName()),
							 MASS_ANVIL = new ItemBlock(OverclockedEngineeringBlocks.MASS_ANVIL).setRegistryName(OverclockedEngineeringBlocks.MASS_ANVIL.getRegistryName()),
							 TWO_MODULES_MACHINE = new ItemBlock(OverclockedEngineeringBlocks.TWO_MODULES_MACHINE).setRegistryName(OverclockedEngineeringBlocks.TWO_MODULES_MACHINE.getRegistryName()),
							 COBBLE_FORM_ITEM = new ItemBlock(OverclockedEngineeringBlocks.COBBLE_FORM).setRegistryName(OverclockedEngineeringBlocks.COBBLE_FORM.getRegistryName());
							 
	
	public static ArrayList<Item> itemsList = new ArrayList<>();
	
	static {

		itemsList.addAll(EngineManager.itemsList);
		itemsList.addAll(AFocusManager.itemsList);
		
		itemsList.add(CIRCUIT);
		itemsList.add(CIRCUIT_LARGE);
		itemsList.add(MINING_PICKAXE);
		itemsList.add(AGING_GUN_INCR);
		itemsList.add(AGING_GUN_DECR);
		itemsList.add(DIMENSIONAL_HOLE);
		
		itemsList.add(MACHINE_BLOCK_ITEM);
		itemsList.add(STACK_FURNACE_ITEM);
		itemsList.add(TREE_FARMER_ITEM);
		itemsList.add(UNCRAFTING_TABLE_ITEM);
		itemsList.add(DIMENSIONAL_HOLE_ITEM);
		itemsList.add(MACHINE_CASING_ITEM);
		itemsList.add(MASS_ANVIL);
		itemsList.add(TWO_MODULES_MACHINE);
		itemsList.add(COBBLE_FORM_ITEM);
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