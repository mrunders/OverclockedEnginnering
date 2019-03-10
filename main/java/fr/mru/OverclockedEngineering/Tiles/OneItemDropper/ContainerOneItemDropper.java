package fr.mru.OverclockedEngineering.Tiles.OneItemDropper;

import fr.mru.OverclockedEngineering.Tiles.ATileManager.ContainerManager;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.SlotOutput;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerOneItemDropper extends ContainerManager {

	public ContainerOneItemDropper(ATileManager tile, InventoryPlayer playerInventory) {
		super(tile, playerInventory);
	}

	@Override
	public boolean displaySlots(ATileManager tile, InventoryPlayer playerInventory) {
		
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {

			    this.addSlotToContainer(new Slot(tile, i*3+j, 45+27*i, 6+24*j));
			}
		}

	    return false;
	}



}
