package fr.mru.OverclockedEngineeringItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentKeybind;
import net.minecraft.world.World;

public class LocationCard extends OverclockedEngineeringItemsBase {

	public LocationCard() {
		super("location_card");
		
		setMaxStackSize(1);

	}
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
	    if (!worldIn.isRemote) {
    	
	    	ItemStack stack = player.getHeldItem(hand);
	    	NBTTagCompound nbt = stack.getTagCompound();
	    	
	    	if ( player.isSneaking() ) {
	    		
		    	nbt = new NBTTagCompound(); 
		    	nbt.setInteger("x", pos.getX());
		    	nbt.setInteger("y", pos.getY());
		    	nbt.setInteger("z", pos.getZ());
		    	player.sendMessage(new TextComponentKeybind("Target set"));
		    	stack.setTagCompound(nbt);
		    	
	    	} 
	    }
	    
        return EnumActionResult.PASS;
    }
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn) {
		
	    if (!worldIn.isRemote) {
	    	
	    	ItemStack stack = player.getHeldItem(handIn);
	    	NBTTagCompound nbt = stack.getTagCompound();
	    	
	    	if ( nbt != null ) {
	    		player.sendMessage(new TextComponentKeybind("Target location: " + nbt.getInteger("x") + " " + nbt.getInteger("y") + " " + nbt.getInteger("z")));
	    	}
	    }
        
        return new ActionResult(EnumActionResult.PASS, player.getHeldItem(handIn));
    }
	

}
