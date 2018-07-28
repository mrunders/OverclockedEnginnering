package fr.mru.OverclockedEngineering.Integration.Jei.ExtractionModule;

import java.util.ArrayList;
import java.util.List;

import fr.mru.OverclockedEngineering.Recipes.RecipesExtraction;
import net.minecraft.item.ItemStack;

public class RecipeMakerExtractionFocus {
	
	public static List<RecipeWrapperExtractionFocus> getRecipes(){
		
		List<RecipeWrapperExtractionFocus> list = new ArrayList<>();
		
		for ( List<ItemStack> inputs : RecipesExtraction.getRecipesMap() ) {
			
			ItemStack output = RecipesExtraction.getRecipeResultForInput(inputs.get(0)).getResult();
			list.add(new RecipeWrapperExtractionFocus(inputs, output));
		}
		
		return list;
	}

}
