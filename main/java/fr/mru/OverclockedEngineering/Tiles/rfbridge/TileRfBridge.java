package fr.mru.OverclockedEngineering.Tiles.rfbridge;

import cofh.redstoneflux.api.IEnergyReceiver;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileRFNrj;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileRfBridge extends ATileRFNrj implements IEnergyReceiver {
	
	public static final int MAX_ENERGY_STORED = 1000000;
	private boolean entityHasSpawned = false;
	private Entity enti = null;
	
	public TileRfBridge() {
		super("rf_bridge");
	}

	@Override
	public int getEnergyStored(EnumFacing from) {
		return energy_stored;
	}

	@Override
	public int getMaxEnergyStored(EnumFacing from) {
		return MAX_ENERGY_STORED;
	}

	@Override
	public boolean canConnectEnergy(EnumFacing from) {
		return true;
	}

	@Override
	public int receiveEnergy(EnumFacing from, int maxReceive, boolean simulate) {
		
		if ( energy_stored + maxReceive <= MAX_ENERGY_STORED ) {
			if ( !simulate ) 
				energy_stored += maxReceive;
			
		} else {
			maxReceive = MAX_ENERGY_STORED - energy_stored;
			
			if ( !simulate) 
				energy_stored = MAX_ENERGY_STORED;
		}
		
		return maxReceive;
	}

	@Override
	public Object getServerGuiElement(TileEntity te, InventoryPlayer inventory) {
		return new ContainerRfBridge((TileRfBridge)te, inventory);
	}

	@Override
	public Object getClientGuiElement(TileEntity te, InventoryPlayer inventory) {
		return new GuiRfBridge((TileRfBridge)te, inventory);
	}

	public boolean consume(int amount) {
		
		if ( amount <= energy_stored ) {
			energy_stored -= amount; 
			return true;
		} 
		
		return false;
	} 
	

	@Override
	public void update() {
		
		if ( !world.isRemote ) {
			
			
		}
		
	}

}
