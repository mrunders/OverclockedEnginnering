package fr.mru.OverclockedEngineeringItems.AgingGun;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class AgingGunDecremantal extends AgingGunManager {
	
	private static HashMap<Block, Block> aging = new HashMap<>();
	
	static {
		
		aging.put(Blocks.STONE, Blocks.COBBLESTONE);
		aging.put(Blocks.COBBLESTONE, Blocks.GRAVEL);
		aging.put(Blocks.GRAVEL, Blocks.SAND);
		aging.put(Blocks.SAND, Blocks.GLASS);
	}

	public AgingGunDecremantal() {
		
		super("aging_gun_decremantal", aging);

	}


}
