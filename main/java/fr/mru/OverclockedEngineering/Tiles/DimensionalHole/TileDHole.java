package fr.mru.OverclockedEngineering.Tiles.DimensionalHole;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileManager;
import fr.mru.OverclockedEngineeringItems.DHoleItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class TileDHole extends ATileManager {

	public TileDHole() {
		super(1, "tile.dimensional_hole");
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		
		return getStackInSlot(0).isEmpty() && stack.getItem() instanceof DHoleItem;
	}

	@Override
	public ItemStack getRecipeResult() {
		
		return RecipeRequest.nullStack;
	}

	@Override
	public boolean canSmelt() {
		
		return !getStackInSlot(0).isEmpty() && getStackInSlot(0).getItem() instanceof DHoleItem && ((DHoleItem) getStackInSlot(0).getItem()).hasTarget();
	}

	@Override
	public void smelt() {
		
		Entity entity = DHoleItem.getMobResult((DHoleItem) getStackInSlot(0).getItem());
		
		if (entity == null ) return;
		
        EntityLiving entityliving = (EntityLiving)entity;
        entity.setLocationAndAngles(this.getPos().getX(), this.getPos().getY()+1, this.getPos().getZ(), 0, 0.0F);
        entityliving.rotationYawHead = entityliving.rotationYaw;
        entityliving.renderYawOffset = entityliving.rotationYaw;
        entityliving.onInitialSpawn(this.getWorld().getDifficultyForLocation(new BlockPos(entityliving)), (IEntityLivingData)null);
        this.getWorld().spawnEntity(entity);
        entityliving.playLivingSound();
	
	}

	@Override
	public boolean isBurning() {
		
		return true;
	}

	@Override
	public void update() {
		
	    /*if (!this.world.isRemote) {
	      
	       if ( redstoneControl ) return;

	        if (this.canSmelt()) {
	            this.timePassed++;
	            if (timePassed >= this.getFullRecipeTime()) {
	                timePassed = 0;
	                this.smelt();
	            }
	        } else {
	            timePassed = 0;
	        }
	        
	        this.markDirty();
	    }*/
	}

	@Override
	public int getFullRecipeTime() {
		return 500;
	}

	@Override
	public Object getServerGuiElement(TileEntity te, InventoryPlayer inventory) {
		return new ContainerDHole((TileDHole)te, inventory);
	}

	@Override
	public Object getClientGuiElement(TileEntity te, InventoryPlayer inventory) {
		return new GuiDHole((TileDHole)te, inventory);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return false;
	}

	@Override
	public int[] getInputSlots() {
		return NONE;
	}

	@Override
	public int[] getOutputSlots() {
		return NONE;
	}
	
	
}
