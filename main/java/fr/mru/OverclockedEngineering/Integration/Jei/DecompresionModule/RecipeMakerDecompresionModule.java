package fr.mru.OverclockedEngineering.Integration.Jei.DecompresionModule;

import java.util.ArrayList;
import java.util.List;

import fr.mru.OverclockedEngineering.Recipes.RecipeCompresion;
import fr.mru.OverclockedEngineering.Recipes.RecipesDecompresion;
import net.minecraft.item.ItemStack;

public class RecipeMakerDecompresionModule {
	
	public static List<RecipeWrapperDecompresionFocus> getRecipes(){
		
		List<RecipeWrapperDecompresionFocus> list = new ArrayList<>();
		
		for ( List<ItemStack> inputs : RecipeCompresion.getReversedRecipesList() ) {
			
			ItemStack output = RecipesDecompresion.getRecipeResult(inputs.get(0)).getResult();
			list.add(new RecipeWrapperDecompresionFocus(inputs, output));
		}
		
		return list;
	}

}
