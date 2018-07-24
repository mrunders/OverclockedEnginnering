package fr.mru.OverclockedengineeringBlocks;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MachineCasing extends Block {
	
	public MachineCasing() {
		super(Material.ANVIL);
		
		OverclockedEngineeringBlocks.setBlockName(this, "machine_casing");
		setCreativeTab(OverclockedEngineering.overclockedTab);
	}

}
