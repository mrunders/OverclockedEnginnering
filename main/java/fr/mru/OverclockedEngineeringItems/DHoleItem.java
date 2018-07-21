package fr.mru.OverclockedEngineeringItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
		
        return EnumActionResult.PASS;
    }

}
