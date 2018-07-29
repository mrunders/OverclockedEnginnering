package fr.mru.OverclockedengineeringBlocks;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class OverclockedEngineeringBlocksBase extends Block {

	public OverclockedEngineeringBlocksBase(String name) {
		super(Material.ANVIL);
		
		OverclockedEngineeringBlocks.setBlockName(this, name);
		setCreativeTab(OverclockedEngineering.overclockedTab);

	}
	
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

}
