package fr.mru.OverclockedengineeringBlocks;

import java.util.Random;

import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class AlienRock extends OverclockedEngineeringBlocksBase {

	public AlienRock() {
		super("alien_rock");
	}
	

    public int quantityDropped(Random random) {
    	return 5;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return OverclokedEngineeringItems.ALIEN_ROCK_FRAGMENT;
    }

}
