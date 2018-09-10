package fr.mru.OverclockedEngineering.Tiles.DimensionalHole;

import fr.mru.OverclockedEngineering.Tiles.ATileManager.ContainerManager;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerDHole extends ContainerManager {

	public ContainerDHole(ATileManager tile, InventoryPlayer playerInventory) {
		super(tile, playerInventory);
	}

	@Override
	public boolean displaySlots(ATileManager tile, InventoryPlayer playerInventory) {
		
	    this.addSlotToContainer(new Slot(tile, 0, 80, 25));

	    return false;
	}
	



}
