package fr.mru.OverclockedEngineeringItems;

import cofh.cofhworld.util.numbers.world.WorldValueProvider;
import fr.mru.OverclockedEngineering.Recipes.RecipesDHole;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.DimensionManager;

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
		
	    if (!worldIn.isRemote) {
	    	
	    	ItemStack stack = player.inventory.getCurrentItem();
	    	NBTTagCompound nbt = new NBTTagCompound();
	    	
	    	nbt.setInteger("world", worldIn.provider.getDimensionType().getId());
	    	stack.deserializeNBT(nbt);
	    	
			worldIn.playSound(player, pos, SOUND, null, 0.1f, 2.0f);

			targetedWorld = worldIn;
			stack.setStackDisplayName(targetedWorld.provider.getDimensionType().name() + " targeted");

	    }
	    
        return EnumActionResult.PASS;
    }
	
	public static Entity getMobResult(ItemStack itemStack) {
	
		DHoleItem i = ((DHoleItem) itemStack.getItem());
		
		if ( i.getSelectedWorld() == null ) {
			
			NBTTagCompound nbt = itemStack.serializeNBT();
			i.targetedWorld = DimensionManager.getWorld(nbt.getInteger("world"));
			
		}
		
		return RecipesDHole.getRecipeResult(i.targetedWorld);
	}

	public boolean hasTarget() {
		return targetedWorld != null;
	}

}
