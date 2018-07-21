package fr.mru.OverclockedEngineering.Tiles.Machine;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiOverclockedFurnace extends GuiContainer {
	
	private static final ResourceLocation background = new ResourceLocation(OverclockedEngineering.MODID,"textures/gui/container/overclocked_furnace.png");
	private TileOverclockedFurnace tile;

	public GuiOverclockedFurnace(TileOverclockedFurnace tile, InventoryPlayer playerInv) {
        super(new ContainerOverclockedFurnace(tile, playerInv));
        this.tile = tile;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
	    int i = (this.width - this.xSize) / 2;
	    int j = (this.height - this.ySize) / 2;
	    this.drawDefaultBackground();
	    this.mc.getTextureManager().bindTexture(background);
	    this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

	    int timePassed = this.tile.getField(1);
	    int textureWidth = (int) (23f / 200f * timePassed);
	    this.drawTexturedModalRect(i + 81, j + 44, 177, 18, textureWidth, 7);

	    this.fontRenderer.drawString(this.tile.getName(), i + 60, j + 400, 0xFFFFFF);
	}
}
