package fr.mru.OverclockedEngineering.Tiles.FilterChest;

import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileChestManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileFilterChest extends ATileChestManager {
	
	private int[] INOUT_INDEX = null;
	
	public TileFilterChest() {
		super(81, 5, 18, "chest_filter");
		INOUT_INDEX = new int[81];
		for (int i = 0; i < 81; ++i) 
			INOUT_INDEX[i] = i;
	}

	@Override
	public Object getServerGuiElement(TileEntity te, InventoryPlayer inventory) {
		return new ContainerFilterChest((TileFilterChest)te, inventory);
	}

	@Override
	public Object getClientGuiElement(TileEntity te, InventoryPlayer inventory) {
		return new GuiFilterChest((TileFilterChest)te, inventory);
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		
		ItemStack targeted = getStackInSlot(index);
		return index < this.stackLenght && isOnFilter(stack) && targeted.getCount() < targeted.getMaxStackSize();
	}

	@Override
	public void update() {}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return index < stackLenght;
	}

	@Override
	public int[] getInputSlots() {
		return INOUT_INDEX;
	}

	@Override
	public int[] getOutputSlots() {
		return INOUT_INDEX;
	}

	
}