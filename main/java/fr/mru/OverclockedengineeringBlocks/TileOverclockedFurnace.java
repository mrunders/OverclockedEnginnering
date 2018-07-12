package fr.mru.OverclockedengineeringBlocks;

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
	
	private NonNullList <ItemStack>stacks = NonNullList.withSize(5, ItemStack.EMPTY);
	private String customName;
	private int	timePassed = 0;
	private int	burningTimeLeft	= 0;
	
	private static final int SLOT_ENGINE = 3,
							 SLOT_FOCUS = 2,
							 SLOT_OUTPUT = 4;
	
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

		return index < 2;
	}
	
	/** Vérifie la distance entre le joueur et le bloc et que le bloc soit toujours présent */
	public boolean isUsableByPlayer(EntityPlayer player) {
	    return this.world.getTileEntity(this.pos) != this ? false : player
	            .getDistanceSq((double) this.pos.getX() + 0.5D,
	                    (double) this.pos.getY() + 0.5D,
	                    (double) this.pos.getZ() + 0.5D) <= 64.0D;
	}
	
	public boolean hasFuelEmpty() {
	    return this.getStackInSlot(SLOT_ENGINE).isEmpty();
	}
	
	public ItemStack getRecipeResult() {
	    return FocusManager.getRecipeResult(this.stacks.get(SLOT_FOCUS).getItem(), new ItemStack[] { this.getStackInSlot(0), this.getStackInSlot(1) });
	}
	
	public boolean canSmelt() {
	    // On récupère le résultat de la recette
	    ItemStack result = this.getRecipeResult();

	    // Le résultat est null si il n'y a pas de recette associée, donc on retourne faux
	    if (result != null) {

	        // On récupère le contenu du slot de résultat
	        ItemStack slot4 = this.getStackInSlot(SLOT_OUTPUT);

	        // Si il est vide on renvoie vrai
	        if (slot4.isEmpty())
	            return true;

	        // Sinon on vérifie que ce soit le même objet, les même métadata et que la taille finale ne sera pas trop grande
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
	    // Cette fonction n'est appelée que si result != null, c'est pourquoi on ne fait pas de null check
	    ItemStack result = this.getRecipeResult();
	    // On enlève un item de chaque ingrédient
	    this.decrStackSize(0, 1);
	    this.decrStackSize(1, 1);
	    // On récupère le slot de résultat
	    ItemStack stack4 = this.getStackInSlot(SLOT_OUTPUT);
	    // Si il est vide
	    if (stack4.isEmpty()) {
	        // On y insère une copie du résultat
	        this.setInventorySlotContents(SLOT_OUTPUT, result.copy());
	    } else {
	        // Sinon on augmente le nombre d'objets de l'ItemStack
	        stack4.setCount(stack4.getCount() + result.getCount());
	    }
	}
	
	/** Temps de cuisson de la recette */
	public int getFullRecipeTime() {
		return EngineManager.getFullTimeRecipe(this.stacks.get(SLOT_ENGINE).getItem());
		
	}

	/** Temps que dure 1 unité de carburant (ici : 1 planche + 1 blé) */
	public int getFullBurnTime() {
	    
		return 200;
	}

	/** Renvoie vrai si le feu est allumé */
	public boolean isBurning() {
	    return EngineManager.itemIsEngine(this.stacks.get(SLOT_ENGINE).getItem());
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
