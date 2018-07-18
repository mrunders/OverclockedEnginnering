package fr.mru.OverclockedEngineering;

import fr.mru.OverclockedEngineering.Machine.ContainerOverclockedFurnace;
import fr.mru.OverclockedEngineering.Machine.GuiOverclockedFurnace;
import fr.mru.OverclockedEngineering.Machine.TileOverclockedFurnace;
import fr.mru.OverclockedEngineering.StackFurnace.ContainerStackFurnace;
import fr.mru.OverclockedEngineering.StackFurnace.GuiStackFurnace;
import fr.mru.OverclockedEngineering.StackFurnace.TileStackFurnace;
import fr.mru.OverclockedEngineering.TreeFarmer.ContainerTreeFarmer;
import fr.mru.OverclockedEngineering.TreeFarmer.GuiTreeFarmer;
import fr.mru.OverclockedEngineering.TreeFarmer.TileTreeFarmer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        if(te instanceof TileOverclockedFurnace) {
            return new ContainerOverclockedFurnace((TileOverclockedFurnace)te, player.inventory);
        } else if (te instanceof TileStackFurnace) {
        	return new ContainerStackFurnace((TileStackFurnace)te, player.inventory);
        } else if (te instanceof TileTreeFarmer) {
        	return new ContainerTreeFarmer((TileTreeFarmer)te, player.inventory);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        if(te instanceof TileOverclockedFurnace) {
            return new GuiOverclockedFurnace((TileOverclockedFurnace)te, player.inventory);
        } else if ( te instanceof TileStackFurnace ) {
        	return new GuiStackFurnace((TileStackFurnace)te, player.inventory);
        }else if ( te instanceof TileTreeFarmer ) {
        	return new GuiTreeFarmer((TileTreeFarmer)te, player.inventory);
        }
        return null;
    }
}