package fr.mru.OverclockedEngineering.Tiles.rfbridge;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import fr.mru.OverclockedengineeringBlocks.ABlockContainerManager;
import fr.mru.OverclockedengineeringBlocks.AOrientableBlockContainerManager;
import fr.mru.OverclockedengineeringBlocks.OverclockedEngineeringBlocks;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentKeybind;
import net.minecraft.world.World;

public class RfBridge extends ABlockContainerManager {
	
	public static final String DESCRIPTION = "After a long periode of reflection, you have finally found the way to mix alien and human technologie to make a device that transform RF into particules of energy";
	
	public RfBridge() {
		super("rf_bridge");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)  {
	    return new TileRfBridge();
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
	    if (world.isRemote) {
	        return true;
	    } else {
	        TileEntity tileentity = world.getTileEntity(pos);
	        
	        player.sendMessage( new TextComponentKeybind("Energy stored: " + ((TileRfBridge)tileentity).getEnergyStored(null)) );

	        return true;
	    }
	}

}
