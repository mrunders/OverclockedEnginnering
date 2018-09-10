package fr.mru.OverclockedEngineering.Tiles.FilterChest;

import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileManager;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.ContainerManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerFilterChest extends ContainerManager {

	public ContainerFilterChest(TileFilterChest tile, InventoryPlayer playerInventory) {
		super(tile, playerInventory);
	}

	@Override
	public boolean displaySlots(ATileManager tile, InventoryPlayer playerInventory) {
		
		// chest content
		int i, j;
	    for(i = 0; i < 9; ++i) {
	        for(j = 0; j < 9; ++j) {
	            this.addSlotToContainer(new Slot(tile, j + i * 9, 8 + j * 18, 8 + i * 18));
	        }
	    }
	    
	    // modules (bottom left side)
	    for(i = 0; i < 5; ++i) {
	        this.addSlotToContainer(new Slot(tile, i + 81, 206, i * 18 - 36));
	    }
	    
	    // filter (left side)
	    for(i = 0; i < 3; ++i) {
	        for(j = 0; j < 9; ++j) {
	            this.addSlotToContainer(new Slot(tile, j + i * 3 + 86, 188 + i * 18, j * 18 - 72));
	        }
	    }
	    
	    // inventory player
	    for(i = 0; i < 3; ++i) {
	        for(j = 0; j < 9; ++j) {
	            this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 188 + i * 18));
	        }
	    }
	    
	    // player hotbar
	    for(i = 0; i < 9; ++i) {
	        this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 260));
	    }
	    
	    return true;
		
	}
}
