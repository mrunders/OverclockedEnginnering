package fr.mru.OverclockedEngineering.Tiles.ATileManager;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;

public interface IGuiElement {
	
	public Object getServerGuiElement(TileEntity te, InventoryPlayer inventory);
	public Object getClientGuiElement(TileEntity te, InventoryPlayer inventory);

}
