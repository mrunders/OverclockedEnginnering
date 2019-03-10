package fr.mru.OverclockedEngineering.Tiles.TransporterItems;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequestMap;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileInstantProcessingManager;
import fr.mru.OverclockedEngineering.Tiles.StackFurnace.ContainerStackFurnace;
import fr.mru.OverclockedEngineering.Tiles.StackFurnace.GuiStackFurnace;
import fr.mru.OverclockedEngineering.Tiles.StackFurnace.TileStackFurnace;
import fr.mru.OverclockedEngineeringItems.LocationCard;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;

public class TileTransporterItems extends ATileInstantProcessingManager {
	
	private static final int[] INPUT_SLOT = new int[] { 1 };
	
	public TileTransporterItems() {
		super(2, "transporter_items");
	}

	@Override
	public Object getServerGuiElement(TileEntity te, InventoryPlayer inventory) {
		return new ContainerTransporterItems((TileTransporterItems)te, inventory);
	}

	@Override
	public Object getClientGuiElement(TileEntity te, InventoryPlayer inventory) {
		return new GuiTransporterItems((TileTransporterItems)te, inventory);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		
	    super.readFromNBT(compound);

	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
	    super.writeToNBT(compound);

	    ItemStackHelper.saveAllItems(compound, this.stacks);
	    
	    return compound;
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		
		return index == 1 && (getStackInSlot(1).isEmpty() || RecipeRequestMap.itemStackEqual(stack, getStackInSlot(1)));
	}

	@Override
	public ItemStack getRecipeResult() { return null; }

	@Override
	public boolean canSmelt() { return false; }

	@Override
	public void smelt() { }

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) { return false; }

	@Override
	public int[] getInputSlots() {
		return INPUT_SLOT;
	}

	@Override
	public int[] getOutputSlots() {
		return NONE;
	}

	@Override
	public void update() {
		
		if ( !world.isRemote ) {
			
			ItemStack stack = getStackInSlot(0);
			
			if ( stack != null && stack.getItem() instanceof LocationCard ) {
				NBTTagCompound nbt = stack.getTagCompound();
				
				if ( nbt != null ) {
					BlockPos pos = new BlockPos(nbt.getInteger("x"), nbt.getInteger("y"), nbt.getInteger("z"));
					TileEntity tile = world.getTileEntity(pos);
					
					if ( tile != null && tile instanceof IInventory ) {
						autoOutput(1, (IInventory) tile);
					}
				}
				
			}
			
		}
		
	}



}
