package fr.mru.OverclockedEngineering.Recipes;

import java.util.HashMap;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipesAlloy extends RecipeManager {
	
	private static final HashMap<ItemStack, HashMap<ItemStack, RecipeRequest>> twoIngotsRecipes = new HashMap<>();
	private static final HashMap<ItemStack, HashMap<ItemStack, HashMap<ItemStack, RecipeRequest>>> threeIngotsRecipes = new HashMap<>();
	
	private static RecipeRequest getTwoIngotsRecipeResult(ItemStack[] ingredients) {
		
		HashMap<ItemStack, RecipeRequest> map2;
		for ( ItemStack in1 : twoIngotsRecipes.keySet()) {
			if ( ItemStackEquals(in1, ingredients[0])) {
				map2 = twoIngotsRecipes.get(in1);
				for ( ItemStack in2 : map2.keySet()) {
					if ( ItemStackEquals(in2, ingredients[1])) {
						return map2.get(in2);
					}
				}
			}
		}
		return RecipeRequest.NULL;
	}
	
	private static RecipeRequest getThreeIngotsRecipeResult(ItemStack[] ingredients) {
		
		HashMap<ItemStack, HashMap<ItemStack, RecipeRequest>> map2;
		HashMap<ItemStack, RecipeRequest> map3;
		for ( ItemStack in1 : threeIngotsRecipes.keySet()) {
			if ( ItemStackEquals(in1, ingredients[0])) {
				map2 = threeIngotsRecipes.get(in1);
				for ( ItemStack in2 : map2.keySet()) {
					if ( ItemStackEquals(in2, ingredients[1])) {
						map3 = map2.get(in2);
						for (ItemStack in3 : map3.keySet()) {
							if ( ItemStackEquals(in3, ingredients[2])) {
								return map3.get(in3);
							}
						}
					}
				}
			}
		}
		return RecipeRequest.NULL;
	}
	
	public static RecipeRequest getRecipeResult(ItemStack[] ingredients) {
		if ( ingredients[0].isEmpty() || ingredients[1].isEmpty()) return RecipeRequest.NULL;
		if ( ingredients[2].isEmpty() ) 
			return getTwoIngotsRecipeResult(new ItemStack[] {ingredients[0],ingredients[1]});
	    return getThreeIngotsRecipeResult(ingredients);
	}
	
	private static void addTwoIngotRecipe(ItemStack in1, ItemStack in2, ItemStack output) {
		
		HashMap<ItemStack, RecipeRequest> map2;
		if ( !twoIngotsRecipes.containsKey(in1) ) twoIngotsRecipes.put(in1, new HashMap<>());
		map2 = twoIngotsRecipes.get(in1);
		map2.put(in2, new RecipeRequest(output, in1, in2));
	}
	
	private static void addThreeIngotRecipe(ItemStack in1, ItemStack in2, ItemStack in3, ItemStack output) {
		
		HashMap<ItemStack, HashMap<ItemStack, RecipeRequest>> map2;
		HashMap<ItemStack, RecipeRequest> map3;
		if ( !threeIngotsRecipes.containsKey(in1) ) threeIngotsRecipes.put(in1, new HashMap<>());
		map2 = threeIngotsRecipes.get(in1);
		if ( !map2.containsKey(in2) ) map2.put(in2, new HashMap<>());
		map3 = map2.get(in2);
		map3.put(in3, new RecipeRequest(output, in1, in2, in3));
	}
	
	private static void addTwoIngotRecipe(String in1, int amount1, String in2, int amount2, String out, int amount) {
		ItemStack output = OreDictionary.getOres(out).get(0);
		output.setCount(amount);
		for (ItemStack input1 : OreDictionary.getOres(in1)) {
			input1.setCount(amount1);
			for (ItemStack input2 : OreDictionary.getOres(in2)) {
				input2.setCount(amount2);
				addTwoIngotRecipe(input1, input2, output);
				addTwoIngotRecipe(input2, input1, output);
			}
		}	
	}
	
	private static void addThreeIngotRecipe(String in1, int amount1, String in2, int amount2, String in3, int amount3, String out, int amount) {
		ItemStack output = OreDictionary.getOres(out).get(0);
		output.setCount(amount);
		for (ItemStack input1 : OreDictionary.getOres(in1)) {
			input1.setCount(amount1);
			for (ItemStack input2 : OreDictionary.getOres(in2)) {
				input2.setCount(amount2);
				for (ItemStack input3 : OreDictionary.getOres(in3)) {
					input3.setCount(amount3);
					addThreeIngotRecipe(input1, input2, input3, output);
					addThreeIngotRecipe(input1, input3, input2, output);
					addThreeIngotRecipe(input2, input1, input3, output);
					addThreeIngotRecipe(input2, input3, input1, output);
					addThreeIngotRecipe(input3, input1, input2, output);
					addThreeIngotRecipe(input3, input1, input2, output);
				}
			}
		}	
	}
	
	public static boolean initialise() {
	
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
			addThreeIngotRecipe("ingotCopper", 3, "ingotSilver", 1, "redstone", 10, "ingotSignalium", 4);

		return true;
	}
}
