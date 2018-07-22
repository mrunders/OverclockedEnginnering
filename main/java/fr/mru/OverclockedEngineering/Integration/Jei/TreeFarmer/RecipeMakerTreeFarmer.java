package fr.mru.OverclockedEngineering.Integration.Jei.TreeFarmer;

import java.util.ArrayList;
import java.util.List;

import fr.mru.OverclockedEngineering.Recipes.RecipesTreeFarm;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeMakerTreeFarmer {
	
	public static List<RecipeWrapperTreeFarmer> getRecipes(){
		
		List<RecipeWrapperTreeFarmer> list = new ArrayList<>();
		
		for ( ItemStack a : RecipesTreeFarm.getRecipesMap().keySet() ) {
			
			List<ItemStack> inputs = new ArrayList<>();
			
			inputs.add(a);
			
			ItemStack output = RecipesTreeFarm.getRecipeResult(a);
			
			list.add(new RecipeWrapperTreeFarmer(inputs, output));
		}
		
		return list;
	}

}
