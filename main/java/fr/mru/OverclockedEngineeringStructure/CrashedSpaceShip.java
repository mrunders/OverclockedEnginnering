package fr.mru.OverclockedEngineeringStructure;

import java.util.Random;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.fml.common.IWorldGenerator;

public class CrashedSpaceShip extends WorldGenerator implements IStructure {
	
	public static String structureName = "crashedspaceship";
	
	public CrashedSpaceShip() {
		
	}

	public boolean generate(World world, Random rand, BlockPos pos) {
		
		this.generateStructure(world, pos);
		
		return true;
	}

	public static void generateStructure(World world, BlockPos pos) {
		
		MinecraftServer mcserv = world.getMinecraftServer();
		TemplateManager manager = worldserver.getStructureTemplateManager();
		ResourceLocation location = new ResourceLocation(OverclockedEngineering.MODID, structureName);
		Template template = manager.get(mcserv, location);
		
		if (template != null) {
			
			IBlockState state = world.getBlockState(pos);
			world.notifyBlockUpdate(pos, state, state, 3);
			template.addBlocksToWorldChunk(world, pos, settings);
		}
	}

}
