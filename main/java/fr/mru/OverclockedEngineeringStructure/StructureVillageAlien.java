package fr.mru.OverclockedEngineeringStructure;

import java.util.List;
import java.util.Random;

import fr.mru.OverclockedEngineeringEntity.AlienVillagers;
import fr.mru.OverclockedengineeringBlocks.EngineBlockManager;
import fr.mru.OverclockedengineeringBlocks.OverclockedEngineeringBlocks;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSlab.EnumBlockHalf;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces.PieceWeight;
import net.minecraft.world.gen.structure.StructureVillagePieces.Start;
import net.minecraft.world.gen.structure.StructureVillagePieces.Village;
import net.minecraftforge.fml.common.registry.VillagerRegistry.IVillageCreationHandler;

public class StructureVillageAlien {
	
	public static class VillagerPieceManager implements IVillageCreationHandler {

		@Override
		public PieceWeight getVillagePieceWeight(Random random, int i) {
			return new PieceWeight(StructureVillageAlienPassiveHouse.class, 11 , MathHelper.getInt(random, 0+i, 1+i));
		}

		@Override
		public Class<?> getComponentClass() {
			return StructureVillageAlienPassiveHouse.class;
		}

		@Override
		public Village buildComponent(PieceWeight villagePiece, Start startPiece, List<StructureComponent> pieces,
				Random random, int p1, int p2, int p3, EnumFacing facing, int p5) {
			
			StructureBoundingBox box = StructureBoundingBox.getComponentToAddBoundingBox(p1, p2, p3, 0, 0, 0, 10, 8, 8, facing);
			return new StructureVillageAlienPassiveHouse(startPiece, p5, random, box, facing);

		}
	}

	public static class StructureVillageAlienPassiveHouse extends Village {
		
		private int groundLevel = -1;
	
		public StructureVillageAlienPassiveHouse(Start startPiece, int p5, Random random, StructureBoundingBox box,
				EnumFacing facing) {
			
			super(startPiece, p5);
			this.setCoordBaseMode(facing);
			this.boundingBox = box;
		}

		@Override
		public boolean addComponentParts(World world, Random rand, StructureBoundingBox box) {
	
			if(groundLevel < 0)
			{
				groundLevel = this.getAverageGroundLevel(world, box);
				if(groundLevel < 0)
					return true;
				boundingBox.offset(0, groundLevel-boundingBox.maxY+7, 0);
			}
			
			IBlockState cobble = this.getBiomeSpecificBlockState(Blocks.COBBLESTONE.getDefaultState()),
					    wood   = this.getBiomeSpecificBlockState(Blocks.PLANKS.getDefaultState()),
					    log    = this.getBiomeSpecificBlockState(Blocks.LOG.getDefaultState()),
					    ship   = OverclockedEngineeringBlocks.STRUCTURE_SHIP_BLOCK.getDefaultState(),
					    slab   = Blocks.STONE_SLAB.getDefaultState();

			//Clear Space
			this.fillWithAir(world, box, 0, 0, 0, 8, 6, 6);
			
			//base cobblestone
			this.fillWithBlocks(world, box, 1, 0 , 1, 8, 0, 6, cobble, cobble, false);
			
			//entry slab
			this.setBlockState(world, slab, 3, 0, 0, box);
			this.setBlockState(world, slab, 4, 0, 0, box);
			this.setBlockState(world, slab, 5, 0, 0, box);
			
			//indoor ground
			this.fillWithBlocks(world, box, 2, 0, 2, 7, 0, 5, ship, ship, false);

			//fill wooden walls
			this.fillWithBlocks(world, box, 1, 1, 1, 8, 5, 6, wood, wood, false);
			
			//clear room
			this.fillWithAir(world, box, 2, 1, 2, 7, 4, 5);
			
			//machines casing
			this.setBlockState(world, OverclockedEngineeringBlocks.MACHINE_CASING.getDefaultState(), 7, 1, 4, box);
			this.setBlockState(world, OverclockedEngineeringBlocks.MACHINE_CASING.getDefaultState(), 7, 1, 5, box);
			this.setBlockState(world, OverclockedEngineeringBlocks.MACHINE_CASING.getDefaultState(), 6, 1, 5, box);
			this.setBlockState(world, OverclockedEngineeringBlocks.MACHINE_CASING.getDefaultState(), 7, 2, 5, box);
			
			//entry door
			this.setBlockState(world, Blocks.AIR.getDefaultState(), 4, 2, 1, box);
			this.setBlockState(world, Blocks.AIR.getDefaultState(), 4, 1, 1, box);
            this.createVillageDoor(world, box, rand, 4, 1, 1, EnumFacing.NORTH);
			
			// lava water generator boc
			this.setBlockState(world, EngineBlockManager.HENGINE_BLOCK1.getDefaultState(), 2, 1, 5, box);

			//Windows
			this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 6, 2, 1, box);
			this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 1, 2, 3, box);
			this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 1, 2, 4, box);
			this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 3, box);
			this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 4, box);
			this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 4, 2, 6, box);
			this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 5, 2, 6, box);

			//roof
			this.fillWithBlocks(world, box, 1, 4, 1, 8, 4, 6, cobble, cobble, false);
			this.fillWithBlocks(world, box, 1, 5, 1, 8, 5, 6, slab, slab, false);
			this.fillWithAir(world, box, 2, 5, 2, 7, 5, 5);

			//corner log pillars
			this.fillWithBlocks(world, box, 1, 1, 1, 1, 3, 1, log, log, false);
			this.fillWithBlocks(world, box, 8, 1, 6, 8, 3, 6, log, log, false);
			this.fillWithBlocks(world, box, 1, 1, 6, 1, 3, 6, log, log, false);
			this.fillWithBlocks(world, box, 8, 1, 1, 8, 3, 1, log, log, false);

			//spawn png
            this.spawnAlien(world, 4, 2, 3);
            if ( rand.nextBoolean() ) this.spawnAlien(world, 4, 2, 4);
            
			return false;
		}
		
		public void spawnAlien(World world, int px, int py, int pz) {
			
			int j = this.getXWithOffset(px, pz);
            int k = this.getYWithOffset(py);
            int l = this.getZWithOffset(px, pz);
            EntityVillager entityvillager = new EntityVillager(world);
            entityvillager.setLocationAndAngles((double)j + 0.5D, (double)k, (double)l + 0.5D, 0.0F, 0.0F);
            entityvillager.setProfession(AlienVillagers.alien_passive);
            entityvillager.finalizeMobSpawn(world.getDifficultyForLocation(new BlockPos(entityvillager)), (IEntityLivingData)null, false);
            world.spawnEntity(entityvillager);
		}
	}
}
