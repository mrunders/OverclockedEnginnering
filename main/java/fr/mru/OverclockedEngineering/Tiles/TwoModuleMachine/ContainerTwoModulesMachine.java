package fr.mru.OverclockedEngineering.Tiles.TwoModuleMachine;

import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileManager;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.ContainerManager;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.SlotFocus;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.SlotOutput;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerTwoModulesMachine extends ContainerManager {

	public ContainerTwoModulesMachine(ATileManager tile, InventoryPlayer playerInventory) {
		super(tile, playerInventory);
	}

	@Override
	public boolean displaySlots(ATileManager tile, InventoryPlayer playerInventory) {

	    this.addSlotToContainer(new Slot(tile, 0, 16, 30));
	    this.addSlotToContainer(new SlotFocus(tile, 1, 44, 30));
	    this.addSlotToContainer(new Slot(tile, 2, 72, 30));
	    this.addSlotToContainer(new SlotFocus(tile, 3, 100, 30));
	    this.addSlotToContainer(new SlotOutput(tile, 4, 128, 30));
	    
	    return false;
	}


}
