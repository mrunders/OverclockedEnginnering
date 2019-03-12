package fr.mru.OverclockedengineeringBlocks;

import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CatalyserSlot extends OverclockedEngineeringBlocksBase {

	public CatalyserSlot() {
		super("catalyser_slot");
		
		setBlockUnbreakable();
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
	    if (world.isRemote) {
	    	return true;
	    	
	    } else {
	        
	    	ItemStack item_on_hand = player.getHeldItem(hand);
	    	
	    	if (item_on_hand.isEmpty()) return true;
	    	
	    	Item item = item_on_hand.getItem();
	    	
	    	if (item == OverclokedEngineeringItems.CATALYSER) {
	    		System.out.println("Catalyser detected");
	    	}
	    	
	    	
	    	return true;
	    }
	    
	}

}
