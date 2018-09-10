package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipesAlloy extends ARecipeManager {
	
	private static RecipeRequestMap map = new RecipeRequestMap();
	
	public static RecipeRequest getRecipeResult(ItemStack... ingredients) {
		return map.get(ingredients);
	}
	
	public static boolean initialise() {
		
		map.putCopy(new ItemStack(OverclokedEngineeringItems.INGOT_STEEL), 1, 
				    new ItemStack(Items.COAL), 3, new ItemStack(Items.IRON_INGOT), 1);
		
		if ( OreDictionary.doesOreNameExist("ingotElectrum") ) 
			map.putCopyOredict("ingotElectrum", 2, "ingotSilver", 1, "ingotGold", 1);
		
		if ( OreDictionary.doesOreNameExist("ingotInvar") )
			map.putCopyOredict("ingotInvar", 3, "ingotIron", 2, "ingotNickel", 1);
		
		if ( OreDictionary.doesOreNameExist("ingotBronze") )
			map.putCopyOredict("ingotBronze", 4, "ingotTin", 1, "ingotCopper", 3);
		
		if ( OreDictionary.doesOreNameExist("ingotConstantan") )
			map.putCopyOredict("ingotConstantan", 2, "ingotNickel", 1, "ingotCopper", 1);
		
		return true;
	}

	public static Set<List<ItemStack>> getRecipesList() {
		return map.keySet();
	}



}
