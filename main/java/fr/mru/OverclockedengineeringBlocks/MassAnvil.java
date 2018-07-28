package fr.mru.OverclockedengineeringBlocks;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MassAnvil extends BlockFalling {
	
	public MassAnvil() {
		
		super(Material.ANVIL);
		
		OverclockedEngineeringBlocks.setBlockName(this, "mass_anvil");
		setCreativeTab(OverclockedEngineering.overclockedTab);
		OverclokedEngineeringItems.registerItemBlock(this);
	}
	
	
    protected void onStartFalling(EntityFallingBlock fallingEntity) {
        fallingEntity.setHurtEntities(true);
    }

    public void onEndFalling(World worldIn, BlockPos pos, IBlockState p_176502_3_, IBlockState p_176502_4_) {
    	
    	if ( worldIn.isRemote) return;
    	
    	if ( worldIn.getBlockState(pos.down(2)).getBlock() == Blocks.OBSIDIAN ) {
    		
    		BlockPos pos1 = pos.down();
    		if ( worldIn.getBlockState(pos1).getBlock() == Blocks.IRON_BLOCK) {
    			
    			worldIn.setBlockState(pos1, Blocks.AIR.getDefaultState());
    			worldIn.spawnEntity(new EntityItem(worldIn, pos1.getX(), pos1.getY(), pos1.getZ(), new ItemStack(OverclokedEngineeringItems.CIRCUIT, 8)));
    		}
    	}
    	
        worldIn.playEvent(1031, pos, 0);
    }

    public void onBroken(World worldIn, BlockPos pos) {
        worldIn.playEvent(1029, pos, 0);
    }
    
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
    
}
