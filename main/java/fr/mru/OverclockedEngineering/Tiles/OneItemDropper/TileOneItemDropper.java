package fr.mru.OverclockedEngineering.Tiles.OneItemDropper;

import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileInstantProcessingManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileOneItemDropper extends ATileInstantProcessingManager {
	
	private static final int[] INPUT_SLOTS = {0,1,2,3,4,5,6,7,8};
	
	public TileOneItemDropper() {
		super(9, "tile.one_item_dropper");
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return false;
	}
	
	@Override
	public ItemStack getRecipeResult() {
		return null;
	}

	@Override
	public boolean canSmelt() {
		return true;
	}

	@Override
	public void smelt() {
		
	}

	@Override
	public void update() {
		
		if ( !this.world.isRemote ) {
			
	    	if ( redstoneControl ) smelt();
			
		}
		
	}

	@Override
	public Object getServerGuiElement(TileEntity te, InventoryPlayer inventory) {
		return new ContainerOneItemDropper((TileOneItemDropper)te, inventory);
	}

	@Override
	public Object getClientGuiElement(TileEntity te, InventoryPlayer inventory) {
		return new GuiOneItemDropper((TileOneItemDropper)te, inventory);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return true;
	}

	@Override
	public int[] getInputSlots() {
		return INPUT_SLOTS;
	}

	@Override
	public int[] getOutputSlots() {
		return NONE;
	}

}
