package fr.mru.OverclockedEngineeringItems.AgingGun;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class AgingGunIncremental extends AgingGunManager {
	
	private static HashMap<Block, Block> aging = new HashMap<>();
	
	static {
		
		aging.put(Blocks.COBBLESTONE, Blocks.STONE);
		aging.put(Blocks.GRAVEL, Blocks.COBBLESTONE);
		aging.put(Blocks.SAND, Blocks.GRAVEL);
		aging.put(Blocks.GLASS, Blocks.SAND);
		
	}

	public AgingGunIncremental() {
		super("aging_gun_incremantal", aging);

	}


}
