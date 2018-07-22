package fr.mru.OverclockedEngineeringItems;

import java.awt.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome.SpawnListEntry;

public class DHoleItem extends OverclockedEngineeringItemsBase {
	
	private static final SoundEvent SOUND = SoundEvent.REGISTRY.getObject(new ResourceLocation("minecraft:block.enchantment_table.use"));
	private World targetedWorld = null;

	public DHoleItem() {
		super("dimensional_hole_item");
		
		setMaxStackSize(1);
	}
	
	public World getSelectedWorld() {
		return this.targetedWorld;
	}
	
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		worldIn.playSound(player, pos, SOUND, null, 0.1f, 2.0f);
		targetedWorld = worldIn;
		player.inventory.getCurrentItem().setStackDisplayName(targetedWorld.provider.getDimensionType().name() + " targeted");

        return EnumActionResult.PASS;
    }
	
	public static Entity getMobResult(DHoleItem item) {
		
		World world = item.getSelectedWorld();
		
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

	public boolean hasTarget() {
		return targetedWorld != null;
	}

}
