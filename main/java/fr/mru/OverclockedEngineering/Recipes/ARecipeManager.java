package fr.mru.OverclockedEngineering.Recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cofh.thermalexpansion.util.managers.machine.FurnaceManager.FurnaceRecipe;
import fr.mru.OverclockedEngineeringItems.OverclockedEngineeringItemsBase;
import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import fr.mru.OverclockedengineeringBlocks.OverclockedEngineeringBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public abstract class ARecipeManager implements IRecipeManager {
	
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
		
		oresstr.remove("Quartz");
		gemsstr.remove("Quartz");
		
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
		RecipesPCB.initialise();
		RecipesSawmill.initialise();
		
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(OverclockedEngineeringBlocks.STRUCTURE_SHIP_BLOCK, new ItemStack(OverclokedEngineeringItems.INGOT_SHIP), 2.0f);
		
		return true;
	}
}
