package fr.mru.OverclockedEngineering.Tiles.OneItemDropper;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import fr.mru.OverclockedEngineering.Tiles.Cobble_form.ContainerCobbleForm;
import fr.mru.OverclockedEngineering.Tiles.Cobble_form.TileCobbleForm;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiOneItemDropper extends GuiContainer {
	
	private static final ResourceLocation background = new ResourceLocation(OverclockedEngineering.MODID,"textures/gui/container/one_item_dropper.png");
	private TileOneItemDropper tile;

	public GuiOneItemDropper(TileOneItemDropper tile, InventoryPlayer playerInv) {
        super(new ContainerOneItemDropper(tile, playerInv));
        this.tile = tile;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
	    int i = (this.width - this.xSize) / 2;
	    int j = (this.height - this.ySize) / 2;
	    this.drawDefaultBackground();
	    this.mc.getTextureManager().bindTexture(background);
	    this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

	}
}
