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

public abstract class ATileManager extends TileEntityLockable implements ITickable,  ISidedInventory, IGuiElement {
	
	protected final int[] NONE = new int[] {};
	
	protected NonNullList <ItemStack>stacks;
	protected boolean redstoneControl = false;
	protected String customName, name;

	public ATileManager(int stacksLenght, String name) {
		this.name = name;
		stacks = NonNullList.withSize(stacksLenght, ItemStack.EMPTY);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		
	    super.readFromNBT(compound);
		
	    this.stacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
	    ItemStackHelper.loadAllItems(compound, this.stacks);

	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
	    super.writeToNBT(compound);

	    ItemStackHelper.saveAllItems(compound, this.stacks);
	    
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
	
	public void setRedstoneControl(boolean blockPowered) {
		redstoneControl = blockPowered;
	}
	
	public abstract void update();
	
	
}
