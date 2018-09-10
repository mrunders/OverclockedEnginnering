package fr.mru.OverclockedEngineering.Tiles.FilterChest;

import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileChestManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileFilterChest extends ATileChestManager {
	
	public TileFilterChest() {
		super(81, 5, 15, "chest_filter");
	
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
		
		return getStackInSlot(index).getItem() == stack.getItem() || !isOnFilter(stack);
	}

	@Override
	public void update() {}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return index < stackLenght;
	}

	@Override
	public int[] getInputSlots() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getOutputSlots() {
		// TODO Auto-generated method stub
		return null;
	}

	
}