package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;
import java.util.function.BiFunction;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;

public class AlloyRecipes extends RecipeManager {
	
	public static final HashMap <ItemStack[], ItemStack>recipes = new HashMap<ItemStack[], ItemStack>();
	
	static {

	}
	
	public static ItemStack getRecipeResult(ItemStack[] ingredients) {
		if ( ingredients[0].isEmpty() || ingredients[1].isEmpty()) 
			return null;
		if ( ingredients[2].isEmpty() ) 
			return getRecipeResult(recipes, new ItemStack[] {ingredients[0],ingredients[1]});
	    return getRecipeResult(recipes, ingredients);
	    
	}
	
	public static boolean initialise() {
	
		BiFunction<String, Integer, ItemStack> fromOrDict = (ore,amount) -> {ItemStack item = OreDictionary.getOres(ore).get(0).copy(); item.setCount(amount); return item;};
		
		if ( Loader.isModLoaded("thermalfoundation") ) {
			ItemStack[] ingotInvar = { new ItemStack(Items.IRON_INGOT, 2), fromOrDict.apply("ingotNickel", 1)},
						ingotElectrum = { new ItemStack(Items.GOLD_INGOT), fromOrDict.apply("ingotSilver", 1)},
						ingotBronze = { fromOrDict.apply("ingotCopper", 3), fromOrDict.apply("ingotTin", 1)},
						ingotConstantan = { fromOrDict.apply("ingotCopper", 1), fromOrDict.apply("ingotNickel", 1)},
						ingotSteel = { new ItemStack(Items.IRON_INGOT, 1), new ItemStack(Items.COAL, 2) },
						ingotSignalum = { fromOrDict.apply("ingotCopper", 3), fromOrDict.apply("ingotSilver", 1), new ItemStack(Items.REDSTONE, 10)},
						ingotLumium = { fromOrDict.apply("ingotTin", 3), fromOrDict.apply("ingotSilver", 1), new ItemStack(Items.GLOWSTONE_DUST, 4)},
						ingotEnderium = { fromOrDict.apply("ingotPlatinum", 3), fromOrDict.apply("ingotLead", 1), new ItemStack(Items.ENDER_PEARL, 4)};
			
			recipes.put(ingotInvar, fromOrDict.apply("ingotInvar", 3));
			recipes.put(ingotElectrum, fromOrDict.apply("ingotElectrum", 2));
			recipes.put(ingotBronze, fromOrDict.apply("ingotBronze", 4));
			recipes.put(ingotSteel, fromOrDict.apply("ingotSteel", 1));
			recipes.put(ingotConstantan, fromOrDict.apply("ingotConstantan", 2));
			recipes.put(ingotSignalum, fromOrDict.apply("ingotSignalum", 4));
			recipes.put(ingotLumium, fromOrDict.apply("ingotLumium", 4));
			recipes.put(ingotEnderium, fromOrDict.apply("ingotEnderium", 4));
			
		}

		return true;
	}
}
