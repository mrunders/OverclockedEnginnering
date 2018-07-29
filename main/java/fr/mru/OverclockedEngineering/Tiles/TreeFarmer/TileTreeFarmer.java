package fr.mru.OverclockedEngineering.Tiles.TreeFarmer;

import fr.mru.OverclockedEngineering.Recipes.RecipesTreeFarm;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;

public class TileTreeFarmer extends ATileManager {
	
	public TileTreeFarmer() {
		super(4, "tile.treeFarmer");

	}
	
	public static final int SAPLING_SLOT = 0,
							 FERTILIZER_SLOT = 1,
							 WOOD_SLOT = 2,
							 LEAVES_SLOT = 3;

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		
		return index == FERTILIZER_SLOT && stack.getItem().equals(Items.BONE);
	}
	
	public ItemStack getRecipeResult() {
	    return RecipesTreeFarm.getRecipeResult(getStackInSlot(SAPLING_SLOT)).getResult();
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


	public boolean isBurning() {
		ItemStack fertiliserSlot = getStackInSlot(FERTILIZER_SLOT);
	    return !getStackInSlot(SAPLING_SLOT).isEmpty() && !fertiliserSlot.isEmpty() && 
	    		fertiliserSlot.getItem() == Items.BONE && 2 <= fertiliserSlot.getCount();
	}
	
	@Override
	public void update() {
	    if (!this.world.isRemote) {

	    	if ( redstoneControl ) return;
	    	
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

	@Override
	public int getFullRecipeTime() {
		return 200;
	}

	@Override
	public Object getServerGuiElement(TileEntity te, InventoryPlayer inventory) {
		return new ContainerTreeFarmer((TileTreeFarmer)te, inventory);
	}

	@Override
	public Object getClientGuiElement(TileEntity te, InventoryPlayer inventory) {
    	return new GuiTreeFarmer((TileTreeFarmer)te, inventory);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return WOOD_SLOT <= index;
	}

	@Override
	public int[] getInputSlots() {
		return new int[] {1};
	}

	@Override
	public int[] getOutputSlots() {
		return new int[] {2,3};
	}
}
