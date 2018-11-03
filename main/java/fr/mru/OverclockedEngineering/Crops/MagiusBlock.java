package fr.mru.OverclockedEngineering.Crops;

import java.util.Random;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import fr.mru.OverclockedengineeringBlocks.OverclockedEngineeringBlocks;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MagiusBlock extends BlockCrops {

    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 3);

	public MagiusBlock() {
		super();
		
		OverclockedEngineeringBlocks.setBlockName(this, "magius_block_seed");
		setCreativeTab(OverclockedEngineering.overclockedTab);
	}
	
	@Override
    protected boolean canSustainBush(IBlockState state) {
        return state.getBlock() == OverclockedEngineeringBlocks.ALIEN_GRASS;
    }
	
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        IBlockState soil = worldIn.getBlockState(pos.down());
        return ( 0 == worldIn.getLight(pos) && canSustainBush(soil));
    }
	
    protected Item getSeed() {
        return null;
    }

    protected Item getCrop() {
        return OverclokedEngineeringItems.ALIEN_ROCK_DUST;
    }
    
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return this.isMaxAge(state) ? this.getCrop() : null;
    }
}
