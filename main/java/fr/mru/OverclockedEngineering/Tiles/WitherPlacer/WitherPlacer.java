package fr.mru.OverclockedEngineering.Tiles.WitherPlacer;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import fr.mru.OverclockedengineeringBlocks.ABlockContainerManager;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WitherPlacer extends ABlockContainerManager {

	public WitherPlacer() {
		super("wither_placer");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileWitherPlacer();
	}

	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	    if (world.isRemote) {
	        return true;
	    } else {
	        TileEntity tileentity = world.getTileEntity(pos);

	        if (tileentity instanceof TileWitherPlacer) {
	        	
	            player.openGui(OverclockedEngineering.instance, 0, world, pos.getX(),
	                    pos.getY(), pos.getZ());
	        }

	        return true;
	    }
	}
}
