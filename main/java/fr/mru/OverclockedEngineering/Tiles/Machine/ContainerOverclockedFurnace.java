package fr.mru.OverclockedEngineering.Tiles.Machine;

import fr.mru.OverclockedEngineering.Tiles.ATileManager.ContainerManager;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.SlotOutput;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.TileManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerOverclockedFurnace extends ContainerManager {
	
	private TileOverclockedFurnace tile;
	private int	timePassed = 0;
	private int	burnTimeLeft = 0;

	public ContainerOverclockedFurnace(TileOverclockedFurnace tile, InventoryPlayer playerInventory) {
		super(tile, playerInventory);
	}

	@Override
	public void displaySlots(TileManager tile, InventoryPlayer playerInventory) {
		
	    int i;
	    for(i = 0; i < 3; i++) {
	        this.addSlotToContainer(new Slot(tile, i, 33 + i * 18, 7));
	    }
	    for(i = 0; i < 2; i++) {
	        this.addSlotToContainer(new Slot(tile, i + 3, 42, 40 + i * 18));
	    }
	    this.addSlotToContainer(new SlotOutput(tile, 5, 116, 17));
		
	}
}
