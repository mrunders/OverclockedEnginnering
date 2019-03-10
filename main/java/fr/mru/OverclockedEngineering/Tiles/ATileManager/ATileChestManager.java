package fr.mru.OverclockedEngineering.Tiles.ATileManager;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequestMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

public abstract class ATileChestManager extends ATileManagerMachines {
	
	protected int stackLenght, updateSlots, filterSlots;

    public ATileChestManager(int stacksLenght, int upgradeSlots, int filterSlots, String name) {
		super(stacksLenght+upgradeSlots+filterSlots, name);
		
		this.stackLenght = stacksLenght;
		this.updateSlots = upgradeSlots;
		this.filterSlots = filterSlots;
	}
    
    protected boolean isOnFilter(ItemStack i) {
    	
    	ItemStack k = null;
    	for ( int j = stackLenght + updateSlots; j < getSizeInventory(); ++j ) {
    		
    		if ( OreDictionary.itemMatches(getStackInSlot(j), i, true)) return true;
    	}
    	
    	return false;
    }

    public int getStacksLenght() { return stackLenght; }
    public int getUpgradesSlotsLenght() { return updateSlots; }
    public int getFilterSlotsLenght() { return filterSlots; }


	@Override
	public int getFullRecipeTime() {
		return 0;
	}

	@Override
	public ItemStack getRecipeResult() {
		return null;
	}

	@Override
	public boolean canSmelt() {
		return false;
	}

	@Override
	public void smelt() {
		
	}

	@Override
	public boolean isBurning() {
		return false;
	}

    
}
