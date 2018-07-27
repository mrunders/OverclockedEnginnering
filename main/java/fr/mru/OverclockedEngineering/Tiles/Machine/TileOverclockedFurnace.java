package fr.mru.OverclockedEngineering.Tiles.Machine;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileManager;
import fr.mru.OverclockedEngineeringItems.EngineManager;
import fr.mru.OverclockedEngineeringItems.Focus.FocusManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;

public class TileOverclockedFurnace extends ATileManager {
	
	public TileOverclockedFurnace() {
		super(6, "tile.overclockedMachine");

	}
	
	private static final int SLOT_FOCUS = 3,
							 SLOT_ENGINE = 4,
							 SLOT_OUTPUT = 5;

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		
		if ( stacks.get(SLOT_ENGINE).isEmpty() || stacks.get(SLOT_FOCUS).isEmpty() )
			return false;

		return index < 3;
	}
	
	public boolean hasFuelEmpty() {
	    return this.getStackInSlot(SLOT_ENGINE).isEmpty();
	}
	
	public RecipeRequest getRecipeResultRequest() {
	    return FocusManager.getRecipeResult(this.stacks.get(SLOT_FOCUS).getItem(), new ItemStack[] { this.getStackInSlot(0), this.getStackInSlot(1), this.getStackInSlot(2) });
	}
	
	public boolean canSmelt() {

	    ItemStack result = this.getRecipeResultRequest().getResult();

	    if (result != null) {

	        ItemStack slot4 = this.getStackInSlot(SLOT_OUTPUT);

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
	    RecipeRequest result = this.getRecipeResultRequest();
	    
	    this.decrStackSize(2, result.getRequiredItemCount(2));
	    this.decrStackSize(1, result.getRequiredItemCount(1));
	    this.decrStackSize(0, result.getRequiredItemCount(0));

	    ItemStack stack4 = this.getStackInSlot(SLOT_OUTPUT);
	   
	    if (stack4.isEmpty()) {
	        this.setInventorySlotContents(SLOT_OUTPUT, result.getResult().copy());
	    } else {
	        stack4.setCount(stack4.getCount() + result.getResult().getCount());
	    }
	}
	
	public int getFullRecipeTime() {
		return EngineManager.getFullTimeRecipe(this.stacks.get(SLOT_ENGINE).getItem());
		
	}

	public boolean isBurning() {
	    return EngineManager.itemIsEngine(this.stacks.get(SLOT_ENGINE).getItem()) && 
	    	   FocusManager.itemIsFocus(this.stacks.get(SLOT_FOCUS).getItem()) && 
	    	   !this.stacks.get(0).isEmpty();
	}
	
	@Override
	public void update() {
	    if (!this.world.isRemote) {
	    	
	    	if ( getStackInSlot(0).isEmpty() ) this.setInventorySlotContents(0, removeStackFromSlot(1));
	    	if ( getStackInSlot(1).isEmpty() ) this.setInventorySlotContents(1, removeStackFromSlot(2));

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
	public ItemStack getRecipeResult() {
		return RecipeRequest.nullStack;
	}

}
