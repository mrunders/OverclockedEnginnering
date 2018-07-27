package fr.mru.OverclockedEngineering.Tiles.ATileManager;

import fr.mru.OverclockedEngineeringItems.EngineManager;
import fr.mru.OverclockedEngineeringItems.Focus.FocusManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotFocus extends Slot {

	public SlotFocus(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);

	}
	
	@Override
    public boolean isItemValid(ItemStack stack) {
        return FocusManager.itemIsFocus(stack.getItem());
    }

}