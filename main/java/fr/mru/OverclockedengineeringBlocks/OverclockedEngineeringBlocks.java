package fr.mru.OverclockedengineeringBlocks;

import java.util.ArrayList;

import fr.mru.OverclockedEngineering.Tiles.Cobble_form.CobbleForm;
import fr.mru.OverclockedEngineering.Tiles.DimensionalHole.DHole;
import fr.mru.OverclockedEngineering.Tiles.Machine.MachineBlock;
import fr.mru.OverclockedEngineering.Tiles.StackFurnace.StackFurnace;
import fr.mru.OverclockedEngineering.Tiles.TreeFarmer.TreeFarmer;
import fr.mru.OverclockedEngineering.Tiles.TwoModuleMachine.TwoModulesMachine;
import fr.mru.OverclockedEngineering.Tiles.UncraftingTable.UncraftingTable;
import net.minecraft.block.Block;
import net.minecraft.network.handshake.client.C00Handshake;

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
							  BLOCK_STEEL = new BlockSteel();
	
	public static ArrayList<Block> blockList = new ArrayList<>();
	
	static {
		
		blockList.add(MACHINE_BLOCK);
		blockList.add(STACK_FURNACE);
		blockList.add(TREE_FARMER);
		blockList.add(UNCRAFTING_TABLE);
		blockList.add(DIMENSIONAL_HOLE);
		blockList.add(MACHINE_CASING);
		blockList.add(MASS_ANVIL);
		blockList.add(TWO_MODULES_MACHINE);
		blockList.add(COBBLE_FORM);
		blockList.add(BLOCK_STEEL);
	}
	
	public static void setBlockName(Block block, String name) {
		
		String m = fr.mru.OverclockedEngineering.OverclockedEngineering.MODID;
		block.setRegistryName(m, name).setUnlocalizedName(m + "." + name);
	}

}
