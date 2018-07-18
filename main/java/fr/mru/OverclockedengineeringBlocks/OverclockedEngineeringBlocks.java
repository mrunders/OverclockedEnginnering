package fr.mru.OverclockedengineeringBlocks;

import java.util.ArrayList;

import net.minecraft.block.Block;

public class OverclockedEngineeringBlocks {
	
	public static final Block MACHINE_BLOCK = new MachineBlock(),
							  STACK_FURNACE = new StackFurnace(),
							  TREE_FARMER   = new TreeFarmer();
	
	public static ArrayList<Block> blockList = new ArrayList<>();
	
	static {
		
		blockList.add(MACHINE_BLOCK);
		blockList.add(STACK_FURNACE);
		blockList.add(TREE_FARMER);
	}
	
	public static void setBlockName(Block block, String name) {
		
		String m = fr.mru.OverclockedEngineering.OverclockedEngineering.MODID;
		block.setRegistryName(m, name).setUnlocalizedName(m + "." + name);
	}

}
