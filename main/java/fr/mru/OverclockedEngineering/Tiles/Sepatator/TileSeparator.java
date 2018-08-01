package fr.mru.OverclockedEngineering.Tiles.Sepatator;

import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileMultiblocksManager;
import net.minecraft.tileentity.TileEntity;

public class TileSeparator extends ATileMultiblocksManager {

	public TileSeparator() {
		super(0, "tile_separator");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean checkStructure() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void setupStructure() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void resetStructure() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isInstanceOf(TileEntity tile) {
		return tile instanceof TileSeparator;
	}

	@Override
	protected boolean isMaster(TileEntity tile) {
		// TODO Auto-generated method stub
		return false;
	}


}
