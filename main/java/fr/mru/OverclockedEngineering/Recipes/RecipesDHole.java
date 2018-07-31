package fr.mru.OverclockedEngineering.Recipes;

import fr.mru.OverclockedEngineeringItems.DHoleItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome.SpawnListEntry;

public class RecipesDHole extends ARecipeManager {

	public static Entity getRecipeResult(World world) {

		if (world == null) 
			return null;
		
		java.util.List<SpawnListEntry> mobsList = world.getBiome(new BlockPos(1,1,1)).getSpawnableList(EnumCreatureType.MONSTER);
		
		if ( mobsList == null || mobsList.isEmpty())
			return null;
		
		SpawnListEntry spawnElementEntity = mobsList.get((int) (Math.random() *100 % mobsList.size()));
		
		try {
			EntityLiving entliving = spawnElementEntity.newInstance(world);
			return entliving.getCommandSenderEntity();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
