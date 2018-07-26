package fr.mru.OverclockedEngineering.Tiles.StackFurnace;

import fr.mru.OverclockedEngineering.Tiles.ATileManager.TileManager;
import fr.mru.OverclockedEngineeringItems.EngineManager;
import fr.mru.OverclockedEngineeringItems.Focus.FocusManager;
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

public class TileStackFurnace extends TileManager {
	
	public TileStackFurnace() {
		super(2);
	}

	private ItemStack currentSlot = null;
	public static final int INPUT_SLOT = 0, OUTPUT_SLOT = 1;
	
	@Override
	public String getName() {
	    return hasCustomName() ? this.customName : "tile.stackFurnace";
	}

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
	    if (!this.world.isRemote) {
	    	
	    	if ( !getStackInSlot(INPUT_SLOT).isEmpty() && canSmelt() ) smelt();
	    }
	}


	@Override
	public int getFullRecipeTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isBurning() {
		// TODO Auto-generated method stub
		return false;
	}
}
