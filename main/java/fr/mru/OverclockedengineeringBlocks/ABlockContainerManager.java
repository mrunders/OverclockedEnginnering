package fr.mru.OverclockedengineeringBlocks;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class ABlockContainerManager extends BlockContainer {
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;

	protected ABlockContainerManager(String name) {
		super(Material.ANVIL);
		
		OverclockedEngineeringBlocks.setBlockName(this, name);
		setCreativeTab(OverclockedEngineering.overclockedTab);
	}
	
	@Override
	public abstract TileEntity createNewTileEntity(World world, int metadata);

	@Override
	public abstract boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ);
	
	@Override
	public boolean hasTileEntity() {
	    return true;
	}
	
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {
        EnumFacing entityFacing = entity.getHorizontalFacing();

        if(!world.isRemote) {
            if(entityFacing == EnumFacing.NORTH) {
                entityFacing = EnumFacing.SOUTH;
            } else if(entityFacing == EnumFacing.EAST) {
                entityFacing = EnumFacing.WEST;
            } else if(entityFacing == EnumFacing.SOUTH) {
                entityFacing = EnumFacing.NORTH;
            } else if(entityFacing == EnumFacing.WEST) {
                entityFacing = EnumFacing.EAST;
            }

            world.setBlockState(pos, state.withProperty(FACING, entityFacing), 2);
        }
    }
    
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
	    return EnumBlockRenderType.MODEL;
	}

}
