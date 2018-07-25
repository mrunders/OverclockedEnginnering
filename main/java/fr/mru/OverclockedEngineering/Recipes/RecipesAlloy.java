package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipesAlloy extends RecipeManager {
	
	public static final RecipeRequestMap map = new RecipeRequestMap();
	
	public static RecipeRequest getRecipeResult(ItemStack[] ingredients) {
		return map.gett(ingredients[0], ingredients[1]);
	}
	
	public static boolean initialise() {
		
		if ( OreDictionary.doesOreNameExist("ingotElectrum") ) 
			map.puttCopyOreDict("ingotElectrum", 2, "ingotSilver", 1, "ingotGold", 1);
		
		if ( OreDictionary.doesOreNameExist("ingotSteel") )
			map.puttCopyOreDict("ingotSteel", 1, "ingotIron", 1, "coal", 2);
		
		if ( OreDictionary.doesOreNameExist("ingotInvar") )
			map.puttCopyOreDict("ingotInvar", 3, "ingotIron", 2, "ingotNickel", 1);
		
		if ( OreDictionary.doesOreNameExist("ingotBronze") )
			map.puttCopyOreDict("ingotBronze", 4, "ingotTin", 1, "ingotCopper", 3);
		
		if ( OreDictionary.doesOreNameExist("ingotConstantan") )
			map.puttCopyOreDict("ingotConstantan", 2, "ingotNickel", 1, "ingotCopper", 1);
		
		return true;
	}

	public static RecipeRequestMap getRecipesList() {
		return map;
	}

	public static RecipeRequest getResultForInputs(List<ItemStack> a) {
		return map.gett(a.get(0), a.get(1));
	}

}
