package fr.mru.OverclockedEngineering.Integration.Jei.PlateModule;

import java.util.ArrayList;
import java.util.List;

import fr.mru.OverclockedEngineering.Recipes.RecipesPlate;
import net.minecraft.item.ItemStack;

public class RecipeMakerPlateFocus {
	
	public static List<RecipeWrapperPlateFocus> getRecipes(){
		
		List<RecipeWrapperPlateFocus> list = new ArrayList<>();
		
		for ( List<ItemStack> inputs : RecipesPlate.getRecipesMap() ) {
			
			ItemStack output = RecipesPlate.getRecipeResult(inputs.get(0)).getResult();
			list.add(new RecipeWrapperPlateFocus(inputs, output));
		}
		
		return list;
	}

}
