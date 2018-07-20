package fr.mru.OverclockedEngineeringItems.AgingGun;

import java.util.HashMap;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import fr.mru.OverclockedEngineeringItems.OverclockedEngineeringItemsBase;
import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class AgingGunManager extends OverclockedEngineeringItemsBase {

	private static final SoundEvent SOUND = SoundEvent.REGISTRY.getObject(new ResourceLocation("minecraft:entity.zombie_villager.converted"));
	private HashMap<Block, Block> aging = new HashMap<Block, Block>();
	
	public AgingGunManager( String NAME, HashMap<Block, Block> aging) {
		super(NAME);
		
		this.aging = aging;
		setMaxStackSize(1);
	}
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		Block lookedBlock = worldIn.getBlockState(pos).getBlock();
		Block result = aging.get(lookedBlock);

		if ( result != null ) {
			worldIn.playSound(player, pos, SOUND, null, 0.1f, 2.0f);
			worldIn.setBlockState(pos, result.getBlockState().getBaseState());
		}
		
        return EnumActionResult.PASS;
    }

}
