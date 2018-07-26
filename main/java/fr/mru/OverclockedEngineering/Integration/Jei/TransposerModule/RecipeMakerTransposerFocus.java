package fr.mru.OverclockedEngineering.Integration.Jei.TransposerModule;

import java.util.ArrayList;
import java.util.List;

import fr.mru.OverclockedEngineering.Recipes.RecipesTransposer;
import net.minecraft.item.ItemStack;

public class RecipeMakerTransposerFocus {
	
	public static List<RecipeWrapperTransposerFocus> getRecipes(){
		
		List<RecipeWrapperTransposerFocus> list = new ArrayList<>();
		
		for ( List<ItemStack> inputs : RecipesTransposer.getRecipesList() ) {
			
			ItemStack output = RecipesTransposer.getRecipeResult(inputs).getResult();
			list.add(new RecipeWrapperTransposerFocus(inputs, output));
		}
		
		return list;
	}

}
