package fr.mru.OverclockedEngineeringItems.AgingGun;

import java.util.HashMap;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class AgingGunIncremental extends AgingGunManager {
	
	private static HashMap<Block, Block> aging = new HashMap<>();
	
	static {
		
		aging.put(Blocks.COBBLESTONE, Blocks.STONE);
		aging.put(Blocks.GRAVEL, Blocks.COBBLESTONE);
		aging.put(Blocks.SAND, Blocks.GRAVEL);
		aging.put(Blocks.GLASS, Blocks.SAND);
		
		aging.put(Blocks.ICE,Blocks.WATER);
		aging.put(Blocks.PACKED_ICE,Blocks.ICE);
		aging.put(Blocks.SNOW, Blocks.PACKED_ICE);
		
		aging.put(Blocks.MAGMA, Blocks.LAVA);
		aging.put(Blocks.NETHER_BRICK, Blocks.MAGMA);
		aging.put(Blocks.NETHERRACK, Blocks.NETHER_BRICK);
	}

	public AgingGunIncremental() {
		super("aging_gun_incremantal", aging);

	}
	
	public static Set<Block> getRecipesList() {
		return aging.keySet();
	}
	
	public static Block getResult(Block block) {
		return aging.get(block);
	}


}
