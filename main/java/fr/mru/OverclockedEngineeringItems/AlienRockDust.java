package fr.mru.OverclockedEngineeringItems;

import fr.mru.OverclockedengineeringBlocks.OverclockedEngineeringBlocks;
import fr.mru.OverclockedengineeringBlocks.OverclockedEngineeringBlocksBase;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AlienRockDust extends OverclockedEngineeringItemsBase {

	public AlienRockDust() {
		super("alien_rock_dust");

	}
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		if ( !worldIn.isRemote ) {
		
			IBlockState blockState = worldIn.getBlockState(pos);
			Block block = blockState.getBlock();
			
			if ( block == Blocks.GRASS ) {
				worldIn.setBlockState(pos, OverclockedEngineeringBlocks.ALIEN_GRASS.getDefaultState());

				ItemStack stack = player.getHeldItem(hand);
				if ( stack.getItem() == OverclokedEngineeringItems.ALIEN_ROCK_DUST ) {
					stack.setCount(stack.getCount() - 1);
				}
			}
		}
		
        return EnumActionResult.PASS;
    }

}
