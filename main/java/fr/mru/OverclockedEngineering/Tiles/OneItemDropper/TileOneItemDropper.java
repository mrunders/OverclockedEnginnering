package fr.mru.OverclockedEngineering.Tiles.OneItemDropper;

import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileInstantProcessingManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileOneItemDropper extends ATileInstantProcessingManager {
	
	private static final int[] INPUT_SLOTS = {0,1,2,3,4,5,6,7,8};
	private static final int MAX_WAIT = 50;
	private int wait = 0;
	
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
		
		for (int i = 0; i < stacks.size(); ++i) {
			if ( !stacks.get(i).isEmpty() ) {
				Blocks.DROPPER.spawnAsEntity(getWorld(), getPos().down(), decrStackSize(i, 1));
			}
		}
		
	}

	@Override
	public void update() {
		
		if ( !this.world.isRemote && redstoneControl) {
			
			if ( wait == MAX_WAIT) {
				smelt();
				wait = 0;
			} else ++wait;
			
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
