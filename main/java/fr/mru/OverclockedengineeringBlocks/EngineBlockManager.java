package fr.mru.OverclockedengineeringBlocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.crafting.CraftingHelper;

public class EngineBlockManager extends OverclockedEngineeringBlocksBase {
	
	public static final Block HENGINE_BLOCK1 = new EngineBlockManager("hybride_engine_block1"),
			  				  HENGINE_BLOCK2 = new EngineBlockManager("hybride_engine_block2"),
			  				  HENGINE_BLOCK3 = new EngineBlockManager("hybride_engine_block3"),
							  HENGINE_BLOCK4 = new EngineBlockManager("hybride_engine_block4"),
	 	  					  HENGINE_BLOCK5 = new EngineBlockManager("hybride_engine_block5");

	public static List<Block> engineList = new ArrayList<>();
	
	static {

		engineList.add(HENGINE_BLOCK1);
		engineList.add(HENGINE_BLOCK2);
		engineList.add(HENGINE_BLOCK3);
		engineList.add(HENGINE_BLOCK4);
		engineList.add(HENGINE_BLOCK5);
		
	}
	
	public EngineBlockManager(String name) {
		super(name);
		
	}
}
