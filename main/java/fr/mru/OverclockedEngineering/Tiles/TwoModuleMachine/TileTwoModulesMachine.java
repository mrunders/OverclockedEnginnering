package fr.mru.OverclockedEngineering.Tiles.TwoModuleMachine;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileInstantProcessingManager;
import fr.mru.OverclockedEngineeringItems.Focus.AFocusManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileTwoModulesMachine extends ATileInstantProcessingManager {

	public TileTwoModulesMachine() {
		super(5, "tile.two_modules_machine");
	}
	
	public static final int INPUT_SLOT = 0,
							FIRST_MODULE_SLOT = 1,
							MIDDLE_SLOT = 2,
							SECOND_MODULE_SLOT = 3,
							OUTPUT_SLOT = 4;

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		
		return index == INPUT_SLOT;
	}

	public RecipeRequest getFirstResult() {
		if ( getStackInSlot(FIRST_MODULE_SLOT).isEmpty() ) return RecipeRequest.NULL;
		return AFocusManager.getRecipeResult(getStackInSlot(FIRST_MODULE_SLOT).getItem(), getStackInSlot(INPUT_SLOT));
	}
	
	public RecipeRequest getSecondResult() {
		if ( getStackInSlot(SECOND_MODULE_SLOT).isEmpty() ) return RecipeRequest.NULL;
		return AFocusManager.getRecipeResult(getStackInSlot(SECOND_MODULE_SLOT).getItem(), getStackInSlot(MIDDLE_SLOT));
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
	public ItemStack getRecipeResult() {return null;}

	@Override
	public boolean canSmelt() {return false;}

	@Override
	public void smelt() {}

	@Override
	public Object getServerGuiElement(TileEntity te, InventoryPlayer inventory) {
    	return new ContainerTwoModulesMachine((TileTwoModulesMachine)te, inventory);
	}

	@Override
	public Object getClientGuiElement(TileEntity te, InventoryPlayer inventory) {
		return new GuiTwoModulesMachine((TileTwoModulesMachine)te, inventory);
	}


}
