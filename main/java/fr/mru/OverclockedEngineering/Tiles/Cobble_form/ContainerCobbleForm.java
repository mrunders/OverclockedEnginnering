package fr.mru.OverclockedEngineering.Tiles.Cobble_form;

import fr.mru.OverclockedEngineering.Tiles.ATileManager.ContainerManager;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.SlotOutput;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerCobbleForm extends ContainerManager {

	public ContainerCobbleForm(ATileManager tile, InventoryPlayer playerInventory) {
		super(tile, playerInventory);
	}

	@Override
	public boolean displaySlots(ATileManager tile, InventoryPlayer playerInventory) {
		
	    this.addSlotToContainer(new SlotOutput(tile, 0, 16, 30));
	    this.addSlotToContainer(new SlotOutput(tile, 1, 44, 30));
	    this.addSlotToContainer(new SlotOutput(tile, 2, 72, 30));
	    this.addSlotToContainer(new SlotOutput(tile, 3, 100, 30));
	    this.addSlotToContainer(new SlotOutput(tile, 4, 128, 30));

	    return false;
	}



}
