package fr.mru.OverclockedEngineering.Tiles.TreeFarmer;

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

public class ContainerTreeFarmer extends ContainerManager {
	
	public ContainerTreeFarmer(TileTreeFarmer tile, InventoryPlayer playerInventory) {
		super(tile, playerInventory);
	}

	@Override
	public boolean displaySlots(ATileManager tile, InventoryPlayer playerInventory) {
		
	    this.addSlotToContainer(new Slot(tile, 0, 35, 15));
	    this.addSlotToContainer(new Slot(tile, 1, 35, 50));
	    
	    this.addSlotToContainer(new SlotOutput(tile, 2, 100 , 32));
	    this.addSlotToContainer(new SlotOutput(tile, 3, 122 , 32));
	    
	    return false;
	}
}
