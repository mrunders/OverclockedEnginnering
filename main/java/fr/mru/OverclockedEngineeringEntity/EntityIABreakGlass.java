package fr.mru.OverclockedEngineeringEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.ai.EntityAIMoveToBlock;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityIABreakGlass extends EntityAIMoveToBlock {

	private EntityVillager villager;

	public EntityIABreakGlass(EntityVillager entityIn, double speedIn) {
		super(entityIn, speedIn, 8);
		villager = entityIn;
	}
	
    /**
     * Return true to set given position as destination
     */
	@Override
    protected boolean shouldMoveTo(World worldIn, BlockPos pos) {
        Block block = worldIn.getBlockState(pos).getBlock();

        return block == Blocks.GLASS || block == Blocks.GLASS_PANE;
    }

	public void updateTask() {
        super.updateTask();
    }

}
