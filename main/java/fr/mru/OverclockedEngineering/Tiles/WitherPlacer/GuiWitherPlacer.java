package fr.mru.OverclockedEngineering.Tiles.WitherPlacer;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import fr.mru.OverclockedEngineering.Tiles.StackFurnace.ContainerStackFurnace;
import fr.mru.OverclockedEngineering.Tiles.StackFurnace.TileStackFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiWitherPlacer  extends GuiContainer {
	
	private static final ResourceLocation background = new ResourceLocation(OverclockedEngineering.MODID,"textures/gui/container/wither_placer.png");
	private TileWitherPlacer tile;

	public GuiWitherPlacer(TileWitherPlacer tile, InventoryPlayer playerInv) {
        super(new ContainerWitherPlacer(tile, playerInv));
        this.tile = tile;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
	    int i = (this.width - this.xSize) / 2;
	    int j = (this.height - this.ySize) / 2;
	    this.drawDefaultBackground();
	    this.mc.getTextureManager().bindTexture(background);
	    this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

	    //this.fontRenderer.drawString(this.tile.getName(), i + 80, j + 45, 0xFFFFFF);
	}
}
