package fr.mru.OverclockedEngineering.Tiles.ATileManager;

import fr.mru.OverclockedEngineering.Tiles.WitherPlacer.TileWitherPlacer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotWitherSkull extends Slot {

	public SlotWitherSkull(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);

	}
	
	@Override
    public boolean isItemValid(ItemStack stack) {
        return stack.getItem() == TileWitherPlacer.skull.getItem();
    } 

}
