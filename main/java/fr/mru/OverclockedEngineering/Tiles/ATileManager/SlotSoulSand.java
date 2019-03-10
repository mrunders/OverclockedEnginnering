package fr.mru.OverclockedEngineering.Tiles.ATileManager;

import fr.mru.OverclockedEngineering.Tiles.WitherPlacer.TileWitherPlacer;
import fr.mru.OverclockedEngineeringItems.LocationCard;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotSoulSand extends Slot {

	public SlotSoulSand(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);

	}
	
	@Override
    public boolean isItemValid(ItemStack stack) {
        return stack.getItem() == TileWitherPlacer.soulsand.getItem();
    } 

}
