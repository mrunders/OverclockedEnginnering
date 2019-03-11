package fr.mru.OverclockedEngineering.Tiles.EnergyStorage;

import cofh.redstoneflux.api.IEnergyProvider;
import cofh.redstoneflux.api.IEnergyReceiver;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileManagerEnergy;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileRFStorage extends ATileManagerEnergy implements IEnergyReceiver, IEnergyProvider {

	private static final int PER_UPGRADE = 100000;
	private int maxEnergyStored = 0;
	

	public TileRFStorage() {
		super(0, "rf_storage_module");
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
	    
		super.readFromNBT(compound);
	    this.maxEnergyStored = compound.getInteger("maxEnergyStored");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
	    
		compound = super.writeToNBT(compound);
	    compound.setInteger("maxEnergyStored", this.maxEnergyStored);

	    return compound;
	}

	@Override
	public Object getServerGuiElement(TileEntity te, InventoryPlayer inventory) {
		return null;
	}

	@Override
	public Object getClientGuiElement(TileEntity te, InventoryPlayer inventory) {
		return null;
	}

	public boolean upgrade() {
		
		if ( energy_stored + PER_UPGRADE < Integer.MAX_VALUE ) {
		
			maxEnergyStored += PER_UPGRADE;
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean canConnectEnergy(EnumFacing from) {
		return true;
	}

	@Override
	public int receiveEnergy(EnumFacing from, int maxReceive, boolean simulate) {
		
		if ( energy_stored + maxReceive <= maxEnergyStored ) {
			if ( !simulate ) 
				energy_stored += maxReceive;
			
		} else {
			maxReceive = maxEnergyStored + energy_stored;
			
			if ( !simulate) 
				energy_stored = maxEnergyStored;
		}
		
		return maxReceive;
	}

	@Override
	public int extractEnergy(EnumFacing from,int maxExtract, boolean simulate)  {
		
		if ( energy_stored - maxExtract < 0) {
			
			maxExtract = energy_stored;
			if ( !simulate )
				energy_stored = 0;
		} else {
			
			if ( !simulate )
				energy_stored -= maxExtract;
		}
		
		return maxExtract;
	}

	@Override
	public int getEnergyStored(EnumFacing from) {
		return energy_stored;
	}

	@Override
	public int getMaxEnergyStored(EnumFacing from) {
		return maxEnergyStored;
	}
	

	@Override
	public void update() {

	}	

}
