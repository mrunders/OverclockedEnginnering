package fr.mru.OverclockedEngineering.Tiles.DimensionalHole;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import fr.mru.OverclockedEngineering.Tiles.Machine.TileOverclockedFurnace;
import fr.mru.OverclockedengineeringBlocks.ABlockContainerManager;
import fr.mru.OverclockedengineeringBlocks.OverclockedEngineeringBlocks;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DHole extends ABlockContainerManager {

	public DHole() {		
		super("dimensional_hole");
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)  {
	    return new TileDHole();
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
	    TileEntity tileentity = worldIn.getTileEntity(pos);
	
	    if (tileentity instanceof TileDHole) {
	        InventoryHelper.dropInventoryItems(worldIn, pos,
	                (TileDHole) tileentity);
	    }
	
	    super.breakBlock(worldIn, pos, state);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	    if (world.isRemote) {
	        return true;
	    } else {
	        TileEntity tileentity = world.getTileEntity(pos);
	
	        if (tileentity instanceof TileDHole) {
	            player.openGui(OverclockedEngineering.instance, 0, world, pos.getX(),
	                    pos.getY(), pos.getZ());
	        }
	
	        return true;
	    }
	}
	
}
