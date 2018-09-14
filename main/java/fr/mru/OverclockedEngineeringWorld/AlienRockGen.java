package fr.mru.OverclockedEngineeringWorld;

import java.util.Random;

import fr.mru.OverclockedengineeringBlocks.OverclockedEngineeringBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class AlienRockGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		
		switch ( world.provider.getDimension() ) {
		
		case (0):
			
			runGenerator(OverclockedEngineeringBlocks.ALIEN_ROCK.getDefaultState(), 1, 60, 90, Blocks.TALLGRASS, world, random, chunkX, chunkZ);
			break;
		}
		
	}
	
	private void runGenerator(IBlockState blockToGen, int blockAmount, int minHeight, int maxHeight, Block blockMatcher, 
							  World world, Random rand, int chunk_X, int chunk_Z){
		
		int heightdiff = maxHeight - minHeight +1;
			
		int x = chunk_X * 16 +rand.nextInt(16);
		int y = minHeight + rand.nextInt(heightdiff);
		int z = chunk_Z * 16 + rand.nextInt(16);

		BlockPos pos = new BlockPos(x,y,z);
		if (  world.getBlockState(pos).getBlock() == blockMatcher )	{
			world.setBlockState(pos, blockToGen);
		}
		

	}

}
