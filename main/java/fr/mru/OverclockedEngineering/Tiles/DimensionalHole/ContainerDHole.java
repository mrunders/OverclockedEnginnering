package fr.mru.OverclockedEngineering.Tiles.DimensionalHole;

import fr.mru.OverclockedEngineering.Tiles.ATileManager.ContainerManager;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.TileManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerDHole extends ContainerManager {

	public ContainerDHole(TileManager tile, InventoryPlayer playerInventory) {
		super(tile, playerInventory);
	}

	@Override
	public void displaySlots(TileManager tile, InventoryPlayer playerInventory) {
		
	    this.addSlotToContainer(new Slot(tile, 0, 35, 15));
		
	}
	



}
