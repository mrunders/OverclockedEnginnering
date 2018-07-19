package fr.mru.OverclockedEngineeringItems;

import java.util.Set;

import com.google.common.collect.Sets;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentKeybind;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;


public class MiningPickaxe extends ItemTool {
	
	private static final ToolMaterial MINING_PICKAXE = EnumHelper.addToolMaterial("Mining Pickaxe", 4, 10, 100.0F, 1.5F, 1);
	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.STONE,Blocks.GRAVEL, Blocks.SAND, Blocks.OBSIDIAN, Blocks.DIRT);

	private MODE currentMod;
	
	protected MiningPickaxe() {
		super(1.0F, -2.8F, MINING_PICKAXE, EFFECTIVE_ON);
		currentMod = MODE.NONE;
		
		OverclokedEngineeringItems.setItemName(this, "mining_pickaxe");
		setCreativeTab(OverclockedEngineering.overclockedTab);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
		
		if ( currentMod == MODE.NONE ) {
			currentMod = MODE.FORTUNE;
			//player.getHeldItemMainhand().addEnchantment(Enchantment.getEnchantmentByLocation("fortune"), 3);
			
		}
		else if ( currentMod == MODE.FORTUNE) {
			currentMod = MODE.SILKTOUCH;
			//player.getHeldItemMainhand().addEnchantment(Enchantment.getEnchantmentByLocation("fortune"), 0);
			//player.getHeldItemMainhand().addEnchantment(Enchantment.getEnchantmentByLocation("silk-touch"), 1);
		}
		else {
			currentMod = MODE.NONE;
			//player.getHeldItemMainhand().addEnchantment(Enchantment.getEnchantmentByLocation("silk-touch"), 0);
			
		}
		
        if(!world.isRemote) {
            player.sendMessage(new TextComponentKeybind( "pickaxe mod set to " +  currentMod));
        }
        
        return new ActionResult(EnumActionResult.PASS, player.getHeldItem(handIn));
    }
	
	@Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
		
        return true;
    }
	
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        stack.damageItem(1, attacker);
        return true;
    }
	
	@Override
	public boolean canHarvestBlock(IBlockState blockIn) {
		
		return true;
	}
	
	@Override
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        return this.efficiency;
    }

}
