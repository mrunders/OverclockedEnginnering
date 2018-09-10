package fr.mru.OverclockedEngineering.Tiles.ATileManager;

import cofh.redstoneflux.api.IEnergyReceiver;
import net.minecraft.tileentity.TileEntityLockable;

public abstract class ATileRFConsumer extends ATileManagerEnergy implements IEnergyReceiver {

	public ATileRFConsumer(String name) {
		super(0, name);

	}
	

}
