package fr.mru.OverclockedEngineering.Recipes;

import java.util.PriorityQueue;

import org.apache.logging.log4j.core.util.Loader;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

public class RecipesGrinder extends RecipeManager {
	
	public static RecipeRequest getRecipeResult(ItemStack[] ingredients) {
		ItemStack ingr0 = ingredients[0].copy();
		ingr0.setCount(1);
	    return new RecipeRequest(getRecipeResult(recipes, new ItemStack[] {ingredients[0]}), ingr0);
	    
	}
	
	public static boolean initialise() {
		
		if ( recipes.isEmpty() ) return true;
		
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
			
			gem = NonNullList.create();
			for (ItemStack g : OreDictionary.getOres("gem"+gemElt)) 
				gem.add(g.copy());
			
			if ( gem.isEmpty() ) continue;
			
			if ( !oreList.isEmpty() && oreList.contains(gemElt) ) {
				gem.get(0).setCount(2);
				addRecipe(OreDictionary.getOres("ore"+dustList), gem);
			}
		}
		
		for (String dustElt : dustList ) {
			
			dust = NonNullList.create();
			for (ItemStack g : OreDictionary.getOres("gem"+dustElt)) 
				dust.add(g.copy());
			
			if ( dust.isEmpty() ) continue;
			
			if ( !oreList.isEmpty() && oreList.contains(dustElt) ) 
				dust.get(0).setCount(2);
				addRecipe(OreDictionary.getOres("ore"+dustElt), dust);
			
			if ( !gemList.isEmpty() && gemList.contains(dustElt) )
				addRecipe(OreDictionary.getOres("gem"+dustElt), dust);
			
			if ( !ingotList.isEmpty() && ingotList.contains(dustElt) )
				addRecipe(OreDictionary.getOres("ingot"+dustElt), dust);
			
		}

		addRecipe(recipes, Blocks.COBBLESTONE, Blocks.GRAVEL);
		addRecipe(recipes, Blocks.GRAVEL, Blocks.SAND);
		addRecipe(recipes, new ItemStack(Blocks.REDSTONE_ORE), new ItemStack(Items.REDSTONE,6));
		addRecipe(recipes, new ItemStack(Blocks.COAL_ORE), new ItemStack(Items.COAL, 3));
		addRecipe(recipes, new ItemStack(Blocks.LAPIS_ORE), new ItemStack(Items.DYE, 8, 4));	
		addRecipe(recipes, new ItemStack(Blocks.DIAMOND_ORE), new ItemStack(Items.DIAMOND, 2));
		addRecipe(recipes, new ItemStack(Blocks.EMERALD_ORE), new ItemStack(Items.EMERALD, 2));
		addRecipe(recipes, new ItemStack(Blocks.QUARTZ_ORE), new ItemStack(Items.QUARTZ, 4));
		
		if ( Loader.isClassAvailable("thermalexpansion") ) {
			ItemStack dustObsidian = OreDictionary.getOres("dustObsidian").get(0).copy();
			dustObsidian.setCount(4);
			addRecipe(recipes, OreDictionary.getOres("obsidian").get(0), dustObsidian);
		}
		
		return true;
	}
	
	private static void addRecipe(NonNullList<ItemStack> input, NonNullList<ItemStack> output) {
		if ( input.isEmpty() || output.isEmpty() ) return;
		for ( ItemStack in : input)
			addRecipe(recipes, in , output.get(0).copy()); 
	}
}
