package fr.mru.OverclockedEngineeringStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import fr.mru.OverclockedEngineeringStructure.StructureVillageAlien.StructureVillageAlienPassiveHouse;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.BiomeHills;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.biome.BiomeSnow;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class WorldGenCustomStructuresFactory {
	
	private static final ArrayList<Class<?>> COMMON_BIOMES = new ArrayList<Class<?>>(Arrays.asList(new Class<?>[] {
			BiomePlains.class, BiomeHills.class, BiomeSnow.class}));
	
	public static void init() {
	
		VillagerRegistry.instance().registerVillageCreationHandler(new StructureVillageAlien.VillagerPieceManager());
		MapGenStructureIO.registerStructureComponent(StructureVillageAlienPassiveHouse.class, OverclockedEngineering.MODID+":AlienPassiveHouse");
	}
	
	public static IWorldGenerator generateStrangeRock() {
		return new AlienRockGen();
	}
	
	public static WorldGenCustomStructures generateCrashedSpaceShip() {
		return new WorldGenCustomStructures(WorldGenCustomStructures.SHIP, 500, Blocks.GRASS, COMMON_BIOMES);
	}
	
	public static WorldGenCustomStructures generateCapsule() {
		return new WorldGenCustomStructures(WorldGenCustomStructures.CAPSULE, 700, Blocks.GRASS, COMMON_BIOMES);
	}
	
}
