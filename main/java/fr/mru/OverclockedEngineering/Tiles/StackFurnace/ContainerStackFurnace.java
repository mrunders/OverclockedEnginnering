package fr.mru.OverclockedEngineering.Tiles.StackFurnace;

import fr.mru.OverclockedengineeringBlocks.SlotOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerStackFurnace extends Container {
	
	private TileStackFurnace tile;
	private int	timePassed = 0;
	private int	burnTimeLeft = 0;

	public ContainerStackFurnace(TileStackFurnace tile, InventoryPlayer playerInventory) {
	    this.tile = tile;

	    int i;
	    for(i = tile.START_INPUT_SLOT; i < tile.END_INPUT_SLOT; ++i) {
	        this.addSlotToContainer(new Slot(tile, i, 62 + i * 18, 30));
	    }
	    
	    for(i = tile.START_OUTPUT_SLOT; i < tile.END_OUTPUT_SLOT; ++i) {
	        this.addSlotToContainer(new SlotOutput(tile, i, 44 + ((i - tile.START_OUTPUT_SLOT)* 18), 60));
	    }
	    
	    for(i = 0; i < 3; ++i) {
	        for(int j = 0; j < 9; ++j) {
	            this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
	        }
	    }
	    
	    for(i = 0; i < 9; ++i) {
	        this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 142));
	    }
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
	    return tile.isUsableByPlayer(player);
	}
	
	@Override
	public void addListener(IContainerListener listener) {
	    super.addListener(listener);
	    listener.sendAllWindowProperties(this, this.tile);
	}

	@Override
	public void detectAndSendChanges() {
	    super.detectAndSendChanges();

	    for(int i = 0; i < this.listeners.size(); ++i) {
	        IContainerListener icontainerlistener = (IContainerListener) this.listeners
	                .get(i);

	        if (this.burnTimeLeft != this.tile.getField(0)) {
	            icontainerlistener.sendWindowProperty(this, 0,
	                    this.tile.getField(0));
	        }

	        if (this.timePassed != this.tile.getField(1)) {
	            icontainerlistener.sendWindowProperty(this, 1,
	                    this.tile.getField(1));
	        }
	    }

	    this.burnTimeLeft = this.tile.getField(0);
	    this.timePassed = this.tile.getField(1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) {
	    this.tile.setField(id, data);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
	    return ItemStack.EMPTY;
	}
}
