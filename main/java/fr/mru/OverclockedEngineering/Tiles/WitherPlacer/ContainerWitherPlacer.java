package fr.mru.OverclockedEngineering.Tiles.WitherPlacer;

import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileManager;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.ContainerManager;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.SlotOutput;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.SlotSoulSand;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.SlotWitherSkull;
import fr.mru.OverclockedEngineering.Tiles.StackFurnace.TileStackFurnace;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerWitherPlacer extends ContainerManager {

	public ContainerWitherPlacer(TileWitherPlacer te, InventoryPlayer playerInventory) {
		super(te, playerInventory);
	}

	@Override
	public boolean displaySlots(ATileManager tile, InventoryPlayer playerInventory) {
	    this.addSlotToContainer(new SlotSoulSand(tile, 0, 44, 30));
	    this.addSlotToContainer(new SlotWitherSkull(tile, 1, 116, 30));
	    
	    return false;
	}
}
