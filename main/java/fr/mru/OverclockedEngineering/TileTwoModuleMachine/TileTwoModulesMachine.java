package fr.mru.OverclockedEngineering.TileTwoModuleMachine;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.TileManager;
import fr.mru.OverclockedEngineeringItems.Focus.FocusManager;
import net.minecraft.item.ItemStack;

public class TileTwoModulesMachine extends TileManager {

	public TileTwoModulesMachine() {
		super(5);
	}
	
	public static final int INPUT_SLOT = 0,
							FIRST_MODULE_SLOT = 1,
							MIDDLE_SLOT = 2,
							SECOND_MODULE_SLOT = 3,
							OUTPUT_SLOT = 4;

	@Override
	public String getName() {
		return "tile.two_modules_machine";
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		
		return index == INPUT_SLOT;
	}

	public RecipeRequest getFirstResult() {
		return FocusManager.getRecipeResult2(getStackInSlot(FIRST_MODULE_SLOT).getItem(), getStackInSlot(INPUT_SLOT));
	}
	
	public RecipeRequest getSecondResult() {
		return FocusManager.getRecipeResult2(getStackInSlot(SECOND_MODULE_SLOT).getItem(), getStackInSlot(MIDDLE_SLOT));
	}
	
	public boolean canSmeltInSlot(ItemStack result, int slot) {

	    if (result != null) {

	        ItemStack slot4 = this.getStackInSlot(slot);

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
	
	public void smeltInSlot(RecipeRequest result, int input_slot, int output_slot) {
	    
	    this.decrStackSize(input_slot, result.getRequiredItemCount(0));

	    ItemStack stack4 = this.getStackInSlot(output_slot);
	   
	    if (stack4.isEmpty()) {
	        this.setInventorySlotContents(output_slot, result.getResult().copy());
	    } else {
	        stack4.setCount(stack4.getCount() + result.getResult().getCount());
	    }
	}

	@Override
	public void update() {
		
	    if (!this.world.isRemote) {
	    	
	    	if ( this.canSmeltInSlot(this.getSecondResult().getResult(), OUTPUT_SLOT)) {
	    		this.smeltInSlot(this.getSecondResult(), MIDDLE_SLOT, OUTPUT_SLOT);
	    	}
	    	
	    	if ( this.canSmeltInSlot(this.getFirstResult().getResult(), MIDDLE_SLOT)) {
	    		this.smeltInSlot(this.getFirstResult(), INPUT_SLOT, MIDDLE_SLOT);
	    	}
	    	
	    }
	}
	
	@Override
	public int getFullRecipeTime() {return 0;}

	@Override
	public ItemStack getRecipeResult() {return null;}

	@Override
	public boolean canSmelt() {return false;}

	@Override
	public void smelt() {}

	@Override
	public boolean isBurning() {return true;}

}
