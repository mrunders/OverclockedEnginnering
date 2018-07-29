package fr.mru.OverclockedengineeringBlocks;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import fr.mru.OverclockedEngineering.Tiles.ATileManager.ATileManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class ABlockContainerManager extends BlockContainer {
	
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
	public EnumBlockRenderType getRenderType(IBlockState state) {
	    return EnumBlockRenderType.MODEL;
	}
	
	@Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		
		((ATileManager) worldIn.getTileEntity(pos)).setRedstoneControl( worldIn.isBlockPowered(pos) );

    }

}
