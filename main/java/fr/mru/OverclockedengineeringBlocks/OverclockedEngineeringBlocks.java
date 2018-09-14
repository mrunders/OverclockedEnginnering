package fr.mru.OverclockedengineeringBlocks;

import java.util.ArrayList;

import fr.mru.OverclockedEngineering.Tiles.Cobble_form.CobbleForm;
import fr.mru.OverclockedEngineering.Tiles.DimensionalHole.DHole;
import fr.mru.OverclockedEngineering.Tiles.FilterChest.FilterChest;
import fr.mru.OverclockedEngineering.Tiles.Machine.MachineBlock;
import fr.mru.OverclockedEngineering.Tiles.StackFurnace.StackFurnace;
import fr.mru.OverclockedEngineering.Tiles.TransporterItems.TransporterItems;
import fr.mru.OverclockedEngineering.Tiles.TreeFarmer.TreeFarmer;
import fr.mru.OverclockedEngineering.Tiles.TwoModuleMachine.TwoModulesMachine;
import fr.mru.OverclockedEngineering.Tiles.UncraftingTable.UncraftingTable;
import fr.mru.OverclockedEngineering.Tiles.rfbridge.RfBridge;
import net.minecraft.block.Block;

public class OverclockedEngineeringBlocks {
	
	public static final Block MACHINE_BLOCK = new MachineBlock(),
							  STACK_FURNACE = new StackFurnace(),
							  TREE_FARMER   = new TreeFarmer(),
							  UNCRAFTING_TABLE = new UncraftingTable(),
							  DIMENSIONAL_HOLE = new DHole(),
							  MACHINE_CASING = new MachineCasing(),
							  MASS_ANVIL     = new MassAnvil(),
							  TWO_MODULES_MACHINE = new TwoModulesMachine(),
							  COBBLE_FORM = new CobbleForm(),
							  FILTER_CHEST = new FilterChest(),
							  ALIEN_ROCK = new AlienRock(),
							  RF_BRIDGE = new RfBridge(),
							  TRANSPORTER_ITEMS = new TransporterItems();
	
	public static ArrayList<Block> blockList = new ArrayList<>();
	
	static {
		
		blockList.addAll(EngineBlockManager.engineList);
		
		blockList.add(MACHINE_BLOCK);
		blockList.add(STACK_FURNACE);
		blockList.add(TREE_FARMER);
		blockList.add(UNCRAFTING_TABLE);
		blockList.add(DIMENSIONAL_HOLE);
		blockList.add(MACHINE_CASING);
		blockList.add(MASS_ANVIL);
		blockList.add(TWO_MODULES_MACHINE);
		blockList.add(COBBLE_FORM);
		//blockList.add(FILTER_CHEST);
		blockList.add(ALIEN_ROCK);
		blockList.add(RF_BRIDGE);
		blockList.add(TRANSPORTER_ITEMS);
	}
	
	public static void setBlockName(Block block, String name) {
		
		String m = fr.mru.OverclockedEngineering.OverclockedEngineering.MODID;
		block.setRegistryName(m, name).setUnlocalizedName(m + "." + name);
	}

}
