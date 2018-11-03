package fr.mru.OverclockedEngineeringStructure;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class CrashedSpaceShip implements IWorldGenerator {

	public boolean generate(World world, Random rand, BlockPos position) {
		
		if ( world.getBlockState(position).getBlock() == Blocks.GRASS);
		
		System.out.println("look at here: " + position.toString());
		
		int x = position.getX() - 4,
			z = position.getZ() - 4,
			maxx = x + 8,
			maxz = z + 8;
		
		for ( ; x < maxx; ++x ) {
			for ( ; z < maxz; ++z) {
				world.setBlockState(new BlockPos(x, position.getY(), z), Blocks.IRON_BLOCK.getDefaultState());
			}
		}
		
		
		return true;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		
		if ( random.nextInt(100) == 1 ) {
			generate(world, random, new BlockPos(chunkX, 70 ,chunkZ));
		}
		
	}

}
