package fr.mru.OverclockedengineeringBlocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;

public class EngineBlockManager extends OverclockedEngineeringBlocksBase {
	
	public static final Block HENGINE_BLOCK5 = new EngineBlockManager("hybride_engine_block5");

	public static List<Block> engineList = new ArrayList<>();
	
	static {
		
		engineList.add(HENGINE_BLOCK5);
	}
	
	public EngineBlockManager(String name) {
		super(name);
		
	}
}
