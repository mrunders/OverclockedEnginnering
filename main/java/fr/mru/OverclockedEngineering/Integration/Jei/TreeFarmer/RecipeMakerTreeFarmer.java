package fr.mru.OverclockedEngineering.Integration.Jei.TreeFarmer;

import java.util.ArrayList;
import java.util.List;

import fr.mru.OverclockedEngineering.Recipes.RecipesTreeFarm;
import net.minecraft.item.ItemStack;

public class RecipeMakerTreeFarmer {
	
	public static List<RecipeWrapperTreeFarmer> getRecipes(){
		
		List<RecipeWrapperTreeFarmer> list = new ArrayList<>();
		
		for ( List<ItemStack> inputs : RecipesTreeFarm.getRecipesMap() ) {

			ItemStack output = RecipesTreeFarm.getRecipeResult(inputs.get(0)).getResult();
			list.add(new RecipeWrapperTreeFarmer(inputs, output));
		}
		
		return list;
	}

}
