package fr.mru.OverclockedEngineering.Tiles.UncraftingTable;

import java.awt.List;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import fr.mru.OverclockedengineeringBlocks.OverclockedEngineeringBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class UncraftingTable extends Block {
	
	private static final SoundEvent SOUND = SoundEvent.REGISTRY.getObject(new ResourceLocation("minecraft:entity.experience_orb.pickup"));

	public UncraftingTable() {
		super(Material.ANVIL);
		
		OverclockedEngineeringBlocks.setBlockName(this, "uncrafting_table");
		setCreativeTab(OverclockedEngineering.overclockedTab);
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par2List, boolean par4) {
		
		par2List.add("\u00a7a" + "Uncraft everything that can be craft on crafting table (cost 9 exp level)");
	
	}
	
	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        
		ItemStack itemOnMainHand = playerIn.inventory.getCurrentItem();
		
		if ( itemOnMainHand.isEmpty()) 
			return false;
		
		if ( playerIn.experienceLevel < 9)
			return false;
		
		IRecipe r = ForgeRegistries.RECIPES.getValue(itemOnMainHand.getItem().getRegistryName());
		
		if (r == null || r.getRecipeOutput().getCount() != 1) 
			return false;
		
		itemOnMainHand.setCount(itemOnMainHand.getCount()-1);
		playerIn.addExperienceLevel(-9);
		worldIn.playSound(playerIn, pos, SOUND, null, 0.2F, 0);
		
		r.getIngredients().forEach(System.out::print);
		
		for (Ingredient ingr : r.getIngredients()) {
			if ( ingr.getMatchingStacks().length == 0 ) continue;
			
			playerIn.inventory.addItemStackToInventory(ingr.getMatchingStacks()[0].copy());
			
		}
			
		return true;
    }

}
