package fr.mru.OverclockedEngineering.Tiles.Cobble_form;

import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileInstantProcessingManager;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileManager;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class TileCobbleForm extends ATileInstantProcessingManager {
	
	public static final int COBBLE_SLOT = 0,
						GRAVEL_SLOT = 1,
						SAND_SLOT   = 2,
						GLASS_SLOT  = 3,
						STONE_SLOT  = 4;

	public TileCobbleForm() {
		super(5, "tile.cobble_form");
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
		
		if ( getStackInSlot(COBBLE_SLOT).getCount() < getInventoryStackLimit() ) {
			if ( getStackInSlot(COBBLE_SLOT).isEmpty() ) 
				setInventorySlotContents(COBBLE_SLOT, new ItemStack(Blocks.COBBLESTONE));
			else
				getStackInSlot(COBBLE_SLOT).setCount(getStackInSlot(COBBLE_SLOT).getCount() + 1);
			
		} else if ( getStackInSlot(GRAVEL_SLOT).getCount() < getInventoryStackLimit() ) {
			decrStackSize(COBBLE_SLOT, 1);
			if ( getStackInSlot(GRAVEL_SLOT).isEmpty() ) 
				setInventorySlotContents(GRAVEL_SLOT, new ItemStack(Blocks.GRAVEL));
			else
				getStackInSlot(GRAVEL_SLOT).setCount(getStackInSlot(GRAVEL_SLOT).getCount() + 1);
			
		} else if ( getStackInSlot(SAND_SLOT).getCount() < getInventoryStackLimit() ) {
			decrStackSize(GRAVEL_SLOT, 1);
			if ( getStackInSlot(SAND_SLOT).isEmpty() ) 
				setInventorySlotContents(SAND_SLOT, new ItemStack(Blocks.SAND));
			else
				getStackInSlot(SAND_SLOT).setCount(getStackInSlot(SAND_SLOT).getCount() + 1);
		
		} else if ( getStackInSlot(STONE_SLOT).getCount() < getInventoryStackLimit() ) {
			decrStackSize(COBBLE_SLOT, 1);
			if ( getStackInSlot(STONE_SLOT).isEmpty() ) 
				setInventorySlotContents(STONE_SLOT, new ItemStack(Blocks.STONE));
			else
				getStackInSlot(STONE_SLOT).setCount(getStackInSlot(STONE_SLOT).getCount() + 1);
		
		} else if ( getStackInSlot(GLASS_SLOT).getCount() < getInventoryStackLimit() ) {
			decrStackSize(SAND_SLOT, 1);
			if ( getStackInSlot(GLASS_SLOT).isEmpty() ) 
				setInventorySlotContents(GLASS_SLOT, new ItemStack(Blocks.GLASS));
			else
				getStackInSlot(GLASS_SLOT).setCount(getStackInSlot(GLASS_SLOT).getCount() + 1);
		} 
		
	}

	@Override
	public void update() {
		
		if ( !this.world.isRemote ) {
			
			smelt();
		}
		
	}

}
