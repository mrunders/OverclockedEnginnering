package fr.mru.OverclockedEngineering.Tiles.StackFurnace;

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

public class TileStackFurnace extends TileEntityLockable implements ITickable {
	
	private NonNullList <ItemStack>stacks = NonNullList.withSize(8, ItemStack.EMPTY);
	private String customName;
	private int currentInputSlot = START_INPUT_SLOT;
	private ItemStack currentSlot = null;
	
	public static final int START_INPUT_SLOT = 0,
							 END_INPUT_SLOT =  3,
							 START_OUTPUT_SLOT = 3,
							 END_OUTPUT_SLOT =  8;
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
	    super.readFromNBT(compound);
	    this.stacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
	    ItemStackHelper.loadAllItems(compound, this.stacks);

	    if (compound.hasKey("CustomName", 8)) {
	        this.customName = compound.getString("CustomName");
	    }
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
	    super.writeToNBT(compound);
	    ItemStackHelper.saveAllItems(compound, this.stacks);

	    if (this.hasCustomName()) {
	        compound.setString("CustomName", this.customName);
	    }

	    return compound;
	}
	
	@Override
	public boolean hasCustomName() {
	    return this.customName != null && !this.customName.isEmpty();
	}

	@Override
	public String getName() {
	    return hasCustomName() ? this.customName : "tile.stackFurnace";
	}

	public void setCustomName(String name) {
	    this.customName = name;
	}
	
	@Override
	public int getField(int id) {
	    return 0;
	}

	@Override
	public void setField(int id, int value) {
	    return;
	}

	@Override
	public int getFieldCount() {
	    return 0;
	}
	
	@Override
	public int getSizeInventory() {
	    return this.stacks.size();
	}

	@Override
	public ItemStack getStackInSlot(int index) {
	    return this.stacks.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
	    return ItemStackHelper.getAndSplit(this.stacks, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
	    return ItemStackHelper.getAndRemove(stacks, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
	    this.stacks.set(index, stack);

	    if (stack.getCount() > this.getInventoryStackLimit()) {
	        stack.setCount(this.getInventoryStackLimit());
	    }
	}

	@Override
	public int getInventoryStackLimit() {
	    return 64;
	}

	@Override
	public boolean isEmpty() {
	    for(ItemStack stack : this.stacks) {
	        if (!stack.isEmpty()) {
	            return false;
	        }
	    }
	    return true;
	}

	@Override
	public void clear() {
	    for(int i = 0; i < this.stacks.size(); i++) {
	        this.stacks.set(i, ItemStack.EMPTY);
	    }
	}
	
	@Override
	public void openInventory(EntityPlayer player) {
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		
	}
	
	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
	    return null;
	}

	@Override
	public String getGuiID() {
	    return null;
	}
	
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		
		return index < END_INPUT_SLOT;
	}
	
	private int getFirstOutputIndex() {
		
		int i;
		for ( i = START_OUTPUT_SLOT; i < END_OUTPUT_SLOT; ++i)
			if ( this.stacks.get(i).isEmpty()) return i;
		
		return i;
	}
	
	/** Vérifie la distance entre le joueur et le bloc et que le bloc soit toujours présent */
	public boolean isUsableByPlayer(EntityPlayer player) {
	    return this.world.getTileEntity(this.pos) != this ? false : player
	            .getDistanceSq((double) this.pos.getX() + 0.5D,
	                    (double) this.pos.getY() + 0.5D,
	                    (double) this.pos.getZ() + 0.5D) <= 64.0D;
	}
	
	
	public ItemStack getRecipeResult( ItemStack currentItemStackInput ) {
	    ItemStack result = FurnaceRecipes.instance().getSmeltingResult(currentItemStackInput);
	    return result.getItem().equals(Items.AIR) ? null : result;
	}
	
	public boolean canSmelt(ItemStack currentItemStackInput) {
		
	    ItemStack result = this.getRecipeResult( currentItemStackInput );

	    if (result != null) {

	    	int outputSlot = getFirstOutputIndex();
	    	return outputSlot < END_OUTPUT_SLOT && this.getStackInSlot(getFirstOutputIndex()).isEmpty();
	    	
	    }
	    
	    return false;
	}
	
	public void smelt(ItemStack currentItemStackInput) {
		
		ItemStack result, output;
		int outputSlotIndex = getFirstOutputIndex();
		
		if ( outputSlotIndex < END_OUTPUT_SLOT) {
		    result = this.getRecipeResult( currentItemStackInput );
		    output = getStackInSlot(outputSlotIndex);
		    
		    if (output.isEmpty()) {
		    	result = result.copy();
			    int count = currentItemStackInput.getCount();
			    this.decrStackSize(currentInputSlot, count);
			    result.setCount(count);
		        this.setInventorySlotContents(outputSlotIndex, result.copy());
		    }
		}
	}
	
	@Override
	public void update() {
	    if (!this.world.isRemote) {
	    	
	    	if ( currentInputSlot == END_INPUT_SLOT) currentInputSlot = START_INPUT_SLOT;
	    	ItemStack currentItemStackInput = getStackInSlot(currentInputSlot);

	    	if ( !currentItemStackInput.isEmpty() && canSmelt(currentItemStackInput) ) smelt(currentItemStackInput);

	        this.markDirty();
	        ++currentInputSlot;
	    }
	}
}
