package fr.mru.OverclockedEngineering.Tiles.rfbridge;

import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileManager;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.ContainerManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntityLockable;

public class ContainerRfBridge extends ContainerManager {

	public ContainerRfBridge(ATileManager tile, InventoryPlayer playerInventory) {
		super(tile, playerInventory);

	}

	@Override
	public boolean displaySlots(ATileManager tile, InventoryPlayer playerInventory) {
		return false;
	}
	

}
