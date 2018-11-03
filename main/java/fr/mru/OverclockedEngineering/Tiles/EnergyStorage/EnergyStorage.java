package fr.mru.OverclockedEngineering.Tiles.EnergyStorage;

import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import fr.mru.OverclockedengineeringBlocks.ABlockContainerManager;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentKeybind;
import net.minecraft.world.World;

public class EnergyStorage extends ABlockContainerManager {
		
	public EnergyStorage() {
		super("rf_storage_block");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)  {
	    return new TileRFStorage();
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
	    if (world.isRemote) {
	        return true;
	    } else {
	    	
	    	ItemStack i = player.getHeldItem(hand);
	        TileEntity tileentity = world.getTileEntity(pos);
	        
	        
	    	if ( i != null && i.getItem() == OverclokedEngineeringItems.RF_STORAGE_MODULE ) {
	    		
	    		if ( tileentity != null && tileentity instanceof TileRFStorage ) {
	    			TileRFStorage t = (TileRFStorage)tileentity;
	    			
	    			if ( t.upgrade() ) {

	    		        player.sendMessage( new TextComponentKeybind("Storage upgraded") );
	    		        i.setCount(i.getCount() -1);
	    			}
	    		}
	    		
	    	} else {
	    	
	    		TileRFStorage t = (TileRFStorage)tileentity;
		        player.sendMessage( new TextComponentKeybind("Energy stored: " + t.getEnergyStored(null) + " / " + t.getMaxEnergyStored(null) ) );

	    	}
	        return true;
	    }
	}

}
