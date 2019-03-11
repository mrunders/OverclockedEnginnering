package fr.mru.OverclockedEngineeringStructure;

import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeHills;
import net.minecraft.world.biome.BiomePlains;

public class WorldGenCustomStructuresFactory {
	
	private static final ArrayList<Class<?>> COMMON_BIOMES = new ArrayList<Class<?>>(Arrays.asList(new Class<?>[] {BiomePlains.class, BiomeHills.class}));
	
	public static WorldGenCustomStructures generateCrashedSpaceShip() {
		return new WorldGenCustomStructures(WorldGenCustomStructures.SHIP, 200, Blocks.GRASS, COMMON_BIOMES);
	}
	
	

}
