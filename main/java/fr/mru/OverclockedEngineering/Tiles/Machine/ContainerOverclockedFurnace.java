package fr.mru.OverclockedEngineering.Tiles.Machine;

import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileManager;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.ContainerManager;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.SlotEngine;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.SlotFocus;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.SlotOutput;
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
	public boolean displaySlots(ATileManager tile, InventoryPlayer playerInventory) {
		
	    int i;
	    for(i = 0; i < 3; i++) {
	        this.addSlotToContainer(new Slot(tile, i, 33 + i * 18, 7));
	    }
	    
	    this.addSlotToContainer(new SlotFocus(tile, 3, 42, 40));
	    this.addSlotToContainer(new SlotEngine(tile, 4, 42, 58));

	    this.addSlotToContainer(new SlotOutput(tile, 5, 116, 17));
	    
	    return false;
		
	}
}
