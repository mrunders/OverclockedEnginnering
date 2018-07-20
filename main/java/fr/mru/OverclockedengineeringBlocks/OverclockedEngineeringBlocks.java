package fr.mru.OverclockedengineeringBlocks;

import java.util.ArrayList;

import fr.mru.OverclockedEngineering.Machine.MachineBlock;
import fr.mru.OverclockedEngineering.StackFurnace.StackFurnace;
import fr.mru.OverclockedEngineering.TreeFarmer.TreeFarmer;
import fr.mru.OverclockedEngineering.UncraftingTable.UncraftingTable;
import net.minecraft.block.Block;

public class OverclockedEngineeringBlocks {
	
	public static final Block MACHINE_BLOCK = new MachineBlock(),
							  STACK_FURNACE = new StackFurnace(),
							  TREE_FARMER   = new TreeFarmer(),
							  UNCRAFTING_TABLE = new UncraftingTable();
	
	public static ArrayList<Block> blockList = new ArrayList<>();
	
	static {
		
		blockList.add(MACHINE_BLOCK);
		blockList.add(STACK_FURNACE);
		blockList.add(TREE_FARMER);
		blockList.add(UNCRAFTING_TABLE);
	}
	
	public static void setBlockName(Block block, String name) {
		
		String m = fr.mru.OverclockedEngineering.OverclockedEngineering.MODID;
		block.setRegistryName(m, name).setUnlocalizedName(m + "." + name);
	}

}
