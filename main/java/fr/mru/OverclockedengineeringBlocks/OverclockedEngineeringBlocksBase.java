package fr.mru.OverclockedengineeringBlocks;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class OverclockedEngineeringBlocksBase extends Block {

	public OverclockedEngineeringBlocksBase(String name) {
		super(Material.ANVIL);
		
		OverclockedEngineeringBlocks.setBlockName(this, name);
		setCreativeTab(OverclockedEngineering.overclockedTab);
	}

}
