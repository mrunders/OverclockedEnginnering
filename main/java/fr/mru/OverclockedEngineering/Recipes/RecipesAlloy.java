package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipesAlloy extends AMultiItemsRecipe {
	
	public static RecipeRequest getRecipeResult(ItemStack[] ingredients) {
		if ( ingredients[0].isEmpty() || ingredients[1].isEmpty()) 
			return RecipeRequest.NULL;
		if ( ingredients[2].isEmpty() ) 
			return getTwoIngotsRecipeResult(new ItemStack[] {ingredients[0],ingredients[1]});
		
	    return getThreeIngotsRecipeResult(ingredients);
	}
	
	public static boolean initialise() {
		
		if ( recipes.isEmpty() ) return true;
	
		if ( OreDictionary.doesOreNameExist("ingotElectrum") ) 
			addTwoIngotRecipe("ingotSilver", 1, "ingotGold", 1, "ingotElectrum", 2);
		
		if ( OreDictionary.doesOreNameExist("ingotSteel") )
			addTwoIngotRecipe("ingotIron", 1, "coal", 2, "ingotSteel", 1);
		
		if ( OreDictionary.doesOreNameExist("ingotInvar") )
			addTwoIngotRecipe("ingotIron", 2, "ingotNickel", 1, "ingotInvar", 3);
		
		if ( OreDictionary.doesOreNameExist("ingotBronze") )
			addTwoIngotRecipe("ingotTin", 1, "ingotCopper", 3, "ingotBronze", 4);
		
		if ( OreDictionary.doesOreNameExist("ingotConstantan") )
			addTwoIngotRecipe("ingotNickel", 1, "ingotCopper", 1, "ingotConstantan", 2);
		
		if ( OreDictionary.doesOreNameExist("ingotSignalium") )
			addThreeIngotRecipe("ingotCopper", 3, "ingotSilver", 1, "dustRedstone", 10, "ingotSignalium", 4);

		return true;
	}
}
