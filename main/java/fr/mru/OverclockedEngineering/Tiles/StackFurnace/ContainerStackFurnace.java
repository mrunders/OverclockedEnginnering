package fr.mru.OverclockedEngineering.Tiles.StackFurnace;

import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileManager;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.ContainerManager;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.SlotOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerStackFurnace extends ContainerManager {

	public ContainerStackFurnace(TileStackFurnace tile, InventoryPlayer playerInventory) {
		super(tile, playerInventory);
	}

	@Override
	public boolean displaySlots(ATileManager tile, InventoryPlayer playerInventory) {
	    this.addSlotToContainer(new Slot(tile, 0, 44, 30));
	    this.addSlotToContainer(new SlotOutput(tile, 1, 116, 30));
	    
	    return false;
	}
}
