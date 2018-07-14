package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;
import java.util.PriorityQueue;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

public class RecipesGrinder extends RecipeManager {
	
	public static final HashMap <ItemStack[], ItemStack>recipes = new HashMap<ItemStack[], ItemStack>();
	
	static {
		addRecipe(recipes, Blocks.COBBLESTONE, Blocks.GRAVEL);
		addRecipe(recipes, Blocks.GRAVEL, Blocks.SAND);
	}
	
	public static ItemStack getRecipeResult(ItemStack[] ingredients) {
	    return getRecipeResult(recipes, new ItemStack[] {ingredients[0]});
	    
	}
	
	public static boolean initialise() {
		
		PriorityQueue<String> oreList = new PriorityQueue<>(),
							  gemList = new PriorityQueue<>(),
							  dustList = new PriorityQueue<>(),
							  ingotList = new PriorityQueue<>();
		
		
		for (String ore : OreDictionary.getOreNames()) {
			if ( ore.startsWith("ore") ) {
				oreList.add(ore.substring(3));
			} else if ( ore.startsWith("dust")) {
				dustList.add(ore.substring(4));
			} else if ( ore.startsWith("ingot")) {
				ingotList.add(ore.substring(5));
			} else if ( ore.startsWith("gem") ) {
				gemList.add(ore.substring(3));
			}
		}
		
		NonNullList<ItemStack> ore,dust,ingot,gem;
		for (String gemElt : gemList) {
			
			gem = OreDictionary.getOres("gem"+gemElt);
			if ( gem.isEmpty() ) continue;
			
			if ( !oreList.isEmpty() && oreList.contains(gemElt) )
				gem.get(0).setCount(2);
				addRecipe(OreDictionary.getOres("ore"+dustList), gem);
		}
		
		for (String dustElt : dustList ) {
			
			dust = OreDictionary.getOres("dust"+dustElt);
			if ( dust.isEmpty() ) continue;
			
			if ( !oreList.isEmpty() && oreList.contains(dustElt) ) 
				dust.get(0).setCount(2);
				addRecipe(OreDictionary.getOres("ore"+dustElt), dust);
			
			if ( !gemList.isEmpty() && gemList.contains(dustElt) )
				dust.get(0).setCount(1);
				addRecipe(OreDictionary.getOres("gem"+dustElt), dust);
			
			if ( !ingotList.isEmpty() && ingotList.contains(dustElt) )
				dust.get(0).setCount(1);
				addRecipe(OreDictionary.getOres("ingot"+dustElt), dust);
			
		}

		addRecipe(recipes, new ItemStack(Blocks.REDSTONE_ORE), new ItemStack(Items.REDSTONE,6));
		addRecipe(recipes, new ItemStack(Blocks.COAL_ORE), new ItemStack(Items.COAL, 3));
		addRecipe(recipes, new ItemStack(Blocks.LAPIS_ORE), new ItemStack(Items.DYE, 8, 4));	
		addRecipe(recipes, new ItemStack(Blocks.DIAMOND_ORE), new ItemStack(Items.DIAMOND, 2));
		addRecipe(recipes, new ItemStack(Blocks.EMERALD_ORE), new ItemStack(Items.EMERALD, 2));
		addRecipe(recipes, new ItemStack(Blocks.QUARTZ_ORE), new ItemStack(Items.QUARTZ, 4));
		
		return true;
	}
	
	private static void addRecipe(NonNullList<ItemStack> input, NonNullList<ItemStack> output) {
		if ( !input.isEmpty() && !output.isEmpty() ) addRecipe(recipes, input.get(0).copy(), output.get(0).copy()); 
	}
}
