package fr.mru.OverclockedEngineering.Tiles.DimensionalHole;

import java.util.HashMap;

import com.brandon3055.brandonscore.handlers.HandHelper;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineering.Recipes.RecipesTreeFarm;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.TileManager;
import fr.mru.OverclockedEngineeringItems.DHoleItem;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.entity.Entity;
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
import net.minecraft.world.World;

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
	
	public Entity getMobResult() {
		
		return null;
	}

	@Override
	public boolean canSmelt() {
		
		return true;
	}

	@Override
	public void smelt() {
		
		Entity result = getMobResult();
	
	}

	@Override
	public boolean isBurning() {
		
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
}
