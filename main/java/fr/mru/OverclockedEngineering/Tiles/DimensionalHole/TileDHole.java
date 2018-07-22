package fr.mru.OverclockedEngineering.Tiles.DimensionalHole;

import java.util.List;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.TileManager;
import fr.mru.OverclockedEngineeringItems.DHoleItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome.SpawnListEntry;

public class TileDHole extends TileManager {

	public TileDHole() {
		super(1);
	}

	@Override
	public String getName() {
		 return "tile.dimensional_hole";
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
	
	
}
