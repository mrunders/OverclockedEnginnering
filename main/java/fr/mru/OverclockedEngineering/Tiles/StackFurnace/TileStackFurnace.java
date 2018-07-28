package fr.mru.OverclockedEngineering.Tiles.StackFurnace;

import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileInstantProcessingManager;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileManager;
import fr.mru.OverclockedEngineeringItems.EngineManager;
import fr.mru.OverclockedEngineeringItems.Focus.AFocusManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.entity.player.SleepingLocationCheckEvent;

public class TileStackFurnace extends ATileInstantProcessingManager {
	
	public TileStackFurnace() {
		super(2, "tile.stack_furnace");
	}

	private ItemStack currentSlot = null;
	public static final int INPUT_SLOT = 0, OUTPUT_SLOT = 1;


	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		
		return index == INPUT_SLOT;
	}
	
	public ItemStack getRecipeResult() {
	    ItemStack result = FurnaceRecipes.instance().getSmeltingResult(getStackInSlot(INPUT_SLOT));
	    return result.getItem() == Items.AIR ? null : result;
	}
	
	public boolean canSmelt() {
		
	    ItemStack result = this.getRecipeResult();

	    if (result != null) {
	    	return getStackInSlot(OUTPUT_SLOT).isEmpty();
	    }
	    
	    return false;
	}
	
	public void smelt() {
		
		ItemStack result = this.getRecipeResult();
		    
		if (getStackInSlot(OUTPUT_SLOT).isEmpty()) {
		    result = result.copy();
			int count = getStackInSlot(INPUT_SLOT).getCount();
			this.decrStackSize(INPUT_SLOT, count);
			result.setCount(count);
		    this.setInventorySlotContents(OUTPUT_SLOT, result.copy());
		}
	}
	
	@Override
	public void update() {
		
		if ( redstoneControl ) return;
		
	    if (!this.world.isRemote) {
	    	
	    	if ( !getStackInSlot(INPUT_SLOT).isEmpty() && canSmelt() ) smelt();
	    }
	}
}
