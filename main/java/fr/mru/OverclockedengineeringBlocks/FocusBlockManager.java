package fr.mru.OverclockedengineeringBlocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;

public class FocusBlockManager extends OverclockedEngineeringBlocksBase {

	public static final Block FOCUS_BLOCK_EXTRACTION = new FocusBlockManager("focus_block_extraction");

	public static List<Block> focusblockList = new ArrayList<>();
	
	static {
		
		focusblockList.add(FOCUS_BLOCK_EXTRACTION);
	}
	
	public FocusBlockManager(String name) {
		super(name);
		
	}

}
