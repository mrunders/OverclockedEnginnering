package fr.mru.OverclockedEngineering.Integration.Jei.TransposerModule;

import java.util.ArrayList;
import java.util.List;

import fr.mru.OverclockedEngineering.Integration.Jei.TreeFarmer.RecipeWrapperTreeFarmer;
import fr.mru.OverclockedEngineering.Recipes.RecipesTransposer;
import fr.mru.OverclockedEngineering.Recipes.RecipesTreeFarm;
import net.minecraft.item.ItemStack;

public class RecipeMakerTransposerFocus {
	
	public static List<RecipeWrapperTransposerFocus> getRecipes(){
		
		List<RecipeWrapperTransposerFocus> list = new ArrayList<>();
		
		for ( ItemStack[] a : RecipesTransposer.getRecipesList().keySet() ) {
			
			/*List<ItemStack> inputs = new ArrayList<>();
			
			inputs.add(a[0]);
			
			ItemStack output = RecipesTransposer.getRecipeResult(a).getResult();
			
			list.add(new RecipeWrapperTransposerFocus(inputs, output));*/
		}
		
		return list;
	}

}
