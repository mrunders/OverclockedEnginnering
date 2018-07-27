package fr.mru.OverclockedEngineering.Tiles.ATileManager;

import fr.mru.OverclockedEngineeringItems.EngineManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotEngine extends Slot {

	public SlotEngine(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);

	}
	
	@Override
    public boolean isItemValid(ItemStack stack) {
        return EngineManager.itemIsEngine(stack.getItem());
    }

}
