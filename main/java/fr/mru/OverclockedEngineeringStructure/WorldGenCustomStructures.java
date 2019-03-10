package fr.mru.OverclockedEngineeringStructure;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import scala.actors.threadpool.Arrays;

public class WorldGenCustomStructures implements IWorldGenerator {
	
	public static final Structure SHIP = new Structure("crashedspaceship");
	
	private int chance;
	private Block topBlock;
	private Structure struct;
	private ArrayList<Class<?>> classList;
	
	public WorldGenCustomStructures(Structure struct, int chance, Block topBlock, ArrayList<Class<?>> classes) {
		
		this.struct = struct;
		this.chance = chance;
		this.topBlock = topBlock;
		this.classList = classes;
	}


	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {

		if (world.provider.getDimension() == 0) {
			generateStructure(world, random, chunkX, chunkZ);
		}
		
	} 
	
	private void generateStructure( World world, Random random, int chunkX, int chunkZ ) {
		
		int x = (chunkX * 16) + random.nextInt(15);
		int z = (chunkZ * 16) + random.nextInt(15);
		int y = calculateGenerationHeight(world, x, z, this.topBlock);
		
		if ( random.nextInt(this.chance) == 0) {
			
			BlockPos pos = new BlockPos(x,y,z);
			Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
			
			if ( this.classList.contains(biome)) {
	
				this.struct.generate(world, random, pos);
			}	
		}
	}
	
	private static int calculateGenerationHeight(World world, int x, int z, Block topBlock) {
		
		int y = world.getHeight();
		boolean foundGround = false;
		
		while (!foundGround && y-- >= 0) {
			Block block = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround = block == topBlock;
		}
		
		return y;
	}
	

}
