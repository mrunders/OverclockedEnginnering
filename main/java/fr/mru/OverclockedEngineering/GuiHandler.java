package fr.mru.OverclockedEngineering;

import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileManager;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.IGuiElement;
import fr.mru.OverclockedEngineering.Tiles.Cobble_form.ContainerCobbleForm;
import fr.mru.OverclockedEngineering.Tiles.Cobble_form.GuiCobbleForm;
import fr.mru.OverclockedEngineering.Tiles.Cobble_form.TileCobbleForm;
import fr.mru.OverclockedEngineering.Tiles.DimensionalHole.ContainerDHole;
import fr.mru.OverclockedEngineering.Tiles.DimensionalHole.GuiDHole;
import fr.mru.OverclockedEngineering.Tiles.DimensionalHole.TileDHole;
import fr.mru.OverclockedEngineering.Tiles.Machine.ContainerOverclockedFurnace;
import fr.mru.OverclockedEngineering.Tiles.Machine.GuiOverclockedFurnace;
import fr.mru.OverclockedEngineering.Tiles.Machine.TileOverclockedFurnace;
import fr.mru.OverclockedEngineering.Tiles.StackFurnace.ContainerStackFurnace;
import fr.mru.OverclockedEngineering.Tiles.StackFurnace.GuiStackFurnace;
import fr.mru.OverclockedEngineering.Tiles.StackFurnace.TileStackFurnace;
import fr.mru.OverclockedEngineering.Tiles.TreeFarmer.ContainerTreeFarmer;
import fr.mru.OverclockedEngineering.Tiles.TreeFarmer.GuiTreeFarmer;
import fr.mru.OverclockedEngineering.Tiles.TreeFarmer.TileTreeFarmer;
import fr.mru.OverclockedEngineering.Tiles.TwoModuleMachine.ContainerTwoModulesMachine;
import fr.mru.OverclockedEngineering.Tiles.TwoModuleMachine.GuiTwoModulesMachine;
import fr.mru.OverclockedEngineering.Tiles.TwoModuleMachine.TileTwoModulesMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        return ((IGuiElement)te).getServerGuiElement(te, player.inventory);
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        return ((IGuiElement)te).getClientGuiElement(te, player.inventory);
    }
}