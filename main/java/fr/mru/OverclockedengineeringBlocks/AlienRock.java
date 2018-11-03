package fr.mru.OverclockedengineeringBlocks;

import java.util.Random;

import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class AlienRock extends OverclockedEngineeringBlocksBase {
	
	public static final String DESCRIPTION = "What is it? A strange rock from the space, a bit warm, i should use diamond pickaxe";

	public AlienRock() {
		super("alien_rock");
		
		setHardness(50.0F);
		setResistance(2000.0F);
	}
	

    public int quantityDropped(Random random) {
    	return 5;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return OverclokedEngineeringItems.ALIEN_ROCK_FRAGMENT;
    }

}
