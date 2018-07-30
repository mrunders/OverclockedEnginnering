package fr.mru.OverclockedEngineering.Tiles.ATileManager;

import java.util.stream.IntStream;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;

public abstract class ATileManager extends TileEntityLockable implements ITickable,  ISidedInventory {
	
	protected final int[] NONE = new int[] {};
	
	protected boolean redstoneControl = false;
	protected NonNullList <ItemStack>stacks;
	protected String customName, name;
	protected int	timePassed = 0;
	protected int	burningTimeLeft	= 0;

	public abstract Object getServerGuiElement(TileEntity te, InventoryPlayer inventory);
	public abstract Object getClientGuiElement(TileEntity te, InventoryPlayer inventory);
	
	public ATileManager(int stacksLenght, String name) {
		this.name = name;
		stacks = NonNullList.withSize(stacksLenght, ItemStack.EMPTY);
	}
	
	public boolean moveOnSlot(int from, int to) {
		
        ItemStack froms = getStackInSlot(from);
        ItemStack tos = getStackInSlot(to);
        int maxdpl = froms.getCount() + tos.getCount();
        
        if ( tos.isEmpty() ) {
        	setInventorySlotContents(to, removeStackFromSlot(from));
        	return true;
        }
        
        if ( froms.getItem() == tos.getItem() && froms.getItemDamage() == tos.getItemDamage()) {
        
	        if ( maxdpl <= tos.getMaxStackSize() ) {
	        	removeStackFromSlot(from);
	        	tos.setCount(maxdpl);
	        	return true;
	        	
	        } else {
	        	maxdpl = maxdpl % tos.getMaxStackSize();
	        	froms.setCount(maxdpl);
	        	tos.setCount(tos.getMaxStackSize());
	        	return true;
	        }
        }
		return false;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
	    super.readFromNBT(compound);
	    this.stacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
	    ItemStackHelper.loadAllItems(compound, this.stacks);

	    if (compound.hasKey("CustomName", 8)) {
	        this.customName = compound.getString("CustomName");
	    }
	    
	    this.burningTimeLeft = compound.getInteger("burningTimeLeft");
	    this.timePassed = compound.getInteger("timePassed");
	    this.redstoneControl = compound.getBoolean("redstoneControl");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
	    super.writeToNBT(compound);
	    ItemStackHelper.saveAllItems(compound, this.stacks);

	    if (this.hasCustomName()) {
	        compound.setString("CustomName", this.customName);
	    }
	    
	    compound.setInteger("burningTimeLeft", this.burningTimeLeft);
	    compound.setInteger("timePassed", this.timePassed);
	    compound.setBoolean("redstoneControl", this.redstoneControl);

	    return compound;
	}
	
	@Override
	public boolean hasCustomName() {
	    return this.customName != null && !this.customName.isEmpty();
	}
	
	@Override
	public String getName() {
	    return hasCustomName() ? this.customName : name;
	}

	public void setCustomName(String name) {
	    this.customName = name;
	}
	
	@Override
	public int getField(int id) {
	    switch (id) {
	        case 0:
	            return this.burningTimeLeft;
	        case 1:
	            return this.timePassed;
	    }
	    return 0;
	}

	@Override
	public void setField(int id, int value) {
	    switch (id) {
	        case 0:
	            this.burningTimeLeft = value;
	            break;
	        case 1:
	            this.timePassed = value;
	    }
	}

	@Override
	public int getFieldCount() {
	    return 2;
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
	public abstract boolean isItemValidForSlot(int index, ItemStack stack);
	

	public boolean isUsableByPlayer(EntityPlayer player) {
	    return this.world.getTileEntity(this.pos) != this ? false : player
	            .getDistanceSq((double) this.pos.getX() + 0.5D,
	                    (double) this.pos.getY() + 0.5D,
	                    (double) this.pos.getZ() + 0.5D) <= 64.0D;
	}
	
	public boolean hasFuelEmpty() {
	    return false;
	}
	
	public int getFullBurnTime() {
		return 200;
	}
	

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return direction.equals(EnumFacing.UP) && IntStream.of(getInputSlots()).anyMatch(x -> x == index);
	}
	
	public void setRedstoneControl(boolean blockPowered) {
		redstoneControl = blockPowered;
	}
	
    public int[] getSlotsForFace(EnumFacing side) {
    	
        return (side == EnumFacing.UP)? getInputSlots() : getOutputSlots();
    }
    
    
    net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.UP);
    net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.DOWN);

    @SuppressWarnings("unchecked")
    @Override
    @javax.annotation.Nullable
    public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @javax.annotation.Nullable net.minecraft.util.EnumFacing facing)
    {
        if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return (facing == EnumFacing.UP)? (T) handlerTop : (T) handlerBottom;

        return super.getCapability(capability, facing);
    }
	
	public abstract int getFullRecipeTime();
	public abstract ItemStack getRecipeResult();
	public abstract boolean canSmelt();
	public abstract void smelt();
	public abstract boolean isBurning();
	public abstract void update();
    public abstract boolean canExtractItem(int index, ItemStack stack, EnumFacing direction);
    public abstract int[] getInputSlots();
    public abstract int[] getOutputSlots();
	
}
