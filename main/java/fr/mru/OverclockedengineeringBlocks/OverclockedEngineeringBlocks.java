package fr.mru.OverclockedengineeringBlocks;

import java.util.ArrayList;

import fr.mru.OverclockedEngineering.Tiles.DimensionalHole.DHole;
import fr.mru.OverclockedEngineering.Tiles.Machine.MachineBlock;
import fr.mru.OverclockedEngineering.Tiles.StackFurnace.StackFurnace;
import fr.mru.OverclockedEngineering.Tiles.TreeFarmer.TreeFarmer;
import fr.mru.OverclockedEngineering.Tiles.UncraftingTable.UncraftingTable;
import net.minecraft.block.Block;

public class OverclockedEngineeringBlocks {
	
	public static final Block MACHINE_BLOCK = new MachineBlock(),
							  STACK_FURNACE = new StackFurnace(),
							  TREE_FARMER   = new TreeFarmer(),
							  UNCRAFTING_TABLE = new UncraftingTable(),
							  DIMENSIONAL_HOLE = new DHole();
	
	public static ArrayList<Block> blockList = new ArrayList<>();
	
	static {
		
		blockList.add(MACHINE_BLOCK);
		blockList.add(STACK_FURNACE);
		blockList.add(TREE_FARMER);
		blockList.add(UNCRAFTING_TABLE);
		blockList.add(DIMENSIONAL_HOLE);
	}
	
	public static void setBlockName(Block block, String name) {
		
		String m = fr.mru.OverclockedEngineering.OverclockedEngineering.MODID;
		block.setRegistryName(m, name).setUnlocalizedName(m + "." + name);
	}

}
