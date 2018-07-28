package fr.mru.OverclockedEngineering.Recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public abstract class ARecipeManager {
	
	public static final HashMap<String, List<String>> recipesOrdict = new HashMap<>();
	
	public static boolean initialise() {
		
		List<String> oresstr = new ArrayList<>(),
			     dustsstr = new ArrayList<>(),
			     ingotsstr = new ArrayList<>(),
			     blocksstr = new ArrayList<>(),
			     gemsstr = new ArrayList<>(),
			     nuggetsstr = new ArrayList<>(),
			     gearsstr = new ArrayList<>(),
			     platesstr = new ArrayList<>();
	
		for ( String s : OreDictionary.getOreNames() ) {
			if (s.startsWith("ore")) oresstr.add(s.substring(3));
			else if (s.startsWith("dust")) dustsstr.add(s.substring(4));
			else if (s.startsWith("ingot")) ingotsstr.add(s.substring(5));
			else if (s.startsWith("block")) blocksstr.add(s.substring(5));
			else if (s.startsWith("gem")) gemsstr.add(s.substring(3));
			else if (s.startsWith("nugget")) nuggetsstr.add(s.substring(6));
			else if (s.startsWith("gear")) gearsstr.add(s.substring(4));
			else if (s.startsWith("plate")) platesstr.add(s.substring(5));
		}
		
		recipesOrdict.put("ore", oresstr);
		recipesOrdict.put("dust", dustsstr);
		recipesOrdict.put("ingot", ingotsstr);
		recipesOrdict.put("block", blocksstr);
		recipesOrdict.put("gem", gemsstr);
		recipesOrdict.put("nugget", nuggetsstr);
		recipesOrdict.put("gear", gearsstr);
		recipesOrdict.put("plate", platesstr);

		RecipesGrinder.initialise();
		RecipesAlloy.initialise();
		RecipesTransposer.initialise();
		RecipeRecycler.initialise();
		RecipesTreeFarm.initialise();
		RecipeCompresion.initialise();
		RecipesGear.initialise();
		RecipesPlate.initialise();
		RecipesExtraction.initialise();
		
		return true;
	}
}
