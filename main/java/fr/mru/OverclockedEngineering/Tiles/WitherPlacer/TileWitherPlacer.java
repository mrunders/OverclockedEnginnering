package fr.mru.OverclockedEngineering.Tiles.WitherPlacer;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequestMap;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileInstantProcessingManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class TileWitherPlacer extends ATileInstantProcessingManager {
	
	private int[] inputs_slots = {0,1};
	public static final ItemStack soulsand = new ItemStack(Blocks.SOUL_SAND, 4),
					  				skull    = new ItemStack(Blocks.SKULL, 3, 1);
	
	
	private BlockPos[] soulsandpos = {},
			           skullpos = {};

	public TileWitherPlacer() {
		super(2, "tile.wither_placer");
		
		BlockPos pos = getPos();
		
		/*soulsandpos[0] = pos.up();
		soulsandpos[1] = pos.up(2);
		soulsandpos[2] = pos.up().west();
		soulsandpos[3] = pos.up().east();
		
		skullpos[0] = pos.up(3);
		skullpos[1] = pos.up(3).west();
		skullpos[2] = pos.up(3).east();*/
	}

	@Override
	public Object getServerGuiElement(TileEntity te, InventoryPlayer inventory) {
		return new ContainerWitherPlacer((TileWitherPlacer)te, inventory);
	}

	@Override
	public Object getClientGuiElement(TileEntity te, InventoryPlayer inventory) {
		return new GuiWitherPlacer((TileWitherPlacer)te, inventory);
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if (index == 0)
			return this.soulsand.getItem() == stack.getItem();
		
		else if (index == 1)
			return this.skull.getItem() == stack.getItem();
		
		return false;
	}

	@Override
	public ItemStack getRecipeResult() {
		return ItemStack.EMPTY;
	}

	@Override
	public boolean canSmelt() {
		return RecipeRequestMap.itemStackEqual(this.soulsand, getStackInSlot(0)) &&
			   RecipeRequestMap.itemStackEqual(this.skull, getStackInSlot(1));
	}

	@Override
	public void smelt() {
		
		decrStackSize(0, 4);
		decrStackSize(1, 3);

		Entity entity = new EntityWither(world);
		EntityLiving entityliving = (EntityLiving)entity;
		entity.setLocationAndAngles(this.getPos().getX(), this.getPos().getY()+1, this.getPos().getZ(), 0, 0.0F);
		entityliving.rotationYawHead = entityliving.rotationYaw;
		entityliving.renderYawOffset = entityliving.rotationYaw;
		entityliving.onInitialSpawn(this.getWorld().getDifficultyForLocation(new BlockPos(entityliving)), (IEntityLivingData)null);
		this.getWorld().spawnEntity(entity);
		entityliving.playLivingSound();
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return false;
	}

	@Override
	public int[] getInputSlots() {
		return this.inputs_slots;
	}

	@Override
	public int[] getOutputSlots() {
		return NONE;
	}

	@Override
	public void update() {
		
		if (canSmelt())
			smelt();
		
	}

}
