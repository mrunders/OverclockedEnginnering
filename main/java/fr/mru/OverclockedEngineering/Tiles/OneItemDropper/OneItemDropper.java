package fr.mru.OverclockedEngineering.Tiles.OneItemDropper;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import fr.mru.OverclockedengineeringBlocks.ABlockContainerManager;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class OneItemDropper extends ABlockContainerManager {

	public OneItemDropper() {
		super("one_item_dropper");
	}


	@Override
	public TileEntity createNewTileEntity(World world, int metadata)  {
	    return new TileOneItemDropper();
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
	    TileEntity tileentity = worldIn.getTileEntity(pos);

	    if (tileentity instanceof TileOneItemDropper) {
	        InventoryHelper.dropInventoryItems(worldIn, pos,
	                (TileOneItemDropper) tileentity);
	    }

	    super.breakBlock(worldIn, pos, state);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	    if (world.isRemote) {
	        return true;
	    } else {
	        TileEntity tileentity = world.getTileEntity(pos);

	        if (tileentity instanceof TileOneItemDropper) {
	            player.openGui(OverclockedEngineering.instance, 0, world, pos.getX(),
	                    pos.getY(), pos.getZ());
	        }

	        return true;
	    }
	}

}
