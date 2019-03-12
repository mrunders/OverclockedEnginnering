package fr.mru.OverclockedEngineering.Tiles.EnergyStorage;

import fr.mru.OverclockedengineeringBlocks.OverclockedEngineeringBlocksBase;

public class RFStorage extends OverclockedEngineeringBlocksBase {
		
	public RFStorage() {
		super("rf_storage_block");
	}

	/*
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
		
		return true;
	}*/

}
