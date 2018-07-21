package fr.mru.OverclockedEngineering.Tiles.Machine;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineeringItems.EngineManager;
import fr.mru.OverclockedEngineeringItems.Focus.FocusManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.entity.player.SleepingLocationCheckEvent;

public class TileOverclockedFurnace extends TileEntityLockable implements ITickable {
	
	private NonNullList <ItemStack>stacks = NonNullList.withSize(6, ItemStack.EMPTY);
	private String customName;
	private int	timePassed = 0;
	private int	burningTimeLeft	= 0;
	
	private static final int SLOT_FOCUS = 3,
							 SLOT_ENGINE = 4,
							 SLOT_OUTPUT = 5;
	
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
	    return hasCustomName() ? this.customName : "tile.overclockedMachine";
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
		
		if ( stacks.get(SLOT_ENGINE).isEmpty() || stacks.get(SLOT_FOCUS).isEmpty() )
			return false;

		return index < 3;
	}
	
	/** V�rifie la distance entre le joueur et le bloc et que le bloc soit toujours pr�sent */
	public boolean isUsableByPlayer(EntityPlayer player) {
	    return this.world.getTileEntity(this.pos) != this ? false : player
	            .getDistanceSq((double) this.pos.getX() + 0.5D,
	                    (double) this.pos.getY() + 0.5D,
	                    (double) this.pos.getZ() + 0.5D) <= 64.0D;
	}
	
	public boolean hasFuelEmpty() {
	    return this.getStackInSlot(SLOT_ENGINE).isEmpty();
	}
	
	public RecipeRequest getRecipeResult() {
	    return FocusManager.getRecipeResult(this.stacks.get(SLOT_FOCUS).getItem(), new ItemStack[] { this.getStackInSlot(0), this.getStackInSlot(1), this.getStackInSlot(2) });
	}
	
	public boolean canSmelt() {

	    ItemStack result = this.getRecipeResult().getResult();

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
	    RecipeRequest result = this.getRecipeResult();
	    
	    this.decrStackSize(0, result.getRequiredItemCount(0));
	    this.decrStackSize(1, result.getRequiredItemCount(1));
	    this.decrStackSize(2, result.getRequiredItemCount(2));
	    
	    ItemStack stack4 = this.getStackInSlot(SLOT_OUTPUT);
	   
	    if (stack4.isEmpty()) {
	        this.setInventorySlotContents(SLOT_OUTPUT, result.getResult().copy());
	    } else {
	        stack4.setCount(stack4.getCount() + result.getResult().getCount());
	    }
	}
	
	/** Temps de cuisson de la recette */
	public int getFullRecipeTime() {
		return EngineManager.getFullTimeRecipe(this.stacks.get(SLOT_ENGINE).getItem());
		
	}

	/** Temps que dure 1 unit� de carburant (ici : 1 planche + 1 bl�) */
	public int getFullBurnTime() {
	    
		return 200;
	}

	/** Renvoie vrai si le feu est allum� */
	public boolean isBurning() {
	    return EngineManager.itemIsEngine(this.stacks.get(SLOT_ENGINE).getItem()) && 
	    	   FocusManager.itemIsFocus(this.stacks.get(SLOT_FOCUS).getItem()) && 
	    	   !this.stacks.get(0).isEmpty();
	}
	
	@Override
	public void update() {
	    if (!this.world.isRemote) {

	        /*
	            * Si la on peut faire cuire la recette et que le four ne cuit pas
	            * alors qu'il peut, alors on le met en route
	            */
	        if (!this.isBurning() && this.canSmelt() && !this.hasFuelEmpty()) {
	            this.burningTimeLeft = this.getFullBurnTime();
	        }

	        /* Si on peut faire cuire la recette et que le feu cuit */
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
