package fr.mru.OverclockedEngineering.Tiles.TwoModuleMachine;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiTwoModulesMachine extends GuiContainer {
	
	private static final ResourceLocation background = new ResourceLocation(OverclockedEngineering.MODID,"textures/gui/container/two_modules_machine.png");
	private TileTwoModulesMachine tile;

	public GuiTwoModulesMachine(TileTwoModulesMachine tile, InventoryPlayer playerInv) {
        super(new ContainerTwoModulesMachine(tile, playerInv));
        this.tile = tile;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
	    int i = (this.width - this.xSize) / 2;
	    int j = (this.height - this.ySize) / 2;
	    this.drawDefaultBackground();
	    this.mc.getTextureManager().bindTexture(background);
	    this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

	    this.fontRenderer.drawString(this.tile.getName(), i + 60, j + 400, 0xFFFFFF);
	}
}
