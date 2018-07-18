package fr.mru.OverclockedEngineering.TreeFarmer;

import java.util.HashMap;

import com.brandon3055.brandonscore.handlers.HandHelper;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineering.Recipes.RecipesTreeFarm;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;

public class TileTreeFarmer extends TileEntityLockable implements ITickable {
	
	private NonNullList <ItemStack>stacks = NonNullList.withSize(4, ItemStack.EMPTY);
	private String customName;
	private int	timePassed = 0;
	private int	burningTimeLeft	= 0;
	
	public static final int SAPLING_SLOT = 0,
							 FERTILIZER_SLOT = 1,
							 WOOD_SLOT = 2,
							 LEAVES_SLOT = 3;
	
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

	    return compound;
	}
	
	@Override
	public boolean hasCustomName() {
	    return this.customName != null && !this.customName.isEmpty();
	}

	@Override
	public String getName() {
	    return hasCustomName() ? this.customName : "tile.treeFarmer";
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
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		
		return index == FERTILIZER_SLOT && stack.getItem().equals(Items.BONE);
	}
	

	public boolean isUsableByPlayer(EntityPlayer player) {
	    return this.world.getTileEntity(this.pos) != this ? false : player
	            .getDistanceSq((double) this.pos.getX() + 0.5D,
	                    (double) this.pos.getY() + 0.5D,
	                    (double) this.pos.getZ() + 0.5D) <= 64.0D;
	}
	
	public boolean hasFuelEmpty() {
	    return false;
	}
	
	public ItemStack getRecipeResult() {
	    return RecipesTreeFarm.getRecipeResult(getStackInSlot(SAPLING_SLOT));
	}
	
	public boolean canSmelt() {

	    ItemStack result = getRecipeResult();

	    if ( !result.isEmpty() ) {

	        ItemStack slot4 = this.getStackInSlot(WOOD_SLOT);

	        if (slot4.isEmpty())
	            return true;

	        if (slot4.getItem() == result.getItem() && slot4.getItemDamage() == result.getItemDamage()) {
	            int newStackSize = slot4.getCount() + result.getCount();
	            if (newStackSize <= this.getInventoryStackLimit() && newStackSize <= slot4.getMaxStackSize()) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
	
	public void smelt() {
	    ItemStack result = this.getRecipeResult();
	    
	    this.decrStackSize(FERTILIZER_SLOT, 2);
	    
	    ItemStack stack4 = this.getStackInSlot(WOOD_SLOT);

	    if (stack4.isEmpty()) {
	        this.setInventorySlotContents(WOOD_SLOT, result.copy());
	    } else {
	        stack4.setCount(stack4.getCount() + result.getCount());
	    }
	}
	
	public int getFullRecipeTime() {
		return 200;
		
	}

	public int getFullBurnTime() {
		return 200;
	}

	public boolean isBurning() {
		ItemStack fertiliserSlot = getStackInSlot(FERTILIZER_SLOT);
	    return !getStackInSlot(SAPLING_SLOT).isEmpty() && !fertiliserSlot.isEmpty() && 
	    		fertiliserSlot.getItem() == Items.BONE && 2 <= fertiliserSlot.getCount();
	}
	
	@Override
	public void update() {
	    if (!this.world.isRemote) {
	    	
	        if (!this.isBurning() && this.canSmelt() && !this.hasFuelEmpty()) {
	            this.burningTimeLeft = this.getFullBurnTime();
	        }

	        if (this.isBurning() && this.canSmelt()) {
	            this.timePassed++;
	            if (timePassed >= this.getFullRecipeTime()) {
	                timePassed = 0;
	                this.smelt();
	            }
	        } else {
	            timePassed = 0;
	        }
	        
	        this.markDirty();
	    }
	}
}
