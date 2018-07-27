package fr.mru.OverclockedEngineering.Tiles.TreeFarmer;

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

public class TreeFarmer extends ABlockContainerManager {

	public static final String DESCRIPTION = "Uncraft everything that was crafted with crafting table by right click on this block (cost 9 experience levels per uncraft)";

	public TreeFarmer() {		
		super("tree_farmer");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)  {
	    return new TileTreeFarmer();
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
	    TileEntity tileentity = worldIn.getTileEntity(pos);
	
	    if (tileentity instanceof TileTreeFarmer) {
	        InventoryHelper.dropInventoryItems(worldIn, pos,
	                (TileTreeFarmer) tileentity);
	    }
	
	    super.breakBlock(worldIn, pos, state);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	    if (world.isRemote) {
	        return true;
	    } else {
	        TileEntity tileentity = world.getTileEntity(pos);
	
	        if (tileentity instanceof TileTreeFarmer) {
	            player.openGui(OverclockedEngineering.instance, 0, world, pos.getX(),
	                    pos.getY(), pos.getZ());
	        }
	
	        return true;
	    }
	}
	
}
