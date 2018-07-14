package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.function.BiFunction;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;
import scala.tools.nsc.transform.patmat.Logic.PropositionalLogic.Or;

public class RecipesAlloy extends RecipeManager {
	
	public static final HashMap <ItemStack[], ItemStack>recipes = new HashMap<ItemStack[], ItemStack>();
	public static final HashMap<ItemStack, HashMap<ItemStack, ItemStack>> twoIngotsRecipes = new HashMap<>();
	
	static {

	}
	
	public static ItemStack getTwoIngotsRecipeResult(ItemStack[] ingredients) {
		
		HashMap<ItemStack, ItemStack> map2;
		for ( ItemStack in1 : twoIngotsRecipes.keySet()) {
			if ( ItemStackEquals(in1, ingredients[0])) {
				map2 = twoIngotsRecipes.get(in1);
				for ( ItemStack in2 : map2.keySet()) {
					if ( ItemStackEquals(in2, ingredients[1])) {
						return map2.get(in2);
					}
				}
				
				return null;
			}
		}
		return null;
	}
	
	public static ItemStack getRecipeResult(ItemStack[] ingredients) {
		if ( ingredients[0].isEmpty() || ingredients[1].isEmpty()) return null;
		if ( ingredients[2].isEmpty() ) 
			return getTwoIngotsRecipeResult(new ItemStack[] {ingredients[0],ingredients[1]});
	    return getRecipeResult(recipes, ingredients);
	    
	}
	
	private static void addTwoIngotRecipe(ItemStack in1, ItemStack in2, ItemStack output) {
		
		HashMap<ItemStack, ItemStack> map2;
		if ( !twoIngotsRecipes.containsKey(in1) ) twoIngotsRecipes.put(in1, new HashMap<>());
		map2 = twoIngotsRecipes.get(in1);
		map2.put(in2, output);
	}
	
	public static boolean initialise() {
	
		if ( OreDictionary.doesOreNameExist("ingotElectrum") ) {
			ItemStack electrum = OreDictionary.getOres("ingotElectrum").get(0).copy();
			electrum.setCount(2);
			addTwoIngotRecipe(OreDictionary.getOres("ingotSilver").get(0), new ItemStack(Items.GOLD_INGOT), electrum);
			addTwoIngotRecipe(new ItemStack(Items.GOLD_INGOT), OreDictionary.getOres("ingotSilver").get(0), electrum);
		}
		
		if ( OreDictionary.doesOreNameExist("ingotSteel") ) {
			ItemStack coal = new ItemStack(Items.COAL, 2);
			ItemStack iron = new ItemStack(Items.IRON_INGOT);
			ItemStack steel = OreDictionary.getOres("ingotSteel").get(0);
			addTwoIngotRecipe(coal, iron, steel);
			addTwoIngotRecipe(iron, coal, steel);
		}
		
		if ( OreDictionary.doesOreNameExist("ingotInvar") ) {
			ItemStack iron = new ItemStack(Items.IRON_INGOT, 2);
			ItemStack nickel = OreDictionary.getOres("ingotNickel").get(0);
			ItemStack invar = OreDictionary.getOres("ingotInvar").get(0).copy();
			invar.setCount(3);
			addTwoIngotRecipe(iron, nickel, invar);
			addTwoIngotRecipe(nickel, iron, invar);
			
		}

		return true;
	}
}
